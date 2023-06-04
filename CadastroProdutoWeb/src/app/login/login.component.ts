import { Component, OnInit } from '@angular/core';
import { LoginDTO } from '../core/model/login.dto';
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
