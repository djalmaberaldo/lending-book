import { NgModule } from '@angular/core';

import { LendingbookSharedLibsModule } from './';

@NgModule({
    imports: [LendingbookSharedLibsModule],
    exports: [LendingbookSharedLibsModule]
})
export class LendingbookSharedCommonModule {}
