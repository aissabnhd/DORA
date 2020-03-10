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
       this.snackBar.open("Profil modifié !", 'OK', { verticalPosition: 'top', duration:5000 })

       console.log(data)
     }
   )

  }

  isEmpty(){
    let s1 : String = this.staffForm.get('firstName').value;
    let s2 : String = this.staffForm.get('lastName').value;
    let s3 : String = this.staffForm.get('birthday').value;
    let s4 : String = this.staffForm.get('nationality').value;
    let s5 : String = this.staffForm.get('phoneNumber').value;
    let s6 : String = this.staffForm.get('rib').value;
    let s7 : string = this.staffForm.get('postcode').value;
    let s8 : String = this.staffForm.get('city').value;
    let s9 : String = this.staffForm.get('street').value;
    let s10 : String = this.staffForm.get('country').value;
    return (s1.trim()=="")
      || (s2.trim()=="")
      || (s3.trim()=="")
      || (s4.trim()=="")
      || (s5.trim()=="")
      || (s6.trim()=="")
      || s7 == null
      || (s8.trim()=="")
      || (s9.trim()=="")
      || (s10.trim()=="")
      ;


  }

}
