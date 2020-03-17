import { Component, OnInit } from '@angular/core';
import {AffectationService} from "../../services/Affectation.service";
import {ActivatedRoute, Route, Router} from "@angular/router";
import {Affectation} from "../../interfaces/Affectation";
import {Staff} from "../../interfaces/Staff";
import {HospitalizationService} from "../../services/Hospitalization.service";
import {Hospitalization} from "../../interfaces/Hospitalization";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-affecter-patient',
  templateUrl: './affecter-patient.component.html',
  styleUrls: ['./affecter-patient.component.css']
})
export class AffecterPatientComponent implements OnInit {
  idDMP : number;
  affectation : Affectation;
  hospitalisation : Hospitalization;
  constructor(private snackBar : MatSnackBar, private hospitalizationService : HospitalizationService, private affectationService : AffectationService, private route : ActivatedRoute, private router : Router) { }

  ngOnInit() {
    this.idDMP = this.route.snapshot.params['idDMP'];
    this.getCurrentAffectationHospitalisation();
  }

  private getCurrentAffectationHospitalisation() {
    this.affectation = null;
    this.hospitalisation = null;
    this.affectationService.findCurrent(this.idDMP).subscribe(
      data => {
        this.affectation = data
        console.log(data)
      },
      error => console.log(error)
    );
    this.hospitalizationService.findCurrent(this.idDMP).subscribe(
      data => this.hospitalisation = data
    )
  }

  toStringStaff() {
    let s = "[";
    for(let item of this.affectation.listOfStaffs.values()){
      s += item.firstName + " " + item.lastName + ", "
    }
    console.log(this.affectation.listOfStaffs)
    return s + "]";
  }

  endAffectation() {
    this.affectation.dateEndAffectation = new Date(Date.now());
    this.hospitalisation.dateEndHospitalization = new Date(Date.now());
    this.affectationService.save(this.affectation).subscribe(
      data => {
        this.hospitalizationService.save(this.hospitalisation).subscribe(
          data2 =>  {
            this.snackBar.open("Fin de l'affectation et de l'hospitalisation !", 'OK', { verticalPosition: 'top', duration:5000 })
            this.getCurrentAffectationHospitalisation()
          }
        )

      }
    )
  }

  changeService() {
    this.affectation.dateEndAffectation = new Date(Date.now());
    this.affectationService.save(this.affectation).subscribe(
      data => {
        this.router.navigate(['/creer_affectation/'+this.idDMP]);
      }
    )
  }

  endHospitalization() {
    this.hospitalisation.dateEndHospitalization = new Date(Date.now());
        this.hospitalizationService.save(this.hospitalisation).subscribe(
          data2 =>  {
            this.snackBar.open("Fin de l'hospitalisation !", 'OK', { verticalPosition: 'top', duration:5000 })
            this.getCurrentAffectationHospitalisation()
          }
        )



  }
}
