import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Staff} from "../../../interfaces/Staff";
import {StaffService} from "../../../services/Staff.service";

@Component({
  selector: 'app-one-staff',
  templateUrl: './one-staff.component.html',
  styleUrls: ['./one-staff.component.css']
})
export class OneStaffComponent implements OnInit {

  @Input()
  staff : Staff;
  constructor(private staffService : StaffService) { }

  ngOnInit() {
    console.log(this.staff.roles[0].name)
  }

  formatDate(nombre : number, chiffre : number) {
    var temp = '' + nombre;
    while ((temp.length < chiffre) && (temp = '0' + temp)) {}
    return temp;
  }

  dateToString(d : Date){
    let d2 = new Date(d);
    return "" + this.formatDate(d2.getDate(), 2) + "/" + this.formatDate(d2.getMonth()+1, 2) + "/" + this.formatDate(d2.getFullYear(), 4);
  }
}
