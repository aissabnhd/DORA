import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ConnexionComponent } from './connexion/connexion.component';
import { DocumentsComponent } from './medecin/documents/documents.component';
import { DiagnostiqueComponent } from './medecin/diagnostique/diagnostique.component';
import { CrComponent } from './medecin/cr/cr.component';
import { OrdonnanceComponent } from './medecin/ordonnance/ordonnance.component';
import { ExamenComponent } from './medecin/examen/examen.component';
import { MedecinComponent } from './medecin/medecin.component';




const routes: Routes = [
 //{ path: '', redirectTo: 'medecin',pathMatch: 'full' },
  { path: 'medecin', component: MedecinComponent},

    { path: 'documents', component: DocumentsComponent },
    { path: 'diagnostique', component: DiagnostiqueComponent},
    { path: 'cr', component: CrComponent },
    { path: 'ordonnance', component: OrdonnanceComponent},
    { path: 'examen', component: ExamenComponent}


];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
