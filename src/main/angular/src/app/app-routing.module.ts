import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
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
import {ModificationSpecialiteComponent} from "./staff/modification-specialite/modification-specialite.component";
import {AffectationPersonnelComponent} from "./staff/affectation-personnel/affectation-personnel.component";
import {GestionAphpComponent} from "./staff/gestion-aphp/gestion-aphp.component";
import {AjoutMembreComponent} from "./staff/ajout-membre/ajout-membre.component";
import {VoirAnciensExamensComponent} from "./staff/voir-anciens-examens/voir-anciens-examens.component";
import {VoirDemandeExamenComponent} from "./staff/voir-demande-examen/voir-demande-examen.component";
import {PrescriptionsComponent} from "./staff/prescriptions/prescriptions.component";
import {RemarquesComponent} from "./staff/remarques/remarques.component";
import {ConstantesComponent} from "./staff/constantes/constantes.component";
import {PosologieComponent} from "./staff/posologie/posologie.component";
import {AgendaComponent} from "./agenda/agenda.component";
import {AjaateComponent} from "./ajaate/ajaate.component";
import {HelpComponent} from "./help/help.component";
import {ChangeDmpComponent} from "./staff/change-dmp/change-dmp.component";
import {AppComponent} from "./app.component";
import {CreateAffectationComponent} from "./staff/affecter-patient/create-affectation/create-affectation.component";
import {CreateHospitalizationComponent} from "./staff/affecter-patient/create-hospitalization/create-hospitalization.component";
import {CreerDemandeComponent} from "./staff/demande-examen/creer-demande/creer-demande.component";
import {EffectuerExamenComponent} from "./staff/demande-examen/effectuer-examen/effectuer-examen.component";
import {GestionProfilComponent} from "./staff/gestion-profil/gestion-profil.component";
import {MailOublieComponent} from "./mail-oublie/mail-oublie.component";
import {DeconnexionComponent} from "./deconnexion/deconnexion.component";



const routes: Routes = [
 //{ path: '', redirectTo: 'medecin',pathMatch: 'full' },
  {path : 'changeDMP/:id', component: StaffComponent},
  { path: 'staff', component: StaffComponent},
  { path: 'agenda/:idStaff', component: AgendaComponent},
  { path: 'ajaate', component: AjaateComponent},
  { path: 'help', component: HelpComponent},
  { path: 'profil/:idStaff', component: GestionProfilComponent},
  { path: 'mail_oublie', component: MailOublieComponent},
  { path: 'deconnexion', component: DeconnexionComponent},
  // medecin links
  { path: 'ordonnance/:idDMP/:idStaff', component: CreerOrdonnanceComponent},
  { path: 'diagnostique/:idDMP/:idStaff', component: CreerDiagnostiqueComponent},
  { path: 'cr/:idDMP/:idStaff', component: CreerCrComponent },
  { path: 'documents', component: AfficheDmpComponent },
  { path: 'examen/:idDMP/:idStaff', component: DemandeExamenComponent},
  { path: 'examen/demande/:idDMP/:idStaff', component: CreerDemandeComponent},
  { path: 'examen/effectuer/:idDMP/:idStaff', component: EffectuerExamenComponent},

  { path: 'change_dmp', component: ChangeDmpComponent},
  // secretaire links
  { path: 'creer_dmp', component: CreerDmpComponent },
  { path: 'gestion_materiel', component: GestionMaterielComponent},
  { path: 'gestion_agenda_medecin', component: GestionAgendaMedecinComponent },
  { path: 'affectation_patient_service/:idDMP', component: AffecterPatientComponent},
  { path: 'creer_affectation/:idDMP', component: CreateAffectationComponent},
  { path: 'creer_hospitalization/:idDMP', component: CreateHospitalizationComponent},

  // admin links
  { path: 'ajout_membre', component: AjoutMembreComponent },
  { path: 'gestion_aphp', component: GestionAphpComponent},
  { path: 'affectation_personnel', component: AffectationPersonnelComponent },
  { path: 'modification_specialite', component: ModificationSpecialiteComponent},
  // laborantin links
  { path: 'voir_anciens_examens', component: VoirAnciensExamensComponent },
  { path: 'voir_demande_examen/:idDMP/:idStaff', component: EffectuerExamenComponent},
  // infirmier links
  { path: 'posologie/:idDMP/:idStaff', component: PosologieComponent },
  { path: 'constantes', component: ConstantesComponent},
  { path: 'remarques/:idDMP/:idStaff', component: RemarquesComponent },
  { path: 'prescriptions', component: PrescriptionsComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
