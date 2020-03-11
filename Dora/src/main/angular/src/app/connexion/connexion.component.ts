import { Component, OnInit, EventEmitter, Output  } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {LoginRequest} from "../interfaces/LoginRequest";
import {AuthService} from "../services/Auth.service";
import {Staff} from "../interfaces/Staff";
import {Token} from "../interfaces/Token";
import {MatSnackBar} from "@angular/material/snack-bar";


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



  send = false;
  connexionForm : FormGroup;
  show = false;
  passwordForm : FormGroup;
  private forgot: boolean = false;

  constructor(private snackBar : MatSnackBar, private loginRequestService : AuthService, private router:Router, private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.connexionForm = this.formBuilder.group({
      email: [null, Validators.required],
      password: [null, Validators.required],
    });
    this.passwordForm = this.formBuilder.group({
      key: [null, Validators.required],
      password: [null, Validators.required],
      email: [null, Validators.required]

    })

  }

  submit(){
    let connexion : LoginRequest = this.connexionForm.value;
    this.loginRequestService.authenticateUser(connexion).subscribe(
      data => {
        this.token.emit(data);
        this.snackBar.open("Connecté(e) !", 'OK', { verticalPosition: 'top', duration:5000 })


      },
      error => this.snackBar.open("Mauvais login/mot de passe !", 'OK', { verticalPosition: 'top', duration:5000 })
    )
  }


  showPassword() {
    this.show = !this.show;
  }

  isForgot() {
    return this.forgot;
  }

  mailForgot() {
    this.forgot = true;
    this.show = false;

  }

  sendMail() {
    this.loginRequestService.sendMail(this.connexionForm.get('email').value).subscribe(
      data =>  {
        this.send = true;
        this.passwordForm.get('key').reset();
        this.passwordForm.get('password').reset();
        this.passwordForm.patchValue({
          email: this.connexionForm.get('email').value,
        });
        this.snackBar.open("Mail envoyé à " + this.connexionForm.get('email').value + "  !", 'OK', { verticalPosition: 'top', duration:5000 })
      },

    error => this.snackBar.open("Mail : " + this.connexionForm.get('email').value + " inconnu  !", 'OK', { verticalPosition: 'top', duration:5000 })

    );
  }

  back(b : boolean) {
    this.forgot = false;
    this.send = false;
    this.show = false;
    this.connexionForm.get('password').reset()
    if(b)
     this.snackBar.open("Annulation !", 'OK', { verticalPosition: 'top', duration:5000 });

  }

  changePassword() {
    this.loginRequestService.changePassword(this.passwordForm.get('email').value, this.passwordForm.get('key').value, this.passwordForm.get('password').value).subscribe(
      data =>         {
        this.snackBar.open("Mot de passe modifié !", 'OK', { verticalPosition: 'top', duration:5000 });
        this.forgot = false;
        this.send = false;
        this.show = false;
        this.connexionForm.get('password').reset()
      },
            error =>   {
          console.log(error);
        this.snackBar.open(error.error.message, 'OK', { verticalPosition: 'top', duration:5000 })
            }

  )
  }
}
