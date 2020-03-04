import { Component } from '@angular/core';
import {Staff} from "./interfaces/Staff";
import {RoleName} from "./interfaces/Role";

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


  connected($event){
  if($event == 1)
     this.isConnected = true;
  else
    this.isConnected = false;
  }

  change_name($event){
    this.nom = $event[0];
    this.role = $event[1];
    console.log($event);
    this.isConnected = true;
  }

  getNom(){
  return this.staff.lastName;
  }
}


