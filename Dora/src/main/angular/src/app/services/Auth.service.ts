import {EventEmitter, Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoginRequest} from "../interfaces/LoginRequest";
import {Staff} from "../interfaces/Staff";
import {Token} from "../interfaces/Token";


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  event = new EventEmitter();


  constructor(private httpClient: HttpClient) { }

  authenticateUser(loginRequest : LoginRequest) : Observable<Token> {
    return this.httpClient.post<Token>('/api/auth/login', loginRequest)
  }

  logOut(id : number) : Observable<string> {
    return this.httpClient.get<string>('/api/auth/logout/' + id);
  }


    sendMail(mail : string) : Observable<boolean> {
      return this.httpClient.get<boolean>('/api/auth/pwdForget/' + mail );
    }

    changePassword(mail: string, cle: string, password: string) : Observable<boolean>{
      return this.httpClient.get<boolean>('/api/auth/pwdChange/' + mail + '/' + cle + '/' + password);
    }

  getToken() {
    return localStorage.getItem('Token');
  }
}