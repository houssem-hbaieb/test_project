import { CommonModule } from '@angular/common';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { DepartementServiceService } from '../../../services/departement-service.service';
import { Router } from '@angular/router';
import { Departement } from '../../../Models/Departement';

@Component({
  selector: 'app-liste-departemment',
  imports: [CommonModule, FormsModule],
  templateUrl: './liste-departemment.component.html',
  styleUrl: './liste-departemment.component.scss'
})
export class ListeDepartemmentComponent implements OnInit {

    departements: Departement[] = [];
    departementIdToDelete: number | undefined;
    @ViewChild('deleteModal') deleteModalRef!: ElementRef;




constructor(private depService: DepartementServiceService, private router: Router) {}

  ngOnInit(): void {
this.loadDepartements();  }

   loadDepartements() {
    this.depService.getAllDepartements().subscribe({
      next: data => this.departements = data,
      error: err => console.error('Erreur de chargement', err)
    });
  }

   viewDivisions(departementId : number | undefined): void {
    this.router.navigate(['/menu/division', departementId]);
  }

   navigateToEdit(departementId: number | undefined): void {
    this.router.navigate(['/menu/editdepartement', departementId]);
  }

  confirmDelete(depid: number | undefined): void {
    this.departementIdToDelete = depid;
  }


  delete(): void {
  if (this.departementIdToDelete) {
    const idToDelete = this.departementIdToDelete;
    this.depService.deleteDepartement(idToDelete).subscribe({
      next: () => {
        console.log('Département supprimé');
        this.loadDepartements(); // Recharge la liste sans reload page
        this.departementIdToDelete = 0;
      },
      error: err => {
        console.error('Erreur de suppression', err);
      }
    });
  }

}


cancelDelete(): void {
  this.departementIdToDelete = 0;
}










}
