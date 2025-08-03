import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { DepartementServiceService } from '../../../services/departement-service.service';
import { Departement } from '../../../Models/Departement';

@Component({
  selector: 'app-update-departement',
  imports: [CommonModule, FormsModule ,ReactiveFormsModule],
  templateUrl: './update-departement.component.html',
  styleUrl: './update-departement.component.scss'
})
export class UpdateDepartementComponent implements OnInit {

  departementForm!: FormGroup;
  departementId!: number;


  constructor(private depService: DepartementServiceService,private router: Router,private fb: FormBuilder,private route: ActivatedRoute) {}

  ngOnInit(): void {

   this.route.paramMap.subscribe(params => {
    const idParam = params.get('departementId');
    console.log('Route param id:', idParam);
    this.departementId = idParam ? +idParam : 0;

    if (this.departementId) {
      this.buildForm();
      this.loadDepartement();
    } else {
      console.warn('Invalid departement ID');
    }
  });
      this.buildForm();
    this.loadDepartement();

  }

    buildForm(): void {
    this.departementForm = this.fb.group({
      nomDepartement: ['', [Validators.required , Validators.pattern(/^[a-zA-Z]+$/)]],
      liblle: ['', [Validators.required]],
      codeStructure: ['', [Validators.required, Validators.pattern(/^[A-Z0-9]+$/)]],
    });
  }


  loadDepartement(): void {
    this.depService.getDepartementById(this.departementId).subscribe({
      next: (departement: Departement) => {
        this.departementForm.patchValue({
          nomDepartement: departement.nomDepartement,
          liblle: departement.liblle,
          codeStructure: departement.codeStructure
        });
      },
      error: err => console.error('Erreur chargement département', err)
    });
  }

   onSubmit(): void {
    if (this.departementForm.invalid) {
      this.departementForm.markAllAsTouched();
      return;
    }

    const updatedDep: Departement = {
      ...this.departementForm.value
    };

    this.depService.updateDepartement(this.departementId, updatedDep).subscribe({
      next: () => {
        console.log('Département mis à jour');
        this.router.navigate(['menu/departements']);
      },
      error: err => console.error('Erreur modification', err)
    });
  }






}
