import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard/dashboard.component';
import { LoginComponentComponent } from './components/Authentification/login-component/login-component.component';
import { SidebarComponent } from './components/Sidebar/sidebar/sidebar.component';
import { AjouterDepartementComponent } from './components/Gestion_departement/ajouter-departement/ajouter-departement.component';

export const routes: Routes = [


{ path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponentComponent },
   {
    path: 'menu',
    component: SidebarComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'ajouter-dep', component: AjouterDepartementComponent },


    ]
  }
];
