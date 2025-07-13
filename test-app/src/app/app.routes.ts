import { Routes } from '@angular/router';
import { DashboardComponent } from './components/dashboard/dashboard/dashboard.component';
import { LoginComponentComponent } from './components/Authentification/login-component/login-component.component';

export const routes: Routes = [


{ path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponentComponent },
  { path: 'dashboard', component: DashboardComponent }
];
