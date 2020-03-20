import { Component, OnInit } from '@angular/core';
import {Staff} from "../../../interfaces/Staff";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Role, RoleName} from "../../../interfaces/Role";
import {ActivatedRoute, Router} from "@angular/router";
import {StaffService} from "../../../services/Staff.service";

@Component({
  selector: 'app-create-staff',
  templateUrl: './create-staff.component.html',
  styleUrls: ['./create-staff.component.css']
})
export class CreateStaffComponent implements OnInit {

  staff : Staff;
  staffForm : FormGroup;
  roles = [RoleName.ADMINISTRATOR, RoleName.DOCTOR, RoleName.LABORATORY, RoleName.SECRETARY, RoleName.NURSE];

  constructor(private router : Router, private formBuilder : FormBuilder, private route : ActivatedRoute, private staffService : StaffService) { }

  ngOnInit() {
        this.staffForm = new FormGroup({
            lastName: new FormControl(),
            firstName: new FormControl(),
            birthday: new FormControl(),
            nationality: new FormControl(),
            phoneNumber:  new FormControl(),
            rib:  new FormControl(),
            postcode: new FormControl(),
            city: new FormControl(),
            street: new FormControl(),
            country: new FormControl(),
            email: new FormControl(),
            password:new FormControl(),
            role : new FormControl(),
            linkCalendar:new FormControl()

          }
        );
  }



  createStaff() {
    let s : Staff = this.staffForm.value;
    let r = new class implements Role {
      id: number;
      name: RoleName;
    }
    r.id = 1;
    r.name = this.staffForm.get("role").value;
    console.log(r);
    this.staffService.create(s).subscribe(
      data => {
        this.staffService.setRole(data.id, r).subscribe(
          data =>  this.router.navigate(['/ajout_membre'])
        )

      }
    )
  }
}
