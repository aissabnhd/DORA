import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {delay} from "rxjs/operators";
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-deconnexion',
  templateUrl: './deconnexion.component.html',
  styleUrls: ['./deconnexion.component.css']
})
export class DeconnexionComponent implements OnInit {

  constructor(private snackBar : MatSnackBar) { }

  ngOnInit() {
    this.refresh();
  }

  refresh(){
    this.snackBar.open("Déconnexion (sauvegarde en cours des éventuels fichiers) !", 'OK', { verticalPosition: 'top', duration:2000 })
    setTimeout(() =>
      {
        window.location.replace("http://localhost:8080")
      },
      2000);

  }

}
