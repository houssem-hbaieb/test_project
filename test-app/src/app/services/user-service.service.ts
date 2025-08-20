import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../Models/User';
import { ERole } from '../Models/ERole';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  private baseUrl = 'http://localhost:8034/api/users';

  constructor(private http :HttpClient) { }

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }

  getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.baseUrl, { headers: this.getAuthHeaders() });
  }

  getUserById(id: number): Observable<User> {
    return this.http.get<User>(`${this.baseUrl}/${id}`, { headers: this.getAuthHeaders() });
  }


  getUsersNotAssignedToDivision(divisionId: number): Observable<User[]> {
    return this.http.get<User[]>(
      `${this.baseUrl}/not-assigned/${divisionId}`,
      { headers: this.getAuthHeaders() }
    );
  }

   getAllChargees(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseUrl}/chargees`, { headers: this.getAuthHeaders() });
  }

   getAllUsersExceptAdmin(): Observable<User[]> {
    return this.http.get<User[]>(`${this.baseUrl}/sauf_admin`);
  }

   addRoleToUser(userId: number, role: ERole): Observable<User> {
    return this.http.post<User>(`${this.baseUrl}/${userId}/roles/${role}`, {headers: this.getAuthHeaders()});
  }

  removeRoleFromUser(userId: number, role: ERole): Observable<User> {
    return this.http.delete<User>(`${this.baseUrl}/${userId}/roles/${role}` , {headers: this.getAuthHeaders()});
  }












}
