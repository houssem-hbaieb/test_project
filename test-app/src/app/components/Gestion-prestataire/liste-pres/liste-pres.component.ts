import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PrestataireDTO } from '../../../Models/Prestataire';
import { PrestatireService } from '../../../services/prestatire.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-liste-pres',
  imports: [CommonModule , FormsModule ,ReactiveFormsModule],
  templateUrl: './liste-pres.component.html',
  styleUrl: './liste-pres.component.scss'
})
export class ListePresComponent implements OnInit{

   prestataires: PrestataireDTO[] = [];
  isLoading = false;
  errorMessage = '';
    divisionIdToDelete: number | undefined;


    constructor(private prestataireService: PrestatireService , private router: Router ) {}

  ngOnInit(): void {

        this.fetchPrestataires();

  }

   fetchPrestataires(): void {
    this.isLoading = true;
    this.prestataireService.getAll().subscribe({
      next: (data) => {
        this.prestataires = data;
        this.isLoading = false;
      },
      error: (err) => {
        console.error(err);
        this.errorMessage = 'Erreur lors du chargement des prestataires.';
        this.isLoading = false;
      }
    });
  }


  confirmDelete(divid: number | undefined): void {
    this.divisionIdToDelete = divid;
  }

  delete(): void {
  if (this.divisionIdToDelete) {
    const idToDelete = this.divisionIdToDelete;
    this.prestataireService.delete(idToDelete).subscribe({
      next: () => {
        console.log('Département supprimé');
        this.fetchPrestataires(); // Recharge la liste sans reload page
        this.divisionIdToDelete = 0;
      },
      error: err => {
        console.error('Erreur de suppression', err);
      }
    });
  }

}

cancelDelete(): void {
  this.divisionIdToDelete = 0;
}


}
