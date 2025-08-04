import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { DivisionServiceService } from '../../../services/division-service.service';
import { DepartementServiceService } from '../../../services/departement-service.service';
import { Router } from '@angular/router';
import { Departement } from '../../../Models/Departement';

@Component({
  selector: 'app-ajouter-division',
  imports: [CommonModule, FormsModule ,ReactiveFormsModule],
  templateUrl: './ajouter-division.component.html',
  styleUrl: './ajouter-division.component.scss'
})
export class AjouterDivisionComponent implements OnInit {

  divisionForm!: FormGroup;
  departements: Departement[] = [];



  constructor(private fb: FormBuilder,
    private divisionService: DivisionServiceService,
    private departementService: DepartementServiceService,
    private router: Router) {}



  ngOnInit(): void {

    this.divisionForm = this.fb.group({
      liblle: ['', [Validators.required]],
      codeStructure: ['', [Validators.required]],
      departementId: ['', [Validators.required]]
    });

    this.loadDepartements();
  }


   loadDepartements() {
    this.departementService.getAllDepartements().subscribe({
      next: (data) => this.departements = data,
      error: (err) => console.error('Erreur chargement départements', err)
    });
  }


  
 addDivision() {
  console.log('Formulaire soumis'); // 🔍 Debug
  if (this.divisionForm.invalid) {
    console.warn('Formulaire invalide');
    return;
  }

  

  this.divisionService.addDivision(this.divisionForm.value).subscribe({
    next: () => {
      console.log('Division ajoutée avec succès');
      this.router.navigate(['/menu/departements']);
    },
    error: (err) => console.error('Erreur ajout division', err)
  });
}



}
