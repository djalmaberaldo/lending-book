import { Moment } from 'moment';

export interface ILending {
    id?: number;
    lendDate?: Moment;
    isActive?: boolean;
    bookId?: number;
    userId?: number;
    bookTitle?: string;
    userName?: string;
}

export class Lending implements ILending {
    constructor(
        public id?: number,
        public lendDate?: Moment,
        public isActive?: boolean,
        public bookId?: number,
        public userId?: number,
        public bookTitle?: string,
        public userName?: string
    ) {
        this.isActive = this.isActive || false;
    }
}
