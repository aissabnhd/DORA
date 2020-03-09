import {EventEmitter, Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {DMP} from "../interfaces/DMP";
import {Affectation} from "../interfaces/Affectation";
import {Act} from "../interfaces/Act";


@Injectable({
  providedIn: 'root'
})
export class AffectationService {

  event = new EventEmitter();


  constructor(private httpClient: HttpClient) {
  }

  findCurrent(idDMP : number) : Observable<Affectation>{
    return this.httpClient.get<Affectation>('/api/affectation/current/' + idDMP);
  }

  save(affectation : Affectation) : Observable<Affectation>{
    return this.httpClient.post<Affectation>('api/affectation', affectation);
  }

  changeStaff(idAffectation: number, tab: number[]) : Observable<Affectation>{
    return this.httpClient.post<Affectation>('api/affectation/change_staff/' + idAffectation, tab);
  }

  findActsOf(idAffectation : number) : Observable<Array<Act>>{
    return this.httpClient.get<Array<Act>>('/api/affectation/' + idAffectation + '/acts');
  }

}
