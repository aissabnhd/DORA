import { Component, OnInit } from '@angular/core';
import {Level, Struct} from "../../../interfaces/Struct";
import {FormControl, FormGroup} from "@angular/forms";
import {StructService} from "../../../services/Struct.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-struct',
  templateUrl: './create-struct.component.html',
  styleUrls: ['./create-struct.component.css']
})
export class CreateStructComponent implements OnInit {
  levels = [Level.CARE_UNIT, Level.APHP, Level.FONCTIONAL_UNIT, Level.HOSPITAL, Level.POLE, Level.SERVICE];
  structForm : FormGroup;
  constructor(private router : Router, private structService : StructService) { }

  ngOnInit() {
    this.structForm = new FormGroup({
      nameStruct: new FormControl(),
        level: new FormControl(),
        postCode: new FormControl(),
        city: new FormControl(),
        street: new FormControl(),
        country: new FormControl()

      }
    );
  }

  createStruct() {
    let s : Struct = this.structForm.value;
    this.structService.create(s).subscribe(
      data =>   this.router.navigate(['/gestion_aphp'])
    )
  }
}
