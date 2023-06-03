import { Injectable } from '@angular/core';
import { JwtHelperService } from '@auth0/angular-jwt';

const localStorageJWTKey = "jwtToken";

@Injectable({
  providedIn: 'root'
})
export class TokenJwtService {

  constructor(public jwtHelper: JwtHelperService) { }

  public isAuthenticated(): boolean {
    const token = this.getToken();
    if(token){
      return !this.jwtHelper.isTokenExpired(token);
    }
    return false;
  }

  setToken(token: string) {
    if (token) {
        this.setLocalStorage(localStorageJWTKey, token);
    }
  }

  getToken() {
      return this.getLocalStorage(localStorageJWTKey);
  }

  removeToken(){
    this.removeLocalStorage(localStorageJWTKey);
  }

  private setLocalStorage(key: string, value: string) {
    localStorage.setItem(key, value);
  }

  private getLocalStorage(key: string): string | null {
    return localStorage.getItem(key);
  }

  private removeLocalStorage(key: string) {
    localStorage.removeItem(key);
  }

}
