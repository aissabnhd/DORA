import {Component, Input, OnInit} from '@angular/core';
import {Level, Struct} from "../../../interfaces/Struct";

@Component({
  selector: ' tr [struct]',
  templateUrl: './one-struct.component.html',
  styleUrls: ['./one-struct.component.css']
})
export class OneStructComponent implements OnInit {

  @Input()
  struct : Struct;

  level = [Level.APHP, Level.SERVICE, Level.POLE, Level.HOSPITAL, Level.FONCTIONAL_UNIT, Level.CARE_UNIT];
  constructor() { }

  ngOnInit() {
  }

}
