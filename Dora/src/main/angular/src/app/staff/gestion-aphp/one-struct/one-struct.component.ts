import {Component, Input, OnInit} from '@angular/core';
import {Struct} from "../../../interfaces/Struct";

@Component({
  selector: ' tr [struct]',
  templateUrl: './one-struct.component.html',
  styleUrls: ['./one-struct.component.css']
})
export class OneStructComponent implements OnInit {

  @Input()
  struct : Struct;
  constructor() { }

  ngOnInit() {
  }

}
