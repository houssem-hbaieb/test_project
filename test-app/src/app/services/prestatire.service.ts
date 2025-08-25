import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PrestataireDTO } from '../Models/Prestataire';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PrestatireService {


  private apiUrl = 'http://localhost:8034/api/prestataires';
  constructor(private http:HttpClient) { }


  private getAuthHeaders(): HttpHeaders {
    const token = localStorage.getItem('token');
    return new HttpHeaders({
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    });
  }


  create(prestataire: PrestataireDTO): Observable<PrestataireDTO> {
    return this.http.post<PrestataireDTO>(this.apiUrl, prestataire , {
      headers: this.getAuthHeaders()});
  }

  findById(id: number): Observable<PrestataireDTO> {
    return this.http.get<PrestataireDTO>(`${this.apiUrl}/${id}` , {
      headers: this.getAuthHeaders()});;
  }

  findByDebiteur(debiteurId: number): Observable<PrestataireDTO[]> {
    return this.http.get<PrestataireDTO[]>(`${this.apiUrl}/debiteur/${debiteurId}` , {
      headers: this.getAuthHeaders()});
  }

  getAll(): Observable<PrestataireDTO[]> {
    return this.http.get<PrestataireDTO[]>(this.apiUrl , {
      headers: this.getAuthHeaders()});
  }

  update(id: number, prestataire: PrestataireDTO): Observable<PrestataireDTO> {
    return this.http.put<PrestataireDTO>(`${this.apiUrl}/${id}`, prestataire , {
      headers: this.getAuthHeaders()});
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}` , {
      headers: this.getAuthHeaders()});
  }

}
