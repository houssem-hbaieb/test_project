import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from '../Models/User';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserDivisionServiceService {

  private apiUrl = 'http://localhost:8034/api/userdivision';

  constructor(private http: HttpClient) {}

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }


  getUsersByDivision(divisionId: number ): Observable<User[]> {
    return this.http.get<User[]>(
      `${this.apiUrl}/users-by-division/${divisionId}`,
      { headers: this.getAuthHeaders() }
    );
  }






}
