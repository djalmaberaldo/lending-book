import { Routes } from '@angular/router';

import { configurationRoute, docsRoute, userMgmtRoute } from './';

import { UserRouteAccessService } from 'app/core';

const ADMIN_ROUTES = [configurationRoute, docsRoute, ...userMgmtRoute];

export const adminState: Routes = [
    {
        path: '',
        data: {
            authorities: ['ROLE_ADMIN']
        },
        canActivate: [UserRouteAccessService],
        children: ADMIN_ROUTES
    }
];
