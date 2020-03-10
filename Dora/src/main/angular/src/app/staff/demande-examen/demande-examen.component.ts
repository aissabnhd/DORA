import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {HospitalizationService} from "../../services/Hospitalization.service";
import {Hospitalization} from "../../interfaces/Hospitalization";
import {AffectationService} from "../../services/Affectation.service";
import {Affectation} from "../../interfaces/Affectation";

@Component({
  selector: 'app-demande-examen',
  templateUrl: './demande-examen.component.html',
  styleUrls: ['./demande-examen.component.css']
})
export class DemandeExamenComponent implements OnInit {
  idDMP: number;
  idStaff: number;
  hospitalization : Hospitalization;
  affectation: Affectation;
  constructor(private affectationService : AffectationService, private hospitalizationService : HospitalizationService, private route : ActivatedRoute) { }

  ngOnInit() {
    this.idDMP = this.route.snapshot.params['idDMP'];
    this.idStaff = this.route.snapshot.params['idStaff'];
    this.hospitalizationService.findCurrent(this.idDMP).subscribe(
      data => {
        this.hospitalization = data;
        this.affectationService.findCurrent(this.idDMP).subscribe(
          data => this.affectation = data
        )
      }
    )
  }

}
