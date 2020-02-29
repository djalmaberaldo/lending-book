import { ActivatedRouteSnapshot, RouterStateSnapshot, Resolve } from '@angular/router';
import { Injectable } from '@angular/core';
import { JhiPaginationUtil } from './pagination-util.service';

@Injectable({
    providedIn: 'root'
})
export class JhiResolvePagingParams implements Resolve<any> {
    constructor(private paginationUtil: JhiPaginationUtil) {}

    resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
        const page = route.queryParams['page'] ? route.queryParams['page'] : '1';
        const defaultSort = route.data['defaultSort'] ? route.data['defaultSort'] : 'id,asc';
        const sort = route.queryParams['sort'] ? route.queryParams['sort'] : defaultSort;
        return {
            page: this.paginationUtil.parsePage(page),
            predicate: this.paginationUtil.parsePredicate(sort),
            ascending: this.paginationUtil.parseAscending(sort)
        };
    }
}
