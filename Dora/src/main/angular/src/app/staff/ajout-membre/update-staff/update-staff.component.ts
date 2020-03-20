import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Route, Router} from "@angular/router";
import {Staff} from "../../../interfaces/Staff";
import {StaffService} from "../../../services/Staff.service";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Role, RoleName} from "../../../interfaces/Role";

@Component({
  selector: 'app-update-staff',
  templateUrl: './update-staff.component.html',
  styleUrls: ['./update-staff.component.css']
})
export class UpdateStaffComponent implements OnInit {

  staff : Staff;
  staffForm : FormGroup;
  roles = [RoleName.ADMINISTRATOR, RoleName.DOCTOR, RoleName.LABORATORY, RoleName.SECRETARY, RoleName.NURSE];

  constructor(private router : Router, private formBuilder : FormBuilder, private route : ActivatedRoute, private staffService : StaffService) { }

  ngOnInit() {
    let id = this.route.snapshot.params['id'];
    this.staffService.findById(id).subscribe(
      data => {
        this.staff = data;
        this.staffForm = new FormGroup({
          id: new FormControl(id),
          lastName: new FormControl(data.lastName),
          firstName: new FormControl(data.firstName),
          birthday: new FormControl(new Date(data.birthday).toISOString().substring(0, 10)),
          nationality: new FormControl(data.nationality),
          phoneNumber:  new FormControl(data.phoneNumber),
          rib:  new FormControl(data.rib),
          postcode: new FormControl(data.postcode),
          city:  new FormControl(data.city),
          street: new FormControl(data.street),
          country:  new FormControl(data.country),

      }
    );
        this.updateForm(data.roles[0]);
  })
  }

  private updateForm(role: any) {

    this.staffForm.patchValue({
      role : this.roles[this.getIndice(role)]
    });
  }

  getIndice(role : any){
    for(let i = 0; i < this.roles.length; i++){
      if(this.roles[i] == role.name)
        return i
    }
    return 0;
  }

  updateStaff() {
    let s : Staff = this.staffForm.value;
    s.password = this.staff.password;
    console.log(s);
    this.staffService.save(s).subscribe(
      data =>     this.router.navigate(['/ajout_membre'])

  )
  }
}
