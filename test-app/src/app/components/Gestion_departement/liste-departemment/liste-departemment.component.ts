import { CommonModule } from '@angular/common';
import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { DepartementServiceService } from '../../../services/departement-service.service';
import { Router } from '@angular/router';
import { Departement } from '../../../Models/Departement';

@Component({
  selector: 'app-liste-departemment',
  imports: [CommonModule, FormsModule , ReactiveFormsModule],
  templateUrl: './liste-departemment.component.html',
  styleUrl: './liste-departemment.component.scss'
})
export class ListeDepartemmentComponent implements OnInit {

    departements: Departement[] = [];
    departementIdToDelete: number | undefined;
    @ViewChild('deleteModal') deleteModalRef!: ElementRef;
    showAddModal: boolean = false;
     departementForm!: FormGroup;
    newDepartement: Departement = {
    nomDepartement: '',
    liblle: '',
    codeStructure: ''
  };

    searchKeyword: string = '';



constructor(private depService: DepartementServiceService, private router: Router ,  private fb: FormBuilder) {}

  ngOnInit(): void {
this.loadDepartements();

this.departementForm = this.fb.group({
      nomDepartement: ['', [Validators.required, Validators.minLength(3) ]],
      liblle: ['', [Validators.required]],
      codeStructure: ['', [Validators.required, Validators.pattern(/^[A-Z0-9]+$/)]],
    });

}

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
        this.loadDepartements();
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


openAddModal() {
  this.showAddModal = true;
  this.departementForm.reset();
}

closeAddModal() {
  this.showAddModal = false;
  this.newDepartement = { nomDepartement: '', liblle: '', codeStructure: '' };
}


 addDepartement(): void {
    if (this.departementForm.invalid) return;

    this.depService.createDepartement(this.departementForm.value).subscribe({
      next: (res) => {
       this.loadDepartements();
       this.closeAddModal();
      },
      error: (err) => {
        console.error('Erreur lors de l\'ajout du département', err);
      }
    });
  }


  search(){
    if(this.searchKeyword.trim() === '') {
      this.loadDepartements();
      return;
    }

    else{

      this.depService.searchDepartements(this.searchKeyword).subscribe({
        next: (data) => {
          this.departements = data;
        },
        error: (err) => {
          console.error('Erreur de recherche', err);
        }
      });
    }


  }










}
