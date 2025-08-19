import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DossierService } from '../../../services/dossier.service';
import { DepartementServiceService } from '../../../services/departement-service.service';
import { AuthService } from '../../../services/auth.service';
import { DebiteurCtx } from '../../../Models/DebiteurCtx';
import { Division } from '../../../Models/Division';
import { DivisionServiceService } from '../../../services/division-service.service';

@Component({
  selector: 'app-list-dossier-by-dep',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './list-dossier-by-dep.component.html',
  styleUrl: './list-dossier-by-dep.component.scss',
})
export class ListDossierByDepComponent implements OnInit {
  dossiers: DebiteurCtx[] = [];
  userId: number | null = null;
  departementId: number | undefined;
  divisions: Division[] = [];
  selectedDossier: any = null;
  selectedDivisionId: number | null = null;
  showAffecterModal = false;

  constructor(
    private authService: AuthService,
    private debiteurService: DossierService,
    private departementService: DepartementServiceService,
    private divisionService: DivisionServiceService,

  ) {}

  ngOnInit(): void {
    this.loadDossiersForChef();
        this.loadDivisions();

  }

   loadDivisions(): void {
    this.divisionService.getAllDivisions().subscribe((data) => {
      this.divisions = data;
    });
  }

  loadDossiersForChef(): void {
    this.userId = this.authService.getUserId();
    if (!this.userId) {
      console.error('User non connecté');
      return;
    }

    this.departementService.getDepartementsByUserId(this.userId).subscribe({
      next: (departements) => {
        if (departements && departements.length > 0) {
          this.dossiers = [];
          departements.forEach((dep) => {
            if (dep.id !== undefined) {
              this.debiteurService.getByDepartement(dep.id).subscribe({
                next: (dossiers) => {
                  this.dossiers = [...this.dossiers, ...dossiers];
                },
                error: (err) =>
                  console.error(
                    `Erreur dossiers pour le département ${dep.id} :`,
                    err
                  ),
              });
            } else {
              console.warn('Département sans ID :', dep);
            }
          });
        } else {
          console.warn('Aucun département trouvé pour cet utilisateur');
        }
      },
      error: (err) => console.error('Erreur département :', err),
    });
  }

  openAffecterDivisionModal(dossier: any): void {
    this.selectedDossier = dossier;
    this.showAffecterModal = true;
  }

  closeAffecterModal(): void {
    this.showAffecterModal = false;
    this.selectedDivisionId = null;
    this.selectedDossier = null;
  }

  affecterDivision(): void {
    if (this.selectedDossier && this.selectedDivisionId) {
      this.debiteurService.affecterDivision(
        this.selectedDossier.numCtx!, 
        this.selectedDivisionId
      ).subscribe(() => {
        this.loadDossiersForChef();
        this.closeAffecterModal();
      });
    }
  }
}
