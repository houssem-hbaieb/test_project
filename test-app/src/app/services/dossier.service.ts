import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { DebiteurCtx } from '../Models/DebiteurCtx';

@Injectable({
  providedIn: 'root'
})
export class DossierService {

    private apiUrl = 'http://localhost:8034/api/dossier';


    private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }

  constructor(private http: HttpClient) {}

   getAll(): Observable<any[]> {
    return this.http.get<DebiteurCtx[]>(this.apiUrl, { headers: this.getAuthHeaders() });
  }

  getById(numCtx: number): Observable<any> {
    return this.http.get<DebiteurCtx>(`${this.apiUrl}/${numCtx}`, { headers: this.getAuthHeaders() });
  }

  create(debiteur: DebiteurCtx): Observable<any> {
    return this.http.post<DebiteurCtx>(this.apiUrl, debiteur, { headers: this.getAuthHeaders() });
  }

  update(numCtx: number, dto: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/${numCtx}`, dto, { headers: this.getAuthHeaders() });
  }

  affecterDepartement(numCtx: number, departementId: number): Observable<DebiteurCtx> {
    return this.http.put<DebiteurCtx>(`${this.apiUrl}/${numCtx}/departement/${departementId}`, {}, { headers: this.getAuthHeaders() });
  }

  affecterDivision(numCtx: number, divisionId: number): Observable<DebiteurCtx> {
    return this.http.put<DebiteurCtx>(`${this.apiUrl}/${numCtx}/division/${divisionId}`, {}, { headers: this.getAuthHeaders() });
  }

  affecterUser(numCtx: number, userId: number): Observable<DebiteurCtx> {
    return this.http.put<DebiteurCtx>(`${this.apiUrl}/${numCtx}/user/${userId}`, {}, { headers: this.getAuthHeaders() });
  }

  getByDepartement(departementId: number): Observable<DebiteurCtx[]> {
    return this.http.get<DebiteurCtx[]>(`${this.apiUrl}/departement/${departementId}` , {headers: this.getAuthHeaders()});
  }



}
