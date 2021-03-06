import { Component, OnInit, OnDestroy } from '@angular/core';
import { HttpHeaders, HttpResponse } from '@angular/common/http';
import { ActivatedRoute, Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';

import { ILending } from 'app/shared/model/lending.model';

import { ITEMS_PER_PAGE } from 'app/shared/constants/pagination.constants';
import { LendingService } from './lending.service';
import { LendingDeleteDialogComponent } from './lending-delete-dialog.component';
import { JhiEventManager } from 'app/shared/util/event-manager';

@Component({
    selector: 'jhi-lending',
    templateUrl: './lending.component.html'
})
export class LendingComponent implements OnInit, OnDestroy {
    lendings?: ILending[];
    eventSubscriber?: Subscription;
    totalItems = 0;
    itemsPerPage = ITEMS_PER_PAGE;
    page!: number;
    predicate!: string;
    ascending!: boolean;
    ngbPaginationPage = 1;
    serviceDone = false;

    constructor(
        protected lendingService: LendingService,
        protected activatedRoute: ActivatedRoute,
        protected router: Router,
        protected eventManager: JhiEventManager,
        protected modalService: NgbModal
    ) {}

    loadPage(page?: number): void {
        const pageToLoad: number = page || this.page;

        this.lendingService
            .query({
                page: pageToLoad - 1,
                size: this.itemsPerPage,
                sort: this.sort()
            })
            .subscribe((res: HttpResponse<ILending[]>) => this.onSuccess(res.body, res.headers, pageToLoad), () => this.onError());
    }

    ngOnInit(): void {
        this.activatedRoute.data.subscribe(data => {
            this.page = data.pagingParams.page;
            this.ascending = data.pagingParams.ascending;
            this.predicate = data.pagingParams.predicate;
            this.ngbPaginationPage = data.pagingParams.page;
            this.loadPage();
        });
        this.registerChangeInLendings();
    }

    ngOnDestroy(): void {
        if (this.eventSubscriber) {
            this.eventManager.destroy(this.eventSubscriber);
        }
    }

    trackId(index: number, item: ILending): number {
        // eslint-disable-next-line @typescript-eslint/no-unnecessary-type-assertion
        return item.id!;
    }

    registerChangeInLendings(): void {
        this.eventSubscriber = this.eventManager.subscribe('lendingListModification', () => this.loadPage());
    }

    delete(lending: ILending): void {
        const modalRef = this.modalService.open(LendingDeleteDialogComponent, { size: 'lg', backdrop: 'static' });
        modalRef.componentInstance.lending = lending;
    }

    sort(): string[] {
        const result = [this.predicate + ',' + (this.ascending ? 'asc' : 'desc')];
        if (this.predicate !== 'id') {
            result.push('id');
        }
        return result;
    }

    protected onSuccess(data: ILending[] | null, headers: HttpHeaders, page: number): void {
        this.totalItems = Number(headers.get('X-Total-Count'));
        this.page = page;
        this.router.navigate(['/lending'], {
            queryParams: {
                page: this.page,
                size: this.itemsPerPage,
                sort: this.predicate + ',' + (this.ascending ? 'asc' : 'desc')
            }
        });
        this.lendings = data || [];
        this.serviceDone = true;
    }

    protected onError(): void {
        this.ngbPaginationPage = this.page;
    }
}
