import {Component, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-creer-ordonnance',
  templateUrl: './creer-ordonnance.component.html',
  styleUrls: ['./creer-ordonnance.component.css']
})
export class CreerOrdonnanceComponent implements OnInit, OnDestroy {
  text: string = "";

  constructor() { }

  ngOnInit() {
  }

  onCancel() {

  }

  onSubmit() {

  }

  onSave() {

  }

  ngOnDestroy(): void {
    // save the document
  }
}
