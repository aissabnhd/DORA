import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DMP} from "../../interfaces/DMP";
import {DMPService} from "../../services/DMP.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {Subscription} from "rxjs";
import {MatSnackBar} from "@angular/material/snack-bar";

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

  constructor(private snackBar : MatSnackBar, private dmpService : DMPService, private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.dmpService.findAllDMP().subscribe(
      data => console.log(data)
    )
    this.DMPForm = this.formBuilder.group({
      nom: [null, Validators.required],
      prenom: [null, Validators.required],
      socialSecurityNumber:  [null, Validators.required]
    });


  }

  concatener(tab : Array<DMP>, tab2 : Array<DMP>){
    if(tab == []){
      return tab2;
    }
    if(tab2 == []){
      return tab;
    }
    return tab.concat(tab2);

  }

  onSubmit(){
    this.allDMP = [];

      this.dmpService.findByLastNameDMP(this.DMPForm.get('nom').value).subscribe(
        data => {
          this.allDMP = this.concatener(this.allDMP, data)
            this.dmpService.findByFirstNameDMP(this.DMPForm.get('prenom').value).subscribe(
              data => {

                this.allDMP = this.concatener(this.allDMP, data);
                if(this.DMPForm.get('socialSecurityNumber').value != "" && this.DMPForm.get('socialSecurityNumber').value != null ) {
                  this.dmpService.findBySocialSecurityNumberDMP(this.DMPForm.get('socialSecurityNumber').value).subscribe(
                    data => {
                      this.allDMP = []
                      this.allDMP.push(data)
                    },
                  )
                }
              },
            )
          }

      )

  }

  Choose(id: number) {
    this.dmpService.findByIdDMP(id).subscribe(
      data => {
        this.dmp = data;
        this.dmpService.sendDMP(this.dmp);
        this.snackBar.open("Vous avez choisi le patient " +this.dmp.lastName + " " + this.dmp.firstName +  " !", 'OK', { verticalPosition: 'top', duration:5000 })
      }
    )


  }
}
