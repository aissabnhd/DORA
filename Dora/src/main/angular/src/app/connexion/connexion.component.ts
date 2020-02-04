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

  constructor(private router:Router) { }

  ngOnInit() {

  }

  connect(){
    this.test.emit(1);
  }


}
