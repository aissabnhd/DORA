import { Component, OnInit } from '@angular/core';
import {StaffService} from "../../services/Staff.service";
import {Staff} from "../../interfaces/Staff";
import {Router} from "@angular/router";

@Component({
  selector: 'app-ajout-membre',
  templateUrl: './ajout-membre.component.html',
  styleUrls: ['./ajout-membre.component.css']
})
export class AjoutMembreComponent implements OnInit {

  staffs : Array<Staff> = [];
  constructor(private router : Router, private staffService : StaffService) { }

  ngOnInit() {
    this.staffService.findAll().subscribe(
      data => {
        this.staffs = data;
        console.log(this.staffs);
      }
    )
  }

  update(id: number) {
    this.router.navigate(['/update_staff/' + id])
  }
}
