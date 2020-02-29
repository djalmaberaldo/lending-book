import { Component } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { ILending } from 'app/shared/model/lending.model';
import { LendingService } from './lending.service';
import { JhiEventManager } from 'app/shared/util/event-manager';

@Component({
    templateUrl: './lending-delete-dialog.component.html'
})
export class LendingDeleteDialogComponent {
    lending?: ILending;

    constructor(protected lendingService: LendingService, public activeModal: NgbActiveModal, protected eventManager: JhiEventManager) {}

    cancel(): void {
        this.activeModal.dismiss();
    }

    confirmDelete(id: number): void {
        this.lendingService.delete(id).subscribe(() => {
            this.eventManager.broadcast('lendingListModification');
            this.activeModal.close();
        });
    }
}
