import {EventEmitter, Injectable, Optional} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Staff} from "../interfaces/Staff";
import {Struct} from "../interfaces/Struct";


@Injectable({
  providedIn: 'root'
})
export class StaffService {

  event = new EventEmitter();


  constructor(private httpClient: HttpClient) {
  }

  findByMail(mail : string) : Observable<Optional> {
    return this.httpClient.get<Optional>('/api/staff/ByEmail/' + mail);
  }

  findAll() : Observable<Array<Staff>> {
    return this.httpClient.get<Array<Staff>>('/api/staff');
  }

  findById(id : number) : Observable<Staff> {
    return this.httpClient.get<Staff>('/api/staff/' + id);
  }

}