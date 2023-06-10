import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { BehaviorSubject, Observable } from 'rxjs';
import { TokenJwtService } from '../services/token-jwt.service';
import { NotifierHandlerService } from '../services/notifier-handler.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuardService implements CanActivate{

  constructor(private tokenJwtService: TokenJwtService,
              private notifierService: NotifierHandlerService,
              private router: Router) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean | UrlTree | Observable<boolean | UrlTree> | Promise<boolean | UrlTree> {

    if (!this.tokenJwtService.isAuthenticated()) {
      this.router.navigate(['/']);
      this.tokenJwtService.removeToken();
      this.notifierService.notifyWarning("Usuario não antenticado para acessar este recurso");
      return false;
    }

    return true;
  }
}
