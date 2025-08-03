import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard/dashboard.component';
import { LoginComponentComponent } from './components/Authentification/login-component/login-component.component';
import { SidebarComponent } from './components/Sidebar/sidebar/sidebar.component';
import { AjouterDepartementComponent } from './components/Gestion_departement/ajouter-departement/ajouter-departement.component';
import { ListeDepartemmentComponent } from './components/Gestion_departement/liste-departemment/liste-departemment.component';
import { ListeDivisionComponent } from './components/Gestion_division/liste-division/liste-division.component';
import { UpdateDepartementComponent } from './components/Gestion_departement/update-departement/update-departement.component';

export const routes: Routes = [


{ path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponentComponent },
   {
    path: 'menu',
    component: SidebarComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'ajouter-dep', component: AjouterDepartementComponent },
      { path: 'departements', component: ListeDepartemmentComponent },
      { path: 'editdepartement/:departementId', component: UpdateDepartementComponent },
      { path: 'division/:departementId', component: ListeDivisionComponent }




    ]
  }
];
