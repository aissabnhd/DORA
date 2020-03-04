import { Component, OnInit, EventEmitter, Output  } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginRequest} from "../interfaces/LoginRequest";
import {AuthService} from "../services/Auth.service";
import {Staff} from "../interfaces/Staff";


@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {

  @Output()
  test = new EventEmitter<number>();

  @Output()
  connection_event = new EventEmitter<Staff>();

  @Output()
  infos = new EventEmitter<[String, String]>();



  connexionForm : FormGroup;

  constructor(private loginRequestService : AuthService, private router:Router, private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.connexionForm = this.formBuilder.group({
      email: [null, Validators.required],
      password: [null, Validators.required],
    });

  }

  submit(){
    let connexion : LoginRequest = this.connexionForm.value;
    this.loginRequestService.authenticateUser(connexion).subscribe(
      data => {
        this.infos.emit([data.name, data.roles[0]])

      },
      error => console.log(error)
    )
  }


}
