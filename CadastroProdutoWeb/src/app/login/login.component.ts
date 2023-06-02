import { Component, OnInit } from '@angular/core';
import { LoginDTO } from '../core/model/login.dto';
import { RestClientService } from '../core/rest-client/rest-client.service';
import { NotifierHandlerService } from '../core/services/notifier-handler.service';
import { MessageDTO } from '../core/model/message.dto';
import { catchError } from 'rxjs';
import { TokenDTO } from '../core/model/token.dto';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  public loginDTO!: LoginDTO;

  constructor(private restClientService : RestClientService,
              private notifierService: NotifierHandlerService) { }

  ngOnInit(): void {
    this.loginDTO = new LoginDTO();
  }

  efetuarLogin(){
    this.restClientService.post<TokenDTO>('usuario/login',this.loginDTO)
    .subscribe({
      next: data => {
        this.notifierService.notifySucess("Login efetuado com sucesso!");
    }})

  }

}
