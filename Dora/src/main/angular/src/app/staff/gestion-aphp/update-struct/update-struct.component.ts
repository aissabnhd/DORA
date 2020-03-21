import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Level, Struct} from "../../../interfaces/Struct";
import {FormControl, FormGroup} from "@angular/forms";
import {StructService} from "../../../services/Struct.service";

@Component({
  selector: 'app-update-struct',
  templateUrl: './update-struct.component.html',
  styleUrls: ['./update-struct.component.css']
})
export class UpdateStructComponent implements OnInit {

  levels = [Level.CARE_UNIT, Level.APHP, Level.FONCTIONAL_UNIT, Level.HOSPITAL, Level.POLE, Level.SERVICE];
  structForm : FormGroup;
  struct : Struct;
  constructor(private router : Router, private structService : StructService, private route : ActivatedRoute) { }

  ngOnInit() {
    let id = this.route.snapshot.params['id'];
    this.structService.findOne(id).subscribe(
      data => {
        this.struct = data;
        this.structForm = new FormGroup({
          id: new FormControl(id),
          level: new FormControl(),
          nameStruct: new FormControl(data.nameStruct),
          postCode: new FormControl(data.postCode),
          city:  new FormControl(data.city),
          street: new FormControl(data.street),
          country:  new FormControl(data.country),

        });
        this.updateForm(data.level);
      }
    )
  }
  private updateForm(level: any) {

    this.structForm.patchValue({
      level : this.levels[this.getIndice(level)]
    });
  }

  getIndice(level : Level){
    for(let i = 0; i < this.levels.length; i++){
      if(this.levels[i] == level)
        return i
    }
    return 0;
  }

  updateStruct() {
    let s : Struct = this.structForm.value;
    console.log(s);
    this.structService.create(s).subscribe(
      data => this.router.navigate(['/gestion_aphp'])
    )
  }
}
