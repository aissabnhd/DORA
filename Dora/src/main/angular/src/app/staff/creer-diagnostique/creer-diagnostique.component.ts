import {Component, OnDestroy, OnInit} from '@angular/core';

@Component({
  selector: 'app-creer-diagnostique',
  templateUrl: './creer-diagnostique.component.html',
  styleUrls: ['./creer-diagnostique.component.css']
})
export class CreerDiagnostiqueComponent implements OnInit, OnDestroy {
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
