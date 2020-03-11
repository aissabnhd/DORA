import {Component, OnDestroy, OnInit} from '@angular/core';
import {Act} from "../../interfaces/Act";
import {Document, DocumentNature, DocumentType} from "../../interfaces/Document";
import {Staff} from "../../interfaces/Staff";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {MatSnackBar} from "@angular/material/snack-bar";
import {StaffService} from "../../services/Staff.service";
import {DocumentService} from "../../services/Document.service";
import {ActivatedRoute} from "@angular/router";
import {AffectationService} from "../../services/Affectation.service";
import {RoleName} from "../../interfaces/Role";
import {Hospitalization} from "../../interfaces/Hospitalization";
import {HospitalizationService} from "../../services/Hospitalization.service";
import {Affectation} from "../../interfaces/Affectation";
import {ActService} from "../../services/Act.service";

@Component({
  selector: 'app-remarques',
  templateUrl: './remarques.component.html',
  styleUrls: ['./remarques.component.css']
})
export class RemarquesComponent implements OnInit, OnDestroy {
  text: string = "";
  idDMP : number;
  idStaff : number;
  doc : Document;
  staff : Staff;
  act : Act;
  fileForm: FormGroup;
  hospitalisation : Hospitalization;
  constructor(private actService : ActService, private snackBar : MatSnackBar, private formBuilder : FormBuilder, private staffService : StaffService, private documentService : DocumentService, private route : ActivatedRoute, private affectationService : AffectationService) { }

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

    this.fileForm = this.formBuilder.group({
      text: [null, Validators.required]
    });
    this.documentService.nextIdFile("./src/main/assets/remarques/").subscribe(
      data =>  this.doc.path = "./src/main/assets/remarques/remarques" + (data+1) +".txt"
    )
    this.doc.dateCreation = new Date(Date.now());
    this.doc.extension = ".txt";

    this.doc.validation = false;
    this.doc.nature = DocumentNature.TEXT;
    this.doc.type = DocumentType.NOTES;
    this.idDMP = this.route.snapshot.params['idDMP'];
    this.idStaff = this.route.snapshot.params['idStaff'];



    this.staffService.findById(this.idStaff).subscribe(
      data3 => {
        this.staff = data3;
        this.doc.staffCreator = this.staff;
        this.documentService.findRemarqueOf(this.idDMP).subscribe(
          data => {
            this.doc = data;
            console.log("reader : ",this.doc.id);

            this.documentService.reader(this.doc.id).subscribe(
              data => {
                console.log("txt : ", data[0]);
                let s = "";
                for(let i = 0; i < data.length; i++){
                  s += data[i];
                  if(i < data.length - 1)
                    s += "\n"
                }
                this.fileForm.patchValue({
                  text : s
                });
                this.documentService.findAll().subscribe(
                  data => console.log(data)
                )
              }

            )

          }, // this.doc = data,
          error => this.createNewRemarque()
        )

      }
    )



  }

  createNewRemarque() {
    console.log("here")
    let act : Act = new class implements Act {
      affectation: Affectation;
      date: Date;
      done: boolean;
      id: number;
      staff: Staff;
      type: string;
    }
    this.affectationService.findCurrent(this.idDMP).subscribe(
        data => {
          act.affectation = data;
          act.done = true;
          act.type = "Remarques";
          act.staff = this.staff;
          console.log(act);
          this.actService.save(act).subscribe(
            data => {
              this.act = data;
              this.doc.act = data;
            },
            error => console.log(error)
          )
        }

    )
  }

  onSave() {
    this.snackBar.open("Document sauvegardé !", 'OK', { verticalPosition: 'top', duration:5000 })
    console.log(this.doc);
    console.log(this.fileForm.get("text").value)
    this.documentService.save(this.doc).subscribe(
      data => {
        console.log(data)
        this.documentService.write(this.fileForm.get("text").value, data.id).subscribe(
          data2 => console.log(data2)
        )
      }
    ),
      error => console.log(error)
  }

  ngOnDestroy(): void {
      this.onSave();

  }



}
