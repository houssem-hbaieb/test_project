import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Departement } from '../../../Models/Departement';
import { DepartementServiceService } from '../../../services/departement-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-ajouter-departement',
  imports: [CommonModule, FormsModule ],
  templateUrl: './ajouter-departement.component.html',
  styleUrl: './ajouter-departement.component.scss'
})
export class AjouterDepartementComponent implements OnInit {
    newDepartement: Departement = {
    nomDepartement: '',
    liblle: '',
    codeStructure: ''
  };

  constructor(private departementService: DepartementServiceService ,     private router: Router) {}

  ngOnInit(): void {}

 addDepartement() {
    this.departementService.createDepartement(this.newDepartement).subscribe({
      next: (res) => {
        console.log('Département ajouté avec succès', res);
        this.newDepartement = {
          nomDepartement: '',
          liblle: '',
          codeStructure: ''
        };
      this.router.navigate(['menu/departements']);

      },
      error: (err) => {
        console.error('Erreur lors de l\'ajout du département', err);
      }
    });
  }

}
