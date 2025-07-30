import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Division } from '../Models/Division';
import { UserDivision } from '../Models/UserDivision';

@Injectable({
  providedIn: 'root'
})
export class DivisionServiceService {

    private apiUrl = 'http://localhost:8034/api/division';
  constructor(private http:HttpClient) { }

  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }

  addDivision(division: Division): Observable<Division> {
    return this.http.post<Division>(this.apiUrl, division, {
      headers: this.getAuthHeaders()
    });
  }

  getAllDivisions(): Observable<Division[]> {
    return this.http.get<Division[]>(this.apiUrl, {
      headers: this.getAuthHeaders()
    });
  }

  getDivisionById(id: number): Observable<Division> {
    return this.http.get<Division>(`${this.apiUrl}/${id}`, {
      headers: this.getAuthHeaders()
    });
  }

  getDivisionsByDepartementId(departementId: number): Observable<Division[]> {
    return this.http.get<Division[]>(`${this.apiUrl}/by-departement/${departementId}`, {
      headers: this.getAuthHeaders()
    });
  }

  updateDivision(id: number, updatedDivision: Division): Observable<Division> {
    return this.http.put<Division>(`${this.apiUrl}/${id}`, updatedDivision, {
      headers: this.getAuthHeaders()
    });
  }

  deleteDivision(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`, {
      headers: this.getAuthHeaders()
    });
  }

  assignUserToDivision(userMatricule: number, divisionId: number): Observable<UserDivision> {
    const params = new HttpParams()
      .set('userMatricule', userMatricule.toString())
      .set('divisionId', divisionId.toString());

    return this.http.post<UserDivision>(`${this.apiUrl}/assign`, null, {
      headers: this.getAuthHeaders(),
      params: params
    });
  }


  





}
