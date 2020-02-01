import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { DocumentsComponent } from './medecin/documents/documents.component';
import { DiagnostiqueComponent } from './medecin/diagnostique/diagnostique.component';
import { CrComponent } from './medecin/cr/cr.component';
import { OrdonnanceComponent } from './medecin/ordonnance/ordonnance.component';
import { ExamenComponent } from './medecin/examen/examen.component';
import { MedecinComponent } from './medecin/medecin.component';
import {StaffComponent} from "./staff/staff.component";
import {CreerDmpComponent} from "./staff/creer-dmp/creer-dmp.component";
import {GestionMaterielComponent} from "./staff/gestion-materiel/gestion-materiel.component";
import {GestionAgendaMedecinComponent} from "./staff/gestion-agenda-medecin/gestion-agenda-medecin.component";
import {AffecterPatientComponent} from "./staff/affecter-patient/affecter-patient.component";
import {CreerOrdonnanceComponent} from "./staff/creer-ordonnance/creer-ordonnance.component";
import {CreerDiagnostiqueComponent} from "./staff/creer-diagnostique/creer-diagnostique.component";
import {CreerCrComponent} from "./staff/creer-cr/creer-cr.component";
import {AfficheDmpComponent} from "./staff/affiche-dmp/affiche-dmp.component";
import {DemandeExamenComponent} from "./staff/demande-examen/demande-examen.component";




const routes: Routes = [
 //{ path: '', redirectTo: 'medecin',pathMatch: 'full' },
  { path: 'staff', component: StaffComponent},
  //medecin links
  { path: 'ordonnance', component: CreerOrdonnanceComponent},
  { path: 'diagnostique', component: CreerDiagnostiqueComponent},
  { path: 'cr', component: CreerCrComponent },
  { path: 'documents', component: AfficheDmpComponent },
  { path: 'examen', component: DemandeExamenComponent},
  // secretaire
  { path: 'creer_dmp', component: CreerDmpComponent },
  { path: 'gestion_materiel', component: GestionMaterielComponent},
  { path: 'gestion_agenda_medecin', component: GestionAgendaMedecinComponent },
  { path: 'affectation_patient_service', component: AffecterPatientComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
