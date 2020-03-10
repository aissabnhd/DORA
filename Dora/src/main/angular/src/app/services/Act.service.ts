import {EventEmitter, Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoginRequest} from "../interfaces/LoginRequest";
import {Staff} from "../interfaces/Staff";
import {Token} from "../interfaces/Token";
import {DMP} from "../interfaces/DMP";
import {Act} from "../interfaces/Act";


@Injectable({
  providedIn: 'root'
})
export class ActService {


  constructor(private httpClient: HttpClient) { }

  save(act : Act) : Observable<Act>{
    return this.httpClient.post<Act>('/api/act', act);
  }



}
