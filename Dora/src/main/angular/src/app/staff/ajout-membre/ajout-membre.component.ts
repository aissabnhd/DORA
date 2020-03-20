import { Component, OnInit } from '@angular/core';
import {StaffService} from "../../services/Staff.service";
import {Staff} from "../../interfaces/Staff";

@Component({
  selector: 'app-ajout-membre',
  templateUrl: './ajout-membre.component.html',
  styleUrls: ['./ajout-membre.component.css']
})
export class AjoutMembreComponent implements OnInit {

  staffs : Array<Staff> = [];
  constructor(private staffService : StaffService) { }

  ngOnInit() {
    this.staffService.findAll().subscribe(
      data => {
        this.staffs = data;
        console.log(this.staffs);
      }
    )
  }

}
