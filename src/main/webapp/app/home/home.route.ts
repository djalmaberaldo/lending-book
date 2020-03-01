import { Route } from '@angular/router';
import { JhiResolvePagingParams } from 'app/shared/util/paging-params.service';

import { HomeComponent } from './';

export const HOME_ROUTE: Route = {
    path: '',
    component: HomeComponent,
    resolve: {
        pagingParams: JhiResolvePagingParams
    },
    data: {
        authorities: [],
        pageTitle: 'Welcome, Java Hipster!'
    }
};
