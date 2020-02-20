import { Component, OnInit } from '@angular/core';
import {DMP} from "../../interfaces/DMP";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-creer-dmp',
  templateUrl: './creer-dmp.component.html',
  styleUrls: ['./creer-dmp.component.css']
})
export class CreerDmpComponent implements OnInit {
  dmp: DMP;

  DMPForm : FormGroup
  constructor(private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.DMPForm = this.formBuilder.group({
      nom: [null, Validators.required],
      prenom: [null, Validators.required],
      socialSecurityNumber:  [null, Validators.required]
    });
  }

  creationDMP() {

  }
}
