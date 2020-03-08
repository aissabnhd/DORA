import {Component, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-creer-cr',
  templateUrl: './creer-cr.component.html',
  styleUrls: ['./creer-cr.component.css']
})
export class CreerCrComponent implements OnInit, OnDestroy {
  text: string = "";
  constructor() { }

  ngOnInit() {
  }

  onSubmit() {

  }

  onCancel() {

  }

  ngOnDestroy(){
    //sauvegarde du document
    console.log("sauvegarde auto");
  }

  onSave() {

  }
}
