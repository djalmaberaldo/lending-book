import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { map, filter } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { ILending, Lending } from 'app/shared/model/lending.model';
import { LendingService } from './lending.service';
import { IBook } from 'app/shared/model/book.model';
import { BookService } from 'app/entities/book/book.service';
import { IUser, UserService } from 'app/core';

@Component({
    selector: 'jhi-lending-update',
    templateUrl: './lending-update.component.html'
})
export class LendingUpdateComponent implements OnInit {
    isSaving = false;
    books: IBook[] = [];
    users: IUser[] = [];
    currentLending = new Lending();

    editForm = this.fb.group({
        id: [],
        lendDate: [],
        isActive: [],
        bookId: [],
        userId: []
    });

    constructor(
        protected lendingService: LendingService,
        protected bookService: BookService,
        protected userService: UserService,
        protected activatedRoute: ActivatedRoute,
        private fb: FormBuilder
    ) {}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe(({ lending }) => {
            if (!lending.id) {
                const today = moment().startOf('day');
                lending.lendDate = today;
            } else {
                this.currentLending = lending;
            }

            this.updateForm(lending);

            this.bookService
                .query({ filter: 'lending-is-null' })
                .pipe(
                    map((res: HttpResponse<IBook[]>) => {
                        return res.body || [];
                    })
                )
                .subscribe((resBody: IBook[]) => {
                    if (!lending.bookId) {
                        this.books = resBody;
                    } else {
                        this.bookService
                            .find(lending.bookId)
                            .pipe(
                                map((subRes: HttpResponse<IBook>) => {
                                    return subRes.body ? [subRes.body].concat(resBody) : resBody;
                                })
                            )
                            .subscribe((concatRes: IBook[]) => (this.books = concatRes.filter(item => item.activeLending === false)));
                    }
                });

            this.bookService.query().subscribe((res: HttpResponse<IBook[]>) => (this.books = res.body || []));

            this.userService
                .query()
                .pipe(
                    map((res: HttpResponse<IUser[]>) => {
                        return res.body || [];
                    })
                )
                .subscribe((resBody: IUser[]) => {
                    if (!lending.userId) {
                        this.users = resBody;
                    } else {
                        this.userService
                            .find(lending.userId)
                            .pipe(
                                map((subRes: HttpResponse<IUser>) => {
                                    return subRes.body ? [subRes.body].concat(resBody) : resBody;
                                })
                            )
                            .subscribe((concatRes: IUser[]) => (this.users = concatRes));
                    }
                });
        });
    }

    updateForm(lending: ILending): void {
        this.editForm.patchValue({
            id: lending.id,
            lendDate: lending.lendDate ? lending.lendDate.format(DATE_TIME_FORMAT) : null,
            isActive: lending.isActive,
            bookId: lending.bookId,
            userId: lending.userId
        });
    }

    previousState(): void {
        window.history.back();
    }

    save(): void {
        this.isSaving = true;
        const lending = this.createFromForm();
        console.log(lending);
        if (lending.id !== null) {
            this.subscribeToSaveResponse(this.lendingService.update(lending));
        } else {
            this.subscribeToSaveResponse(this.lendingService.create(lending));
        }
    }

    private createFromForm(): ILending {
        return {
            ...new Lending(),
            id: this.editForm.get(['id'])!.value,
            lendDate: this.editForm.get(['lendDate'])!.value ? moment(this.editForm.get(['lendDate'])!.value, DATE_TIME_FORMAT) : undefined,
            isActive: this.editForm.get(['isActive'])!.value,
            bookId: this.editForm.get(['bookId'])!.value,
            userId: this.editForm.get(['userId'])!.value
        };
    }

    protected subscribeToSaveResponse(result: Observable<HttpResponse<ILending>>): void {
        result.subscribe(() => this.onSaveSuccess(), x => this.onSaveError(x));
    }

    protected onSaveSuccess(): void {
        this.isSaving = false;
        this.previousState();
    }

    protected onSaveError(x): void {
        this.isSaving = false;
        alert(x.error.title);
    }

    trackById(index: number, item: IBook): any {
        return item.id;
    }

    trackUserById(index: number, item: IUser): any {
        return item.id;
    }
}
