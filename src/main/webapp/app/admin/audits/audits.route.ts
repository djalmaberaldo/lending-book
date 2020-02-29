import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Route } from '@angular/router';

import { AuditsComponent } from './audits.component';
import { JhiResolvePagingParams } from 'app/shared/util/paging-params.service';

export const auditsRoute: Route = {
    path: 'audits',
    component: AuditsComponent,
    resolve: {
        pagingParams: JhiResolvePagingParams
    },
    data: {
        pageTitle: 'Audits',
        defaultSort: 'auditEventDate,desc'
    }
};
