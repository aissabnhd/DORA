import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'angular';
  isConnected = false;
  nom = "";


  connected($event){
  if($event == 1)
     this.isConnected = true;
  else
    this.isConnected = false;
  }

  change_name($event){
    this.nom = $event;
  }

  getNom(){
  return this.nom;
  }
}


