import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {DMP} from "../interfaces/DMP";


@Injectable({
  providedIn: 'root'
})
export class DMPService {

  constructor(private httpClient: HttpClient) { }

  findAllDMP() : Observable<Array<DMP>> {
    return this.httpClient.get<Array<DMP>>('/api/DMP')
  }

  saveDMP(dmp : DMP) : Observable<DMP>{
    return this.httpClient.post<DMP>('/api/DMP', dmp);
  }


  findByIdDMP(id: number) : Observable<DMP>{
    return this.httpClient.get<DMP>('/api/DMP' + id);
  }

  findByLastNameDMP(lastName: string) : Observable<DMP>{
    return this.httpClient.get<DMP>('/api/DMP/lastName/' + lastName);
  }

  findByFirstNameDMP(firstName: string) : Observable<DMP>{
    return this.httpClient.get<DMP>('/api/DMP/firstName/' + firstName);
  }

  findBySocialSecurityNumberDMP(ssn: string) : Observable<DMP>{
    return this.httpClient.get<DMP>('/api/DMP/ssn/' + ssn);
  }

  findAllByStructIdDMP(id: number) : Observable<DMP>{
    return this.httpClient.get<DMP>('/api/DMP/struct/' + id);
  }

  deleteDMP(id: number) : Observable<any>{
    return this.httpClient.delete('/api/DMP/' + id);
  }
}
