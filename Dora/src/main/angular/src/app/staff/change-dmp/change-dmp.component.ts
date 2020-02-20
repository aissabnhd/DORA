import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DMP} from "../../interfaces/DMP";
import {DMPService} from "../../services/DMP.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-change-dmp',
  templateUrl: './change-dmp.component.html',
  styleUrls: ['./change-dmp.component.css']
})
export class ChangeDmpComponent implements OnInit {

  dmp : DMP;

  allDMP : Array<DMP> = [];

  @Output()
  changeDMP = new EventEmitter<DMP>();

  DMPForm : FormGroup;
  private sub: Subscription;

  constructor(private dmpService : DMPService, private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.DMPForm = this.formBuilder.group({
      nom: [null, Validators.required],
      prenom: [null, Validators.required],
      socialSecurityNumber:  [null, Validators.required]
    });


  }

  onSubmit(){
    this.allDMP = [];
    if(this.DMPForm.get('nom').value != "" && this.DMPForm.get('nom').value != null){
      this.dmpService.findByLastNameDMP(this.DMPForm.get('nom').value).subscribe(
        data => {
          this.allDMP = data,
            console.log(this.allDMP)
        }
      )

    }
    else if(this.DMPForm.get('prenom').value != "" && this.DMPForm.get('prenom').value != null){
      this.dmpService.findByFirstNameDMP(this.DMPForm.get('prenom').value).subscribe(
        data => this.allDMP = data,
      )

    }
    else if(this.DMPForm.get('socialSecurityNumber').value != "" && this.DMPForm.get('socialSecurityNumber').value != null ){
      this.dmpService.findBySocialSecurityNumberDMP(this.DMPForm.get('socialSecurityNumber').value).subscribe(
        data => {
          this.allDMP = []
          this.allDMP.push(data)
        },
      )

    }



  }

  Choose(id: number) {
    this.dmpService.findByIdDMP(id).subscribe(
      data => {
        this.dmp = data,
          this.dmpService.sendDMP(this.dmp)
      }
    )


  }
}
