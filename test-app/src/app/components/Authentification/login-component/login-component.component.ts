import { Component } from '@angular/core';
import { AuthService } from '../../../services/auth.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-login-component',
  imports: [ [FormsModule, CommonModule]],
  templateUrl: './login-component.component.html',
  styleUrl: './login-component.component.scss'
})
export class LoginComponentComponent {

   email = '';
  password = '';
  errorMessage = '';

    constructor(private authService: AuthService, private router: Router) {}


     login() {
    this.authService.login({ email: this.email, password: this.password }).subscribe({
      next: (res) => {
        localStorage.setItem('token', res.token); 
        this.router.navigate(['/dashboard']); 
      },
      error: err => {
        this.errorMessage = 'Login failed: ' + (err.error?.message || 'Invalid credentials');
      }
    });
  }


}
