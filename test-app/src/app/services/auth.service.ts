import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';
import { jwtDecode } from 'jwt-decode'; // ✅ This works in modern versions



@Injectable({
  providedIn: 'root'
})
export class AuthService {

    private apiUrl = 'http://localhost:8034/api/v1/auth';

  constructor(private http: HttpClient) {}

   login(credentials: { email: string, password: string }): Observable<any> {
    return this.http.post(`${this.apiUrl}/authenticate`, credentials).pipe(
      tap((response: any) => {
        localStorage.setItem('token', response.token);
      })
    );
  }

  logout(): void {
    localStorage.removeItem('token');
  }

  getToken(): string | null {
    return localStorage.getItem('token');
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('token');
  }


   register(user: {
    firstname: string,
    lastname: string,
    email: string,
    password: string,
    role: Set<string> | string[]
  }): Observable<any> {
    return this.http.post(`${this.apiUrl}/register`, user);
  }


 getUserRole(): string | null {
  const token = this.getToken();
  if (!token) return null;

  const decoded: any = jwtDecode(token);
  console.log('Decoded JWT:', decoded);

  return Array.isArray(decoded.role) ? decoded.role[0] : decoded.role;
}

getUserFullName(): string {
  const token = this.getToken();
  if (!token) return '';

  const decoded: any = jwtDecode(token);
  return `${decoded.prenom} ${decoded.nom}`;
}



}






