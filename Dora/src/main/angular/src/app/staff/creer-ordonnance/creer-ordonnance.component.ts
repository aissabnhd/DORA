import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Act} from "../../interfaces/Act";
import {AffectationService} from "../../services/Affectation.service";
import {DocumentService} from "../../services/Document.service";
import {Document, DocumentNature, DocumentType} from "../../interfaces/Document";
import {StaffService} from "../../services/Staff.service";
import {Staff} from "../../interfaces/Staff";

@Component({
  selector: 'app-creer-ordonnance',
  templateUrl: './creer-ordonnance.component.html',
  styleUrls: ['./creer-ordonnance.component.css']
})
export class CreerOrdonnanceComponent implements OnInit, OnDestroy {
  text: string = "";
  idDMP : number;
  idStaff : number;
  act : Act;
  listAct : Array<Act>;
  doc : Document;
  staff : Staff;
  constructor(private staffService : StaffService, private documentService : DocumentService, private route : ActivatedRoute, private affectationService : AffectationService) { }

  ngOnInit() {
    this.doc = new class implements Document {
      act: Act;
      dateCreation: Date;
      dateValidation: Date;
      extension: string;
      id: number;
      nature: DocumentNature;
      path: string;
      staffCreator: Staff;
      staffValidator: Staff;
      type: DocumentType;
      validation: boolean;
    };
    this.doc.dateCreation = new Date(Date.now());
    this.doc.extension = ".txt";
    this.doc.path = "./src/main/assets/ordonnance/" + "test" +".txt"
    this.doc.validation = false;
    this.doc.nature = DocumentNature.TEXT;
    this.doc.type = DocumentType.ORDER;
    this.idDMP = this.route.snapshot.params['idDMP'];
    this.idStaff = this.route.snapshot.params['idStaff'];

    this.affectationService.findCurrent(this.idDMP).subscribe(
      data => this.affectationService.findActsOf(data.id).subscribe(
        data2 => {

          this.listAct = data2;
          this.staffService.findById(this.idStaff).subscribe(
            data3 => {

              this.staff = data3;
              this.doc.staffCreator = this.staff;
            }
          )
          console.log(this.listAct)
        }

      )

    )

  }

  onCancel() {

  }

  onSubmit() {

  }

  onSave() {
    this.documentService.save(this.doc).subscribe(
      data => {
        console.log(data)
        this.documentService.write(this.text, data.id).subscribe(
          data2 => console.log(data2)
        )
      }
    ),
      error => console.log(error)
  }

  ngOnDestroy(): void {
    // save the document
  }

  Choose(act : Act) {
    this.act = act
    this.doc.act = act;
  }
}
