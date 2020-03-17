import { Component, OnInit } from '@angular/core';
import {DMP} from "../../interfaces/DMP";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {DMPService} from "../../services/DMP.service";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-creer-dmp',
  templateUrl: './creer-dmp.component.html',
  styleUrls: ['./creer-dmp.component.css']
})
export class CreerDmpComponent implements OnInit {
  dmp: DMP;

  DMPForm : FormGroup
  constructor(private snackBar : MatSnackBar, private formBuilder : FormBuilder, private dmpService : DMPService) { }

  ngOnInit() {
    this.DMPForm = this.formBuilder.group({
      firstName: [null, Validators.required],
      lastName: [null, Validators.required],
      socialSecurityNumber:  [null, Validators.required],
      birthday: [null, Validators.required],
      nationality: [null, Validators.required],
      postcode:  [null, Validators.required],
      phoneNumber:  [null, Validators.required],
      email:  [null, Validators.required],
      city: [null, Validators.required],
      street: [null, Validators.required],
      country:  [null, Validators.required],
      allergy:  [null, Validators.required]
    });
  }

  creationDMP() {
     this.dmp = this.DMPForm.value;
    this.dmpService.saveDMP(this.dmp).subscribe(
      data => {
        this.snackBar.open("DMP créé !", 'OK', { verticalPosition: 'top', duration:5000 })

        console.log(this.dmp)
      }
    );




  }
}
