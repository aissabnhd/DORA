import { Component, OnInit } from '@angular/core';
import {AffectationService} from "../../../services/Affectation.service";
import {Act} from "../../../interfaces/Act";
import {ActivatedRoute} from "@angular/router";
import {StaffService} from "../../../services/Staff.service";
import {Staff} from "../../../interfaces/Staff";
import {ActService} from "../../../services/Act.service";

@Component({
  selector: 'app-effectuer-examen',
  templateUrl: './effectuer-examen.component.html',
  styleUrls: ['./effectuer-examen.component.css']
})
export class EffectuerExamenComponent implements OnInit {
  idDMP : number;
  idStaff : number;
  listAct : Array<Act>;
  staff : Staff;
  idAffectation : number;
  constructor(private actService : ActService, private staffService : StaffService, private route : ActivatedRoute, private affectationService : AffectationService) { }

  ngOnInit() {
    this.idDMP = this.route.snapshot.params['idDMP'];
    this.idStaff = this.route.snapshot.params['idStaff'];
    this.staffService.findById(this.idStaff).subscribe(
      data => {
        this.staff = data;
        this.affectationService.findCurrent(this.idDMP).subscribe(
          data => {
            this.idAffectation = data.id;
            this.getActs()
          }
        )
      }
    )

  }

  getActs(){
    this.affectationService.findAllByDone(false, this.idAffectation).subscribe(
      data2 => {

        this.listAct = data2;

        console.log(this.listAct)
      }

    )

  }

  examenDone(act: Act) {
    let actBis : Act = act;
    actBis.done = true;
    actBis.staff = this.staff;
    this.actService.save(actBis).subscribe(
      data => {
        this.listAct = [];
        this.getActs();
      }
    )
  }

  noAsk() {
    if(this.listAct == [] || this.listAct == undefined || this.listAct.length == 0)
      return true;
    return false;
  }
}
