import {EventEmitter, Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {DMP} from "../interfaces/DMP";
import {Affectation} from "../interfaces/Affectation";
import {Hospitalization} from "../interfaces/Hospitalization";


@Injectable({
  providedIn: 'root'
})
export class HospitalizationService {

  event = new EventEmitter();


  constructor(private httpClient: HttpClient) {
  }

  findCurrent(idDMP : number) : Observable<Hospitalization>{
    return this.httpClient.get<Hospitalization>('/api/hospitalization/current/' + idDMP);
  }

  save(hospitalization : Hospitalization) : Observable<Hospitalization>{
    return this.httpClient.post<Hospitalization>('api/hospitalization', hospitalization);
  }

}
