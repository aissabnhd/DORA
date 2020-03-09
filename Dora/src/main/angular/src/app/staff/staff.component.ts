import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Staff} from "../interfaces/Staff";
import {DMP} from "../interfaces/DMP";
import {RoleName} from "../interfaces/Role";
import {ActivatedRoute} from "@angular/router";
import {DMPService} from "../services/DMP.service";

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {
  staff : Staff;
  id : number
  @Input()
  role : RoleName;
  @Input()
  name : String;
  @Input()
  dmp : DMP ;
  isMedecin: boolean = false;
  isLaborantin : boolean = false;
  isAdmin : boolean = false;
  isSecretaire: boolean = false;
  isInfirmier: boolean = false;
  @Output()
  test = new EventEmitter<number>();

  constructor(private route : ActivatedRoute, private dmpService : DMPService) { }

  ngOnInit() {
    let id = this.route.snapshot.params['id']
    if(id != undefined) {
      this.dmpService.findByIdDMP(this.id).subscribe(
        data => this.dmp = data
      )
    }
    this.staff = {
      "id": 1,
      "firstName": "Jaja",
      "lastName": "Benni",
      "birthday": null,
      "nationality": "francais(?)",
      "phoneNumber": "06",
      "email": "jaja@gmail.com",
      "rib": "0",
      "postcode": 75000,
      "city": "Pavillons-sous-bois",
      "street": "garsdelastreet",
      "country": "France",
      "linkCalendar": "???",
      "roles": null,
      "structBelong": null,
      "structResponsible": null,
      "specialities": null
    };

    if(this.role ==  RoleName.DOCTOR){
      this.isMedecin = true;
    }
    else if(this.role == RoleName.NURSE){
      this.isInfirmier = true;
    }
    else if(this.role == RoleName.LABORATORY){
      this.isLaborantin = true;
    }
    else if(this.role == RoleName.SECRETARY){
      this.isSecretaire = true;
    }
    else if(this.role == RoleName.ADMINISTRATOR){
      this.isAdmin = true;
    }

    this.dmpService.event.subscribe(
      data => this.dmp = data
    )

    // @ts-ignore
    this.staff.lastName = this.name;
  }

  disconnect(){
    this.test.emit(2);
  }

}