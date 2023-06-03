import { Injectable } from '@angular/core';
import { LoginDTO } from '../model/login.dto';
import { RestClientService } from '../rest-client/rest-client.service'
import { TokenDTO } from '../model/token.dto';
import { NotifierHandlerService } from './notifier-handler.service';
import { TokenJwtService } from './token-jwt.service';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private restClientService: RestClientService,
              private notifierService: NotifierHandlerService,
              private tokenJwtService: TokenJwtService,
              private router: Router) { }

  realizarLogin(loginDTO: LoginDTO){
    this.restClientService.post<TokenDTO>('usuario/login',loginDTO)
    .subscribe({
      next: data => {
        this.tokenJwtService.setToken(data.token);
        this.router.navigate(["/cadastro/produto"]);
        this.notifierService.notifySucess("Login efetuado com sucesso!");
    }})
  }

  realizarLogout(){
    this.tokenJwtService.removeToken();
    this.router.navigate(["/"]);
  }
}
