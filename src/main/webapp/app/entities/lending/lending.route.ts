import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { ILending, Lending } from 'app/shared/model/lending.model';
import { LendingService } from './lending.service';
import { LendingComponent } from './lending.component';
import { LendingDetailComponent } from './lending-detail.component';
import { LendingUpdateComponent } from './lending-update.component';
import { JhiResolvePagingParams } from 'app/shared/util/paging-params.service';

@Injectable({ providedIn: 'root' })
export class LendingResolve implements Resolve<ILending> {
    constructor(private service: LendingService, private router: Router) {}

    resolve(route: ActivatedRouteSnapshot): Observable<ILending> | Observable<never> {
        const id = route.params['id'];
        if (id) {
            return this.service.find(id).pipe(
                flatMap((lending: HttpResponse<Lending>) => {
                    if (lending.body) {
                        return of(lending.body);
                    } else {
                        this.router.navigate(['404']);
                        return EMPTY;
                    }
                })
            );
        }
        return of(new Lending());
    }
}

export const lendingRoute: Routes = [
    {
        path: '',
        component: LendingComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'Lendings'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/view',
        component: LendingDetailComponent,
        resolve: {
            lending: LendingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Lendings'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'new',
        component: LendingUpdateComponent,
        resolve: {
            lending: LendingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Lendings'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: ':id/edit',
        component: LendingUpdateComponent,
        resolve: {
            lending: LendingResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Lendings'
        },
        canActivate: [UserRouteAccessService]
    }
];
