import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import * as moment from 'moment';

import { SERVER_API_URL } from 'app/app.constants';
import { createRequestOption } from 'app/shared/util/request-util';
import { ILending } from 'app/shared/model/lending.model';

type EntityResponseType = HttpResponse<ILending>;
type EntityArrayResponseType = HttpResponse<ILending[]>;

@Injectable({ providedIn: 'root' })
export class LendingService {
    public resourceUrl = SERVER_API_URL + 'api/lendings';

    constructor(protected http: HttpClient) {}

    create(lending: ILending): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(lending);
        return this.http
            .post<ILending>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    update(lending: ILending): Observable<EntityResponseType> {
        const copy = this.convertDateFromClient(lending);
        return this.http
            .put<ILending>(this.resourceUrl, copy, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    find(id: number): Observable<EntityResponseType> {
        return this.http
            .get<ILending>(`${this.resourceUrl}/${id}`, { observe: 'response' })
            .pipe(map((res: EntityResponseType) => this.convertDateFromServer(res)));
    }

    query(req?: any): Observable<EntityArrayResponseType> {
        const options = createRequestOption(req);
        return this.http
            .get<ILending[]>(this.resourceUrl, { params: options, observe: 'response' })
            .pipe(map((res: EntityArrayResponseType) => this.convertDateArrayFromServer(res)));
    }

    delete(id: number): Observable<HttpResponse<{}>> {
        return this.http.delete(`${this.resourceUrl}/${id}`, { observe: 'response' });
    }

    protected convertDateFromClient(lending: ILending): ILending {
        const copy: ILending = Object.assign({}, lending, {
            lendDate: lending.lendDate && lending.lendDate.isValid() ? lending.lendDate.toJSON() : undefined
        });
        return copy;
    }

    protected convertDateFromServer(res: EntityResponseType): EntityResponseType {
        if (res.body) {
            res.body.lendDate = res.body.lendDate ? moment(res.body.lendDate) : undefined;
        }
        return res;
    }

    protected convertDateArrayFromServer(res: EntityArrayResponseType): EntityArrayResponseType {
        if (res.body) {
            res.body.forEach((lending: ILending) => {
                lending.lendDate = lending.lendDate ? moment(lending.lendDate) : undefined;
            });
        }
        return res;
    }
}
