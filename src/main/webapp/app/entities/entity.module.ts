import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { LendingbookBookModule } from './book/book.module';
import { LendingbookLendingModule } from './lending/lending.module';

/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    // prettier-ignore
    imports: [
        LendingbookBookModule, LendingbookLendingModule
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class LendingbookEntityModule {}
