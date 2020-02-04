import { Component, OnInit, EventEmitter, Output  } from '@angular/core';
import { Router } from '@angular/router';


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

  constructor(private router:Router) { }

  ngOnInit() {

  }

  connect(){
    this.test.emit(1);
    this.name_event.emit(this.loginValue);
  }

  onLoginChange($event){
    this.loginValue = $event;
  }


}
