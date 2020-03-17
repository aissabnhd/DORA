import { Component, OnInit } from '@angular/core';
import { Staff } from '../interfaces/Staff';
import { DMP } from '../interfaces/DMP';

@Component({
  selector: 'app-medecin',
  templateUrl: './medecin.component.html',
  styleUrls: ['./medecin.component.css']
})
export class MedecinComponent implements OnInit {
 medecin : Staff = {"id": 1, "firstName" : "Jaja", "lastName" : "Benni", "birthday": null, "nationality": "francais(?)",
 "phoneNumber": "06","email": "jaja@gmail.com", "rib": "0", "postcode":75000, "city": "Pavillons-sous-bois",
  "street": "garsdelastreet", "country":"France", "linkCalendar": "???", "roles": null, "structBelong": null, "structResponsible": null, "specialities" :null};
  dmp : DMP = {"id": 1, "firstName" : "Alain", "lastName" : "BECILE", "birthday": null, "nationality": "francais(?)",
                "phoneNumber": "06","email": "jaja@gmail.com",  "postcode":75000, "city": "Pavillons-sous-bois",
                 "street": "garsdelastreet", "country":"France", "socialSecurityNumber":"1", "allergy": "non", "hospitalizations": null };
  isMedecin: boolean = false;
  constructor() {


  }

  ngOnInit() {
  }

}
