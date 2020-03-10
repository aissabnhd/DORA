import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {Act} from "../../interfaces/Act";
import {AffectationService} from "../../services/Affectation.service";
import {DocumentService} from "../../services/Document.service";
import {Document, DocumentNature, DocumentType} from "../../interfaces/Document";
import {StaffService} from "../../services/Staff.service";
import {Staff} from "../../interfaces/Staff";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {RoleName} from "../../interfaces/Role";
import {MatSnackBar} from "@angular/material/snack-bar";

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
  fileForm: FormGroup;
  private isDoctor= false;
  private isPublish: boolean = false;
  constructor(private snackBar : MatSnackBar, private formBuilder : FormBuilder, private staffService : StaffService, private documentService : DocumentService, private route : ActivatedRoute, private affectationService : AffectationService) { }

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
    this.doc.dateCreation = new Date(Date.now());
    this.doc.extension = ".txt";
    this.documentService.nextIdFile("./src/main/assets/ordonnance/").subscribe(
      data =>  this.doc.path = "./src/main/assets/ordonnance/ordonnance" + (data+1) +".txt"
    );
    this.doc.validation = false;
    this.doc.nature = DocumentNature.TEXT;
    this.doc.type = DocumentType.ORDER;
    this.idDMP = this.route.snapshot.params['idDMP'];
    this.idStaff = this.route.snapshot.params['idStaff'];

    this.staffService.findById(this.idStaff).subscribe(
      data3 => {

        this.staff = data3;
        this.isDoctor = (this.staff.roles[0].name == RoleName.DOCTOR);
        this.doc.staffCreator = this.staff;
        this.affectationService.findCurrent(this.idDMP).subscribe(
          data => this.affectationService.findAllByDone(true, data.id).subscribe(
            data2 => {

              this.listAct = data2;

              console.log(this.listAct)
            }

          )

        )
      }
    )



  }


  onPublish() {
    this.doc.dateValidation = new Date(Date.now());
    this.doc.validation = true;
    this.isPublish = true;
    this.snackBar.open("Document publié !", 'OK', { verticalPosition: 'top', duration:5000 });
    this.doc.staffValidator = this.doc.staffCreator;
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

  onSave() {
    this.snackBar.open("Document sauvegardé !", 'OK', { verticalPosition: 'top', duration:5000 })
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
    if(this.act && !this.isPublish) {
      this.onSave();
    }
  }

  Choose(act : Act) {
    this.act = act
    this.doc.act = act;
  }

  onCancel() {
    this.act = null;
    this.isPublish = false;
    this.fileForm.get('text').reset();
    this.documentService.nextIdFile("./src/main/assets/ordonnance/").subscribe(
      data =>  this.doc.path = "./src/main/assets/ordonnance/ordonnance" + (data+1) +".txt"
    )
  }

  isMedecin() {

        return this.isDoctor;



  }
}
