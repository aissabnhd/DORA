import { Component, OnInit } from '@angular/core';
import {Staff} from "../interfaces/Staff";
import {ActivatedRoute} from "@angular/router";
import {StaffService} from "../services/Staff.service";

@Component({
  selector: 'app-agenda',
  templateUrl: './agenda.component.html',
  styleUrls: ['./agenda.component.css']
})
export class AgendaComponent implements OnInit {

  staff : Staff;
  constructor(private staffService : StaffService, private route : ActivatedRoute) { }

  ngOnInit() {
    let idStaff = this.route.snapshot.params['idStaff'];
    this.staffService.findById(idStaff).subscribe(
      data => this.staff = data
    )
  }

}
