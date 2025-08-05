import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Departement } from '../Models/Departement';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DepartementServiceService {

    private apiUrl = 'http://localhost:8034/api/departements';
  constructor(private http:HttpClient) { }


   private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }

  createDepartement(departement: Departement): Observable<Departement> {
    return this.http.post<Departement>(`${this.apiUrl}`, departement , {
      headers: this.getAuthHeaders()});
  }

  getAllDepartements(): Observable<Departement[]> {
    return this.http.get<Departement[]>(`${this.apiUrl}`,{
      headers: this.getAuthHeaders()});
  }

  getDepartementById(id: number): Observable<Departement> {
    return this.http.get<Departement>(`${this.apiUrl}/${id}` , {
      headers: this.getAuthHeaders()});
  }

  updateDepartement(id: number, updated: Departement): Observable<Departement> {
    return this.http.put<Departement>(`${this.apiUrl}/${id}`, updated , {
      headers: this.getAuthHeaders()});
  }

  deleteDepartement(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}` , {
      headers: this.getAuthHeaders()});
  }


  searchDepartements(keyword: string): Observable<Departement[]> {
    const params = new HttpParams().set('keyword', keyword);
    return this.http.get<Departement[]>(`${this.apiUrl}/search`, {headers: this.getAuthHeaders(), params , } ,);
  }


}
