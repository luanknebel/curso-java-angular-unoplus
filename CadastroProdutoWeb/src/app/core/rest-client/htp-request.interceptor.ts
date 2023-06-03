import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor, HttpErrorResponse } from '@angular/common/http';
import { catchError, map } from 'rxjs/operators'
import { Observable, throwError } from 'rxjs';
import { NotifierHandlerService } from '../services/notifier-handler.service';
import { TokenJwtService } from '../services/token-jwt.service';
import { AuthenticationService } from '../services/authentication.service';

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {

    constructor(private notifierService: NotifierHandlerService,
                private tokenJwtService: TokenJwtService,
                private authenticationService: AuthenticationService) {
    }

    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {

        const token = this.tokenJwtService.getToken();
        if(token){
            request = request.clone({
                url: request.url,
                setHeaders: {
                    Authorization: `Bearer ${token}`
                }
            });
        }

        return next.handle(request).pipe(
            catchError((error: HttpErrorResponse) => {

                let message = "";

                if (error.error != null) {
                    message = error.error.message ? error.error.message : error.error;
                } else {
                    message = error.message;
                }

                if (error.status == 400 || error.status == 500) {
                    this.notifierService.notifyError(message);
                }

                if (error.status == 401 || error.status == 403) {
                    this.notifierService.notifyWarning("Autenticacao inválida!");
                    this.authenticationService.realizarLogout();
                }
                return throwError(() => error);
            })
        );
    }
}
