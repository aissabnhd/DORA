import {EventEmitter, Injectable, Optional} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Staff} from "../interfaces/Staff";
import {Struct} from "../interfaces/Struct";


@Injectable({
  providedIn: 'root'
})
export class StructService {

  event = new EventEmitter();


  constructor(private httpClient: HttpClient) {
  }

  findAll() : Observable<Array<Struct>> {
    return this.httpClient.get<Array<Struct>>('/api/struct');
  }

  create(s : Struct) : Observable<Struct> {
    return this.httpClient.post<Struct>('/api/struct', s);
  }

  findOne(id : number) : Observable<Struct> {
    return this.httpClient.get<Struct>('/api/struct/' + id);
  }

}
