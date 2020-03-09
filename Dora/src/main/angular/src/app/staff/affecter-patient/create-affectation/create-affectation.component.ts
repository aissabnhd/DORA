import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Hospitalization} from "../../../interfaces/Hospitalization";
import {Struct} from "../../../interfaces/Struct";
import {DMP} from "../../../interfaces/DMP";
import {FormArray, FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {DMPService} from "../../../services/DMP.service";
import {StructService} from "../../../services/Struct.service";
import {HospitalizationService} from "../../../services/Hospitalization.service";
import {Staff} from "../../../interfaces/Staff";
import {StaffService} from "../../../services/Staff.service";
import {Affectation} from "../../../interfaces/Affectation";
import {AffectationService} from "../../../services/Affectation.service";

@Component({
  selector: 'app-create-affectation',
  templateUrl: './create-affectation.component.html',
  styleUrls: ['./create-affectation.component.css']
})
export class CreateAffectationComponent implements OnInit {
  staffs : Array<Staff>;
  affectation : Affectation;
  idDMP : number;
  structs : Array<Struct>;
  dmp : DMP;
  hospitalization : Hospitalization;
  affectationForm : FormGroup;
  constructor(private affectationService : AffectationService, private staffService : StaffService, private router : Router, private route : ActivatedRoute, private dmpService : DMPService, private structService : StructService, private formBuilder : FormBuilder, private hospitalizationService : HospitalizationService) { }

  ngOnInit() {
    this.idDMP = this.route.snapshot.params['idDMP'];
    this.structService.findAll().subscribe(
      data => {
        this.structs = data;
        this.dmpService.findByIdDMP(this.idDMP).subscribe(
          data2 => {
            this.dmp = data2;
            this.staffService.findAll().subscribe(
              data3 => {
                this.staffs = data3;
                this.hospitalizationService.findCurrent(this.idDMP).subscribe(
                  data4 => {
                    this.hospitalization = data4;
                    this.affectationForm = this.formBuilder.group({

                      staff: this.formBuilder.array([
                        new FormControl()
                      ]),
                      struct: new FormControl(0)

                    });
                  }
                )
                  }
                )



          }
        )

      }
    )

  }

  creationAffectation() {
    this.affectation = this.affectationForm.value;
    this.affectation.listOfStaffs = new Set<Staff>();
    this.affectation.dateEndAffectation = null;
    this.affectation.dateAffectation = new Date(Date.now());
    this.affectation.hospitalization = this.hospitalization;
    const control = <FormArray>this.affectationForm.controls['staff'];
    let tab = [];
    for(let i = 0; i <  control.length; i++){
      tab.push(control.get(i.toString()).value);
      this.affectation.listOfStaffs.add(this.staffs[tab[i]]);
      console.log(this.staffs[tab[i]])
    }
    this.affectation.struct = this.structs[this.affectationForm.get("struct").value];
    this.affectation.listOfStaffs = null;
    this.affectationService.save(this.affectation).subscribe(
      data => {
        this.affectationService.changeStaff(data.id, tab).subscribe(
          data2 =>  this.router.navigate(['/affectation_patient_service/'+this.idDMP])
        )

      }
    );

  }

  addStaff() {
    const control = <FormArray>this.affectationForm.controls['staff'];
    if(control.length < this.staffs.length) {

      control.push(new FormControl())
    }
  }

  removeStaff() {
    const control = <FormArray>this.affectationForm.controls['staff'];
    if(control.length  > 1){

      control.removeAt(0);
    }
  }
}
