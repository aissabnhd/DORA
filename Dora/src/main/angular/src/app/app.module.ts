import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ConnexionComponent } from './connexion/connexion.component';
import { MailOublieComponent } from './mail-oublie/mail-oublie.component';
import { MedecinComponent } from './medecin/medecin.component';
import { LaborantinComponent } from './laborantin/laborantin.component';
import { SecretaireComponent } from './secretaire/secretaire.component';
import { InfirmiereComponent } from './infirmiere/infirmiere.component';
import { AdminComponent } from './admin/admin.component';
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


@NgModule({
  declarations: [
    AppComponent,
    ConnexionComponent,
    MailOublieComponent,
    MedecinComponent,
    LaborantinComponent,
    SecretaireComponent,
    InfirmiereComponent,
    AdminComponent,
    AjaateComponent,
    HelpComponent,
    DocumentsComponent,
    DiagnostiqueComponent,
    CrComponent,
    OrdonnanceComponent,
    ExamenComponent
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
