import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DebiteurCtx } from '../../../Models/DebiteurCtx';
import { Departement } from '../../../Models/Departement';
import { DossierService } from '../../../services/dossier.service';
import { DepartementServiceService } from '../../../services/departement-service.service';

@Component({
  selector: 'app-get-alldossier',
  imports: [CommonModule , FormsModule ,ReactiveFormsModule],
  templateUrl: './get-alldossier.component.html',
  styleUrl: './get-alldossier.component.scss'
})
export class GetAlldossierComponent implements OnInit {

   dossiers: DebiteurCtx[] = [];
  departements: Departement[] = [];

   showAffecterModal = false;
  selectedDossier: DebiteurCtx | null = null;
  selectedDepartementId: number | null = null;


  constructor(private debiteurService: DossierService, private departementService: DepartementServiceService) {}

  ngOnInit(): void {
    this.loadDossiers() ;
    this.loadDepartements();

  }


  loadDossiers() {
    this.debiteurService.getAll().subscribe(data => this.dossiers = data);
  }

  loadDepartements() {
    this.departementService.getAllDepartements().subscribe(data => this.departements = data);
  }


   openAffecterDepartementModal(dossier: DebiteurCtx) {
    this.selectedDossier = dossier;
    this.showAffecterModal = true;
  }

  closeAffecterModal() {
    this.showAffecterModal = false;
    this.selectedDossier = null;
    this.selectedDepartementId = null;
  }


  affecterDepartement() {
    if (this.selectedDossier && this.selectedDepartementId) {
      this.debiteurService.affecterDepartement(this.selectedDossier.numCtx!, this.selectedDepartementId)
        .subscribe(() => {
          this.loadDossiers();
          this.closeAffecterModal();
        });

         const dep = this.departements.find(d => d.id === this.selectedDepartementId);
      if (dep) {
        this.selectedDossier.departement = dep;
      }
    }
  }


  getDepartementName(id: number): string {
  const d = this.departements.find(dep => dep.id === id);
  return d ? d.nomDepartement : '';
}

getDepartementCodeStructure(id: number): string {
  const d = this.departements.find(dep => dep.id === id);
  return d ? d.codeStructure : '';
}








}
