import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { LendingbookSharedModule } from 'app/shared/shared.module';
import { LendingComponent } from './lending.component';
import { LendingDetailComponent } from './lending-detail.component';
import { LendingUpdateComponent } from './lending-update.component';
import { LendingDeleteDialogComponent } from './lending-delete-dialog.component';
import { lendingRoute } from './lending.route';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
    imports: [LendingbookSharedModule, RouterModule.forChild(lendingRoute), FormsModule, ReactiveFormsModule],
    declarations: [LendingComponent, LendingDetailComponent, LendingUpdateComponent, LendingDeleteDialogComponent],
    entryComponents: [LendingDeleteDialogComponent]
})
export class LendingbookLendingModule {}
