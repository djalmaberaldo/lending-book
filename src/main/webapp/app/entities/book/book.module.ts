import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { LendingbookSharedModule } from 'app/shared/shared.module';
import { BookComponent } from './book.component';
import { BookDetailComponent } from './book-detail.component';
import { BookUpdateComponent } from './book-update.component';
import { BookDeleteDialogComponent } from './book-delete-dialog.component';
import { bookRoute } from './book.route';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
    imports: [LendingbookSharedModule, RouterModule.forChild(bookRoute), FormsModule, ReactiveFormsModule],
    declarations: [BookComponent, BookDetailComponent, BookUpdateComponent, BookDeleteDialogComponent],
    entryComponents: [BookDeleteDialogComponent]
})
export class LendingbookBookModule {}
