import { Component, OnInit } from '@angular/core';
import { NgbModalRef } from '@ng-bootstrap/ng-bootstrap';

import { LoginModalService, AccountService, Account } from 'app/core';
import { JhiEventManager } from 'app/shared/util/event-manager';
import { BookService } from 'app/entities/book/book.service';
import { HttpResponse, HttpHeaders } from '@angular/common/http';
import { IBook } from 'app/shared/model/book.model';
import { Subscription } from 'rxjs';
import { ITEMS_PER_PAGE } from 'app/shared';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
    selector: 'jhi-home',
    templateUrl: './home.component.html',
    styleUrls: ['home.scss']
})
export class HomeComponent implements OnInit {
    account: Account;
    modalRef: NgbModalRef;
    books?: IBook[];
    eventSubscriber?: Subscription;
    totalItems = 0;
    itemsPerPage = ITEMS_PER_PAGE;
    page!: number;
    predicate!: string;
    ascending!: boolean;
    ngbPaginationPage = 1;

    constructor(
        private accountService: AccountService,
        private loginModalService: LoginModalService,
        private eventManager: JhiEventManager,
        private bookService: BookService,
        protected activatedRoute: ActivatedRoute,
        protected router: Router
    ) {}

    loadPage(page?: number): void {
        const pageToLoad: number = page || this.page;

        this.bookService
            .findBorrowedBooks({
                page: pageToLoad - 1,
                size: this.itemsPerPage,
                sort: this.sort()
            })
            .subscribe((res: HttpResponse<IBook[]>) => this.onSuccess(res.body, res.headers, pageToLoad), () => this.onError());
    }

    ngOnInit() {
        this.activatedRoute.data.subscribe(data => {
            this.page = data.pagingParams.page;
            this.ascending = data.pagingParams.ascending;
            this.predicate = data.pagingParams.predicate;
            this.ngbPaginationPage = data.pagingParams.page;
            this.loadPage();
        });
        this.accountService.identity().then(account => {
            this.account = account;
        });
        this.registerAuthenticationSuccess();
    }

    registerAuthenticationSuccess() {
        this.eventManager.subscribe('authenticationSuccess', message => {
            this.accountService.identity().then(account => {
                this.account = account;
            });
        });
    }

    isAuthenticated() {
        return this.accountService.isAuthenticated();
    }

    login() {
        this.modalRef = this.loginModalService.open();
    }

    sort(): string[] {
        const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
        if (this.predicate !== 'id') {
            result.push('id');
        }
        return result;
    }

    protected onSuccess(data: IBook[] | null, headers: HttpHeaders, page: number): void {
        this.totalItems = Number(headers.get('X-Total-Count'));
        this.page = page;
        this.books = data || [];
    }

    protected onError(): void {
        console.log('jsjdsajdsa');
    }
}
