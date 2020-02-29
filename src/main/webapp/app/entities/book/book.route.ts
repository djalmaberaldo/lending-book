import { Injectable } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
import { Resolve, ActivatedRouteSnapshot, Routes, Router } from '@angular/router';
import { Observable, of, EMPTY } from 'rxjs';
import { flatMap } from 'rxjs/operators';

import { UserRouteAccessService } from 'app/core/auth/user-route-access-service';
import { IBook, Book } from 'app/shared/model/book.model';
import { BookService } from './book.service';
import { BookComponent } from './book.component';
import { BookDetailComponent } from './book-detail.component';
import { BookUpdateComponent } from './book-update.component';
import { JhiResolvePagingParams } from 'app/shared/util/paging-params.service';

@Injectable({ providedIn: 'root' })
export class BookResolve implements Resolve<IBook> {
    constructor(private service: BookService, private router: Router) {}

    resolve(route: ActivatedRouteSnapshot): Observable<IBook> | Observable<never> {
        const id = route.params['id'];
        if (id) {
            return this.service.find(id).pipe(
                flatMap((book: HttpResponse<Book>) => {
                    if (book.body) {
                        return of(book.body);
                    } else {
                        this.router.navigate(['404']);
                        return EMPTY;
                    }
                })
            );
        }
        return of(new Book());
    }
}

export const bookRoute: Routes = [
    {
        path: 'book',
        component: BookComponent,
        resolve: {
            pagingParams: JhiResolvePagingParams
        },
        data: {
            authorities: ['ROLE_USER'],
            defaultSort: 'id,asc',
            pageTitle: 'Books'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'book/:id/view',
        component: BookDetailComponent,
        resolve: {
            book: BookResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Books'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'book/new',
        component: BookUpdateComponent,
        resolve: {
            book: BookResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Books'
        },
        canActivate: [UserRouteAccessService]
    },
    {
        path: 'book/:id/edit',
        component: BookUpdateComponent,
        resolve: {
            book: BookResolve
        },
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'Books'
        },
        canActivate: [UserRouteAccessService]
    }
];
