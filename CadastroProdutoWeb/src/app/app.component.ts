import { Component } from '@angular/core';
import { AuthenticationService } from './core/services/authentication.service';
import { TokenJwtService } from './core/services/token-jwt.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'CadastroProdutoWeb';

  constructor(private authenticationService: AuthenticationService,
              private tokenJwtService: TokenJwtService){
  }

  realizarLogout(){
    this.authenticationService.realizarLogout();
  }

  public isAuthenticated(): boolean {
    return this.tokenJwtService.isAuthenticated();
  }

}
