import { Component, OnInit, EventEmitter, Output  } from '@angular/core';
import { Router } from '@angular/router';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-connexion',
  templateUrl: './connexion.component.html',
  styleUrls: ['./connexion.component.css']
})
export class ConnexionComponent implements OnInit {

  @Output()
  test = new EventEmitter<number>();

  @Output()
  name_event = new EventEmitter<String>();

  loginValue= "";

  connexionForm : FormGroup;

  constructor(private router:Router, private formBuilder : FormBuilder) { }

  ngOnInit() {
    this.connexionForm = this.formBuilder.group({
      login: [null, Validators.required],
      password: [null, Validators.required],
    });

  }

  connect(){
    this.test.emit(1);
    this.name_event.emit(this.loginValue);
  }

  onLoginChange($event){
    this.loginValue = $event;
  }


}
