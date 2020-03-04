import {EventEmitter, Injectable, Optional} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Staff} from "../interfaces/Staff";


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

}
