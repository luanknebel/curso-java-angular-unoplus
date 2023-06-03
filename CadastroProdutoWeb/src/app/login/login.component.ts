import { Component, OnInit } from '@angular/core';
import { LoginDTO } from '../core/model/login.dto';
import { RestClientService } from '../core/rest-client/rest-client.service';
import { NotifierHandlerService } from '../core/services/notifier-handler.service';
import { TokenDTO } from '../core/model/token.dto';
import { AuthenticationService } from '../core/services/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginDTO!: LoginDTO;

  constructor(private authenticationService : AuthenticationService) { }

  ngOnInit(): void {
    this.loginDTO = new LoginDTO();
  }

  efetuarLogin(){
    this.authenticationService.realizarLogin(this.loginDTO);
  }

}
