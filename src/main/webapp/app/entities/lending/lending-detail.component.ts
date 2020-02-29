import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

import { ILending } from 'app/shared/model/lending.model';

@Component({
    selector: 'jhi-lending-detail',
    templateUrl: './lending-detail.component.html'
})
export class LendingDetailComponent implements OnInit {
    lending: ILending | null = null;

    constructor(protected activatedRoute: ActivatedRoute) {}

    ngOnInit(): void {
        this.activatedRoute.data.subscribe(({ lending }) => (this.lending = lending));
    }

    previousState(): void {
        window.history.back();
    }
}
