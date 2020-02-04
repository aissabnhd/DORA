import { Component, OnInit, EventEmitter, Input, Output  } from '@angular/core';
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
  @Input()
  name = "Jaja";
  dmp : DMP ;
  isMedecin: boolean = false;
  isLaborantin : boolean = false;
  isAdmin : boolean = false;
  isSecretaire: boolean = false;
  isInfirmier: boolean = false;
  @Output()
  test = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
   this.staff = {"id": 1, "firstName" : "Jaja", "lastName" : "Benni", "birthday": null, "nationality": "francais(?)",
      "phoneNumber": "06","email": "jaja@gmail.com", "rib": "0", "postcode":75000, "city": "Pavillons-sous-bois",
      "street": "garsdelastreet", "country":"France", "linkCalendar": "???", "role": null, "structBelong": null, "structResponsible": null, "specialities" :null};
    this.isMedecin= true;
    this.dmp = {"id": 1, "firstName" : "Alain", "lastName" : "BECILE", "birthday": null, "nationality": "francais(?)",
      "phoneNumber": "06","email": "jaja@gmail.com",  "postcode":75000, "city": "Pavillons-sous-bois",
      "street": "garsdelastreet", "country":"France", "socialSecurityNumber":"1", "allergy": "non", "hospitalizations": null };
    this.staff.lastName = this.name;
  }

  disconnect(){
    this.test.emit(2);
  }

}
