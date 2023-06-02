import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { CADASTROPRODUTO_API } from '../configs/api.configs';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class RestClientService {

  constructor(private httpClient : HttpClient) { }

  get<T>(resource: string) : Observable<T>{
    return this.httpClient.get<T>(`${CADASTROPRODUTO_API}/${resource}`);
  }

  post<T>(resource: string, payload : any) : Observable<T>{
    return this.httpClient.post<T>(`${CADASTROPRODUTO_API}/${resource}`, payload);
  }

  put<T>(resource: string, payload : any) : Observable<T>{
    return this.httpClient.put<T>(`${CADASTROPRODUTO_API}/${resource}`, payload);
  }

  delete(resource: string) : Observable<Object>{
    return this.httpClient.delete(`${CADASTROPRODUTO_API}/${resource}`);
  }

}