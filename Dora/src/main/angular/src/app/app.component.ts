import {Component, Optional} from '@angular/core';
import {Staff} from "./interfaces/Staff";
import {Role, RoleName} from "./interfaces/Role";
import {StaffService} from "./services/Staff.service";
import {AuthService} from "./services/Auth.service";
import {error} from "util";
import {Speciality} from "./interfaces/Speciality";
import {Struct} from "./interfaces/Struct";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular';
  isConnected = false;
  nom = "";
  role : RoleName;
  staff : Staff;
  token : string = "";
  id : number;

  constructor(private loginRequestService : AuthService, private staffService : StaffService) {
  }

  connected($event){
  if($event == 1)
     this.isConnected = true;
  else{
    this.loginRequestService.logOut(this.id).subscribe(
      data => {
        this.isConnected = false;
      },//this.isConnected = false,
      error => {
        this.isConnected = false;

      }

  )

  }
  }

  change_name($event){
    this.staff = new class implements Staff {
      birthday: any;
      city: string;
      country: string;
      email: string;
      firstName: string;
      id: number;
      lastName: string;
      linkCalendar: string;
      nationality: string;
      phoneNumber: string;
      postcode: number;
      rib: string;
      password: string;
      roles: Set<Role>;
      specialities: Set<Speciality>;
      street: string;
      structBelong: Struct;
      structResponsible: Struct;
    }
    this.token = $event.token;
    localStorage.setItem('Token', this.token);

    /*this.staffService.findByMail($event.email).subscribe(
      data => {
        console.log(data);
        console.log($event.email)
        this.staff = Optional.apply(data);

        console.log(this.staff)
        this.isConnected = true;

        this.nom = this.staff.lastName;
        this.role = this.staff.roles.values()[0];
      },

    );*/
    this.id = $event.id;
    this.staff.id = this.id;
    this.isConnected = true;

    this.nom = $event.name;
    this.role = $event.roles[0];
  }

  getNom(){
  return this.staff.lastName;
  }
}


