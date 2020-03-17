import { Component, OnInit } from '@angular/core';
import {Act} from "../../interfaces/Act";
import {Affectation} from "../../interfaces/Affectation";
import {Staff} from "../../interfaces/Staff";
import {AffectationService} from "../../services/Affectation.service";
import {StaffService} from "../../services/Staff.service";
import {ActService} from "../../services/Act.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {DMPService} from "../../services/DMP.service";
import {DMP} from "../../interfaces/DMP";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-posologie',
  templateUrl: './posologie.component.html',
  styleUrls: ['./posologie.component.css']
})
export class PosologieComponent implements OnInit {

  act : Act;
  idDMP : number;
  idStaff : number;
  staff : Staff;
  affectation : Affectation;
  dmp : DMP;
  effectuer = false;
  constructor(private route : ActivatedRoute, private dmpService : DMPService, private snackBar : MatSnackBar, private actService : ActService, private staffService : StaffService, private affectationService : AffectationService) { }

  ngOnInit() {
    this.idDMP = this.route.snapshot.params['idDMP'];
    this.idStaff = this.route.snapshot.params['idStaff'];
    this.staffService.findById(this.idStaff).subscribe(
      data => {
        this.staff = data;
        this.affectationService.findCurrent(this.idDMP).subscribe(
          data => {
            this.affectation = data;
            this.dmpService.findByIdDMP(this.idDMP).subscribe(
              data => this.dmp = data
            )
          }
        )
      }
    )

  }

  creationPosologie() {
    this.act = new class implements Act {
      affectation: Affectation;
      date: Date;
      done: boolean;
      id: number;
      staff: Staff;
      type: string;
    }
    this.act.type = "Posologie";
    this.act.staff = this.staff;
    this.act.affectation = this.affectation;
    this.act.done = false;
    this.act.date = new Date(Date.now());
    this.snackBar.open("Posologie effectuée !", 'OK', { verticalPosition: 'top', duration:5000 })
    this.effectuer = true;
    this.actService.save(this.act).subscribe(
      data => console.log(data)
    )
  }


}
