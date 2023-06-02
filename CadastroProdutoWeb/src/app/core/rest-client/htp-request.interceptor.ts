import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpErrorResponse } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators'
import { Observable, throwError } from 'rxjs';
import { NotifierHandlerService } from '../services/notifier-handler.service';

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {

    constructor(private notifierService: NotifierHandlerService) {
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        return next.handle(request).pipe(
            catchError((error: HttpErrorResponse) => {
                let message = "";
                if (error.error != null) {
                    message = error.error.message ? error.error.message : error.error;
                } else {
                    message = error.message;
                }
                if (error.status == 400 || error.status == 500 || error.status == 403) {
                    this.notifierService.notifyError(message);
                }
                return throwError(() => error);
            })
        );
    }
}
