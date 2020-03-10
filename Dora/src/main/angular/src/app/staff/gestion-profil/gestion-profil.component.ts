import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ActivatedRoute, Router} from "@angular/router";
import {StaffService} from "../../services/Staff.service";
import {Staff} from "../../interfaces/Staff";

@Component({
  selector: 'app-gestion-profil',
  templateUrl: './gestion-profil.component.html',
  styleUrls: ['./gestion-profil.component.css']
})
export class GestionProfilComponent implements OnInit {

  staffForm: FormGroup;
  idStaff : number;
  staff : Staff;
  constructor(private snackBar : MatSnackBar, private router : Router, private staffService : StaffService, private route: ActivatedRoute) { }

  ngOnInit() {
    this.idStaff = this.route.snapshot.params['idStaff'];

    this.staffService.findById(this.idStaff).subscribe(data => {
      this.staff = data;
        this.staffForm = new FormGroup({
          firstName: new FormControl(data.firstName),
          lastName: new FormControl(data.lastName),
          birthday: new FormControl(new Date(data.birthday).toISOString().substring(0, 10)),
          nationality: new FormControl(data.nationality),
          phoneNumber: new FormControl(data.phoneNumber),
          rib: new FormControl(data.rib),
          postcode: new FormControl(data.postcode),
          city: new FormControl(data.city),
          street: new FormControl(data.street),
          country: new FormControl(data.country)

        });

      }
    );

  }

  onSubmit(){
      this.staff.firstName = this.staffForm.get('firstName').value;
      this.staff.lastName = this.staffForm.get('lastName').value;
      this.staff.birthday = this.staffForm.get('birthday').value;
      this.staff.nationality = this.staffForm.get('nationality').value;
      this.staff.phoneNumber = this.staffForm.get('phoneNumber').value;
      this.staff.rib = this.staffForm.get('rib').value;
      this.staff.postcode = this.staffForm.get('postcode').value;
      this.staff.city = this.staffForm.get('city').value;
      this.staff.street = this.staffForm.get('street').value;
      this.staff.country = this.staffForm.get('country').value;
      console.log(this.staffForm.value)
      this.staffService.save(this.staff).subscribe(
     data => {
       this.staffService.sendStaff(data);

       console.log(data)
     }
   )

  }

}
