import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-cr',
  templateUrl: './cr.component.html',
  styleUrls: ['./cr.component.css']
})
export class CrComponent implements OnInit {

  text: string = "";
  constructor() { }

  ngOnInit() {
  }

  onSubmit() {

  }

  ngOnDestroy(){
    //sauvegarde du document
    console.log("sauvegarde auto");
  }

  onCancel() {

  }
}
