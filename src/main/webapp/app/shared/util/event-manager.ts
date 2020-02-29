import { Observer, Observable, Subscription } from 'rxjs';
import { Injectable } from '@angular/core';
import { filter, map, share } from 'rxjs/operators';
import { JhiEventWithContent } from '../event-with-content.model';

@Injectable({
    providedIn: 'root'
})
export class JhiEventManager {
    observable: Observable<JhiEventWithContent<any> | string>;
    observer: Observer<JhiEventWithContent<any> | string>;

    constructor() {
        this.observable = Observable.create((observer: Observer<JhiEventWithContent<any> | string>) => {
            this.observer = observer;
        }).pipe(share());
    }

    /**
     * Method to broadcast the event to observer
     */
    broadcast(event: JhiEventWithContent<any> | string): void {
        if (this.observer) {
            this.observer.next(event);
        }
    }

    /**
     * Method to subscribe to an event with callback
     */
    subscribe(eventName: string, callback: any): Subscription {
        const subscriber: Subscription = this.observable
            .pipe(
                filter((event: JhiEventWithContent<any> | string) => {
                    if (typeof event === 'string') {
                        return event === eventName;
                    }
                    return event.name === eventName;
                }),
                map((event: JhiEventWithContent<any> | string) => {
                    if (typeof event !== 'string') {
                        // when releasing generator-jhipster v7 then current return will be changed to
                        // (to avoid redundant code response.content in JhiEventManager.subscribe callbacks):
                        // return event.content;
                        return event;
                    }
                })
            )
            .subscribe(callback);
        return subscriber;
    }

    /**
     * Method to unsubscribe the subscription
     */
    destroy(subscriber: Subscription): void {
        subscriber.unsubscribe();
    }
}
