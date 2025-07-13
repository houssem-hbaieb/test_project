import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, tap } from 'rxjs';


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

  try {
    const payload = token.split('.')[1];
    const decodedJson = atob(payload);
    const decoded = JSON.parse(decodedJson);
    console.log('Decoded JWT (manual):', decoded);
    if (Array.isArray(decoded.role)) {
      return decoded.role[0];
    }
    return decoded.role;
  } catch {
    return null;
  }
}





}
function jwtDecode(token: string): any {
  throw new Error('Function not implemented.');
}

