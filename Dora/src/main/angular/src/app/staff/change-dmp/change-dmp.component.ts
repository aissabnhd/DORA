import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {DMP} from "../../interfaces/DMP";
import {DMPService} from "../../services/DMP.service";

@Component({
  selector: 'app-change-dmp',
  templateUrl: './change-dmp.component.html',
  styleUrls: ['./change-dmp.component.css']
})
export class ChangeDmpComponent implements OnInit {

  dmp : DMP;

  allDMP : Array<DMP>;

  @Output()
  changeDMP = new EventEmitter<DMP>();

  constructor(private dmpService : DMPService) { }

  ngOnInit() {
    this.dmpService.findAllDMP().subscribe(
      data => this.allDMP = data

    )

  }

  onSubmit(id : number){

    console.log(this.dmpService.findByIdDMP(id));

  }

}
