import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { RouterModule } from '@angular/router';
import { LendingbookSharedModule } from 'app/shared';
/* jhipster-needle-add-admin-module-import - JHipster will add admin modules imports here */

import {
    adminState,
    UserMgmtComponent,
    UserMgmtDetailComponent,
    UserMgmtUpdateComponent,
    UserMgmtDeleteDialogComponent,
    JhiConfigurationComponent,
    JhiDocsComponent
} from './';

@NgModule({
    imports: [
        LendingbookSharedModule,
        RouterModule.forChild(adminState)
        /* jhipster-needle-add-admin-module - JHipster will add admin modules here */
    ],
    declarations: [
        UserMgmtComponent,
        UserMgmtDetailComponent,
        UserMgmtUpdateComponent,
        UserMgmtDeleteDialogComponent,
        JhiConfigurationComponent,
        JhiDocsComponent
    ],
    entryComponents: [UserMgmtDeleteDialogComponent],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class LendingbookAdminModule {}
