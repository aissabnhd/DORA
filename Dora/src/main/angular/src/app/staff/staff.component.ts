import { Component, OnInit } from '@angular/core';
import {Staff} from "../interfaces/Staff";
import {DMP} from "../interfaces/DMP";
import {RoleName} from "../interfaces/Role";

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {
  staff : Staff;
  dmp : DMP ;
  isMedecin: boolean = false;
  isLaborantin : boolean = false;
  isAdmin : boolean = false;
  isSecretaire: boolean = false;
  isInfirmier: boolean = false;

  constructor() { }

  ngOnInit() {
   this.staff = {"id": 1, "firstName" : "Jaja", "lastName" : "Benni", "birthday": null, "nationality": "francais(?)",
      "phoneNumber": "06","email": "jaja@gmail.com", "rib": "0", "postcode":75000, "city": "Pavillons-sous-bois",
      "street": "garsdelastreet", "country":"France", "linkCalendar": "???", "role": null, "structBelong": null, "structResponsible": null, "specialities" :null};
    this.isInfirmier = true;
    this.dmp = {"id": 1, "firstName" : "Alain", "lastName" : "BECILE", "birthday": null, "nationality": "francais(?)",
      "phoneNumber": "06","email": "jaja@gmail.com",  "postcode":75000, "city": "Pavillons-sous-bois",
      "street": "garsdelastreet", "country":"France", "socialSecurityNumber":"1", "allergy": "non", "hospitalizations": null };

  }

}
