import { Component, OnInit, EventEmitter, Output  } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginRequest} from "../interfaces/LoginRequest";
import {AuthService} from "../services/Auth.service";
import {Staff} from "../interfaces/Staff";
import {Token} from "../interfaces/Token";


@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {

  @Output()
  test = new EventEmitter<number>();

  @Output()
  token = new EventEmitter<Token>();




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
        this.token.emit(data)

      },
      error => console.log(error)
    )
  }


}
