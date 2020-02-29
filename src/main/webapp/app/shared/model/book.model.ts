import { ILending } from 'app/shared/model/lending.model';

export interface IBook {
    id?: number;
    title?: string;
    description?: string;
    author?: string;
    yearOfPublication?: number;
    lendings?: ILending[];
}

export class Book implements IBook {
    constructor(
        public id?: number,
        public title?: string,
        public description?: string,
        public author?: string,
        public yearOfPublication?: number,
        public lendings?: ILending[]
    ) {}
}
