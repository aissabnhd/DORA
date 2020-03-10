import {EventEmitter, Injectable} from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {LoginRequest} from "../interfaces/LoginRequest";
import {Staff} from "../interfaces/Staff";
import {Token} from "../interfaces/Token";
import {DMP} from "../interfaces/DMP";
import {Affectation} from "../interfaces/Affectation";
import {Document} from "../interfaces/Document";

@Injectable({
  providedIn: 'root'
})
export class DocumentService {


  constructor(private httpClient: HttpClient) { }

  save(document : Document) : Observable<Document>{
    return this.httpClient.post<Document>('api/document', document);
  }

  write(s : String, id : number) : Observable<string>{
    return this.httpClient.post<string>('api/document/write/' + id, s);
  }

  findAll() : Observable<Array<Document>> {
    return this.httpClient.get<Array<Document>>('api/document');
  }

}
