import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DebiteurCtx } from '../../../Models/DebiteurCtx';
import { Division } from '../../../Models/Division';
import { AuthService } from '../../../services/auth.service';
import { DossierService } from '../../../services/dossier.service';
import { DepartementServiceService } from '../../../services/departement-service.service';
import { DivisionServiceService } from '../../../services/division-service.service';

@Component({
  selector: 'app-list-dossier-by-user',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './list-dossier-by-user.component.html',
  styleUrl: './list-dossier-by-user.component.scss'
})
export class ListDossierByUserComponent implements OnInit {

   dossiers: DebiteurCtx[] = [];
    userId: number | null = null;
    departementId: number | undefined;
    divisions: Division[] = [];
  departementMap: { [key: number]: string } = {};
  divisionMap: { [key: number]: string } = {};
   showDetailsModal = false;
  selectedDossier: DebiteurCtx | null = null;



    constructor(private authService: AuthService,
        private debiteurService: DossierService,
        private departementService: DepartementServiceService,
        private divisionService: DivisionServiceService,){}


  ngOnInit(): void {

        this.loadDossiersForUser();

  }


    loadDossiersForUser(): void {
    this.userId = this.authService.getUserId();
    if (!this.userId) {
      console.error("User non connecté");
      return;
    }

     this.debiteurService.getDebiteursByUserId(this.userId).subscribe({
              next: (dossiers) => {
                dossiers.forEach((dossier) => {
                  if (dossier.departementId && !this.departementMap[dossier.departementId]) {
                    this.departementService.getDepartementById(dossier.departementId).subscribe(dep => {
                      this.departementMap[dossier.departementId!] = dep.liblle;
                    });
                  }

                  if (dossier.divisionId && !this.divisionMap[dossier.divisionId]) {
                    this.divisionService.getDivisionById(dossier.divisionId).subscribe(divObj => {
                      this.divisionMap[dossier.divisionId!] = divObj.liblle;
                    });
                  }
                });

                this.dossiers = [...this.dossiers, ...dossiers];
              },
              error: (err) => console.error(`Erreur dossiers pour la division  :`, err)
            });
  }


  getDepartementName(departementId?: number): string {
    return departementId ? this.departementMap[departementId] || 'Chargement...' : 'Non affecté';
  }

  getDivisionName(divisionId?: number): string {
    return divisionId ? this.divisionMap[divisionId] || 'Chargement...' : 'Non affectée';
  }

  voirDetails(dossier: DebiteurCtx): void {
    this.selectedDossier = dossier;
    this.showDetailsModal = true;
  }


  closeDetailsModal(): void {
    this.showDetailsModal = false;
    this.selectedDossier = null;
  }

}
