import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Affectation} from "../../../interfaces/Affectation";
import {AffectationService} from "../../../services/Affectation.service";
import {ActivatedRoute} from "@angular/router";
import {StaffService} from "../../../services/Staff.service";
import {Staff} from "../../../interfaces/Staff";
import {Act} from "../../../interfaces/Act";
import {ActService} from "../../../services/Act.service";

@Component({
  selector: 'app-creer-demande',
  templateUrl: './creer-demande.component.html',
  styleUrls: ['./creer-demande.component.css']
})
export class CreerDemandeComponent implements OnInit {

  actForm : FormGroup;
  idDMP : number;
  affectation : Affectation;
  idStaff : number;
  staff : Staff;
  act : Act;
  constructor(private actService : ActService, private staffService : StaffService, private route : ActivatedRoute, private affectationService : AffectationService, private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.idDMP = this.route.snapshot.params['idDMP'];
    this.idStaff = this.route.snapshot.params['idStaff'];
    this.affectationService.findCurrent(this.idDMP).subscribe(
      data => {
        this.affectation = data
        this.staffService.findById(this.idStaff).subscribe(
          data => {
            this.actForm = this.formBuilder.group({
              type: [null, Validators.required],
            });
            this.staff = data
          }
        )

      }
    )
  }

  creationAct() {
    this.act = this.actForm.value;
    this.act.type = this.actForm.get('type').value;
    console.log(this.actForm.get('type').value)
    this.act.staff = this.staff;
    this.act.affectation = this.affectation;
    this.act.done = false;
    this.act.date = new Date(Date.now());
    console.log(this.act);
    this.actService.save(this.act).subscribe(
      data => console.log(data)
    )
  }
}
