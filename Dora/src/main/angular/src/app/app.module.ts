import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { MailOublieComponent } from './mail-oublie/mail-oublie.component';
import { MedecinComponent } from './medecin/medecin.component';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatIconModule} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import { AjaateComponent } from './ajaate/ajaate.component';
import { HelpComponent } from './help/help.component';
import { DocumentsComponent } from './medecin/documents/documents.component';
import { DiagnostiqueComponent } from './medecin/diagnostique/diagnostique.component';
import { CrComponent } from './medecin/cr/cr.component';
import { OrdonnanceComponent } from './medecin/ordonnance/ordonnance.component';
import { ExamenComponent } from './medecin/examen/examen.component';
import { StaffComponent } from './staff/staff.component';
import { AfficheDmpComponent } from './staff/affiche-dmp/affiche-dmp.component';
import { CreerCrComponent } from './staff/creer-cr/creer-cr.component';
import { CreerDiagnostiqueComponent } from './staff/creer-diagnostique/creer-diagnostique.component';
import { DemandeExamenComponent } from './staff/demande-examen/demande-examen.component';
import { CreerOrdonnanceComponent } from './staff/creer-ordonnance/creer-ordonnance.component';
import { CreerDmpComponent } from './staff/creer-dmp/creer-dmp.component';
import { AffecterPatientComponent } from './staff/affecter-patient/affecter-patient.component';
import { GestionAgendaMedecinComponent } from './staff/gestion-agenda-medecin/gestion-agenda-medecin.component';
import { GestionMaterielComponent } from './staff/gestion-materiel/gestion-materiel.component';


@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    MailOublieComponent,
    MedecinComponent,
    AjaateComponent,
    HelpComponent,
    DocumentsComponent,
    DiagnostiqueComponent,
    CrComponent,
    OrdonnanceComponent,
    ExamenComponent,
    StaffComponent,
    AfficheDmpComponent,
    CreerCrComponent,
    CreerDiagnostiqueComponent,
    DemandeExamenComponent,
    CreerOrdonnanceComponent,
    CreerDmpComponent,
    AffecterPatientComponent,
    GestionAgendaMedecinComponent,
    GestionMaterielComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatIconModule,
    MatSidenavModule,
    BrowserAnimationsModule

  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
