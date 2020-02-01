import { Component, OnInit } from '@angular/core';
import {DMP} from "../../interfaces/DMP";

@Component({
  selector: 'app-creer-dmp',
  templateUrl: './creer-dmp.component.html',
  styleUrls: ['./creer-dmp.component.css']
})
export class CreerDmpComponent implements OnInit {
  dmp: DMP;
  constructor() { }

  ngOnInit() {
  }

  creationDMP() {

  }
}
