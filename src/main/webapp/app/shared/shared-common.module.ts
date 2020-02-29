import { NgModule } from '@angular/core';

import { LendingbookSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent } from './';

@NgModule({
    imports: [LendingbookSharedLibsModule],
    declarations: [JhiAlertComponent, JhiAlertErrorComponent],
    exports: [LendingbookSharedLibsModule, JhiAlertComponent, JhiAlertErrorComponent]
})
export class LendingbookSharedCommonModule {}
