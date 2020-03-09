import {Component, OnInit} from '@angular/core';
import {DMP} from "../../../interfaces/DMP";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {DMPService} from "../../../services/DMP.service";
import {Hospitalization} from "../../../interfaces/Hospitalization";
import {HospitalizationService} from "../../../services/Hospitalization.service";
import {Level, Struct} from "../../../interfaces/Struct";
import {ActivatedRoute, Router} from "@angular/router";
import {StructService} from "../../../services/Struct.service";

@Component({
  selector: 'app-create-hospitalization',
  templateUrl: './create-hospitalization.component.html',
  styleUrls: ['./create-hospitalization.component.css']
})
export class CreateHospitalizationComponent implements OnInit {
  hospitalization: Hospitalization;
  idDMP : number;
  structs : Array<Struct>;
  dmp : DMP;
  hospitalizationForm : FormGroup;
  constructor(private router : Router, private route : ActivatedRoute, private dmpService : DMPService, private structService : StructService, private formBuilder : FormBuilder, private hospitalizationService : HospitalizationService) { }

  ngOnInit() {
    this.idDMP = this.route.snapshot.params['idDMP'];
    this.structService.findAll().subscribe(
      data => {
        this.structs = data;
        this.dmpService.findByIdDMP(this.idDMP).subscribe(
          data2 => {
            this.dmp = data2;
            this.hospitalizationForm = this.formBuilder.group({
              roomNumber: [null, Validators.required],
              struct: new FormControl(0)

            });

          }
        )

      }
    )

  }

  creationHospitalization() {
    this.hospitalization = this.hospitalizationForm.value
    this.hospitalization.dmp = this.dmp;
    this.hospitalization.dateHospitalization = new Date(Date.now());
    this.hospitalization.dateEndHospitalization = null;
    //this.hospitalization.struct = this.structs[this.hospitalizationForm.get("struct").value];
   // let s : Struct = this.hospitalizationForm.get("struct").value;
    this.hospitalization.struct = this.structs[this.hospitalizationForm.get("struct").value];
    console.log(this.hospitalization)
    this.hospitalizationService.save(this.hospitalization).subscribe(
      data => {
        this.router.navigate(['/affectation_patient_service/'+this.idDMP]);
      }
    );




  }

  afficheLevel(level: Level) {
    if (level == Level.HOSPITAL)
      return "{Hopital}"


    if (level == Level.APHP)
      return "{AP-HP}"

    if(level == Level.POLE)
      return "{Pole}"

    if(level == Level.SERVICE)
      return "{Service}"

    if(level == Level.CARE_UNIT)
      return "{Unité de soins}"

    if(level == Level.FONCTIONAL_UNIT)
      return "{Unité fonctionnelle}"
  }
}
