import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Staff} from "../interfaces/Staff";
import {DMP} from "../interfaces/DMP";
import {RoleName} from "../interfaces/Role";
import {ActivatedRoute} from "@angular/router";
import {DMPService} from "../services/DMP.service";
import {HospitalizationService} from "../services/Hospitalization.service";
import {Hospitalization} from "../interfaces/Hospitalization";
import {StaffService} from "../services/Staff.service";

@Component({
  selector: 'app-staff',
  templateUrl: './staff.component.html',
  styleUrls: ['./staff.component.css']
})
export class StaffComponent implements OnInit {
  id : number
  @Input()
  role : RoleName;
  @Input()
  dmp : DMP ;
  @Input()
  staff : Staff;
  isMedecin: boolean = false;
  isLaborantin : boolean = false;
  isAdmin : boolean = false;
  isSecretaire: boolean = false;
  isInfirmier: boolean = false;
  currentHospitalization: Hospitalization;
  @Output()
  test = new EventEmitter<number>();


  constructor(private staffService : StaffService, private hospitalizationService : HospitalizationService, private route : ActivatedRoute, private dmpService : DMPService) { }

  ngOnInit() {
    let id = this.route.snapshot.params['id']
    if(id != undefined) {
      this.dmpService.findByIdDMP(this.id).subscribe(
        data => this.dmp = data
      )
    }

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
      data => {
        this.dmp = data;
        this.hospitalizationService.findCurrent(this.dmp.id).subscribe(
          data => this.currentHospitalization = data
        )
      }
    )

    this.staffService.findById(this.staff.id).subscribe(
      data => this.staff = data
    )

    this.staffService.event.subscribe(
      data => {
        this.staff = data;
      }
    )

  }

  disconnect(){
    this.test.emit(2);
  }

}
