import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Affectation} from "../../../interfaces/Affectation";
import {AffectationService} from "../../../services/Affectation.service";
import {ActivatedRoute, Router} from "@angular/router";
import {StaffService} from "../../../services/Staff.service";
import {Staff} from "../../../interfaces/Staff";
import {Act} from "../../../interfaces/Act";
import {ActService} from "../../../services/Act.service";
import {MatSnackBar} from "@angular/material/snack-bar";

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
  constructor(private router: Router, private snackBar : MatSnackBar, private actService : ActService, private staffService : StaffService, private route : ActivatedRoute, private affectationService : AffectationService, private formBuilder : FormBuilder) { }

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
    this.act.staff = this.staff;
    this.act.affectation = this.affectation;
    this.act.done = false;
    this.act.date = new Date(Date.now());
    this.snackBar.open("Demande d'acte " + this.act.type + " effectuée !", 'OK', { verticalPosition: 'top', duration:5000 })

    this.actService.save(this.act).subscribe(
      data => console.log(data)
    )
  }

  isEmpty() {
    let s : String = this.actForm.get('type').value;
    return s.trim()=="";
  }
}
