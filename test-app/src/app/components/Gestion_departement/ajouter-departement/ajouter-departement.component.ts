import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule, FormsModule } from '@angular/forms';
import { Departement } from '../../../Models/Departement';
import { DepartementServiceService } from '../../../services/departement-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ajouter-departement',
  imports: [CommonModule, FormsModule ,ReactiveFormsModule ],
  templateUrl: './ajouter-departement.component.html',
  styleUrl: './ajouter-departement.component.scss'
})
export class AjouterDepartementComponent implements OnInit {

  departementForm!: FormGroup;


    newDepartement: Departement = {
      nomDepartement: '',
      liblle: '',
      codeStructure: '',
      
    };

  constructor(private departementService: DepartementServiceService ,     private router: Router ,  private fb: FormBuilder,) {}

  ngOnInit(): void {

    this.departementForm = this.fb.group({
      nomDepartement: ['', [Validators.required, Validators.minLength(3) ]],  
      liblle: ['', [Validators.required]],
      codeStructure: ['', [Validators.required, Validators.pattern(/^[A-Z0-9]+$/)]],
    });



  }


  addDepartement(): void {
    if (this.departementForm.invalid) return;

    this.departementService.createDepartement(this.departementForm.value).subscribe({
      next: (res) => {
        console.log('Département ajouté avec succès', res);
        this.router.navigate(['menu/departements']);
      },
      error: (err) => {
        console.error('Erreur lors de l\'ajout du département', err);
      }
    });
  }









//  addDepartement() {
//     this.departementService.createDepartement(this.newDepartement).subscribe({
//       next: (res) => {
//         console.log('Département ajouté avec succès', res);
//         this.newDepartement = {
//           nomDepartement: '',
//           liblle: '',
//           codeStructure: ''
//         };
//       this.router.navigate(['menu/departements']);

//       },
//       error: (err) => {
//         console.error('Erreur lors de l\'ajout du département', err);
//       }
//     });
//   }

}
