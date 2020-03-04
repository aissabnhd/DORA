import {EventEmitter, Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoginRequest} from "../interfaces/LoginRequest";
import {Staff} from "../interfaces/Staff";


@Injectable({
  providedIn: 'root'
})
export class AuthService {

  event = new EventEmitter();


  constructor(private httpClient: HttpClient) { }

  authenticateUser(loginRequest : LoginRequest) : Observable<any> {
    return this.httpClient.post<any>('/api/auth/login', loginRequest)
  }



}
