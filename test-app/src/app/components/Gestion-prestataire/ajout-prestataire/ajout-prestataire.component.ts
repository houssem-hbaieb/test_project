import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { MatStepperModule } from '@angular/material/stepper';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { PrestatireService } from '../../../services/prestatire.service';
import { MatSelectModule } from '@angular/material/select';
    import { MatIconModule } from '@angular/material/icon';

import { MatFormFieldModule } from '@angular/material/form-field';
import { DossierService } from '../../../services/dossier.service';
import { DebiteurCtx } from '../../../Models/DebiteurCtx';
import { Router } from '@angular/router';


@Component({
  selector: 'app-ajout-prestataire',
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    MatStepperModule,
    MatInputModule,
    MatButtonModule,
    MatFormFieldModule,
    MatSelectModule,
    MatIconModule
  ],
  templateUrl: './ajout-prestataire.component.html',
  styleUrl: './ajout-prestataire.component.scss'
})
export class AjoutPrestataireComponent implements OnInit {
  isLinear = true;
  debiteurs: DebiteurCtx[] = [];
  selectedDebiteur: DebiteurCtx | null = null;

  formGroup1!: FormGroup;
  formGroup2!: FormGroup;
  formGroup3!: FormGroup;
  dossierForm!: FormGroup;

  constructor(
    private fb: FormBuilder,
    private prestataireService: PrestatireService,
    private debiteurService: DossierService ,
     private router: Router
  ) {}

  ngOnInit(): void {
    this.formGroup1 = this.fb.group({
      nomP: ['', Validators.required],
      prenomP: ['', Validators.required],
      emailP: ['', [Validators.required, Validators.email]],
      adresse: ['', Validators.required]
    });

    this.formGroup2 = this.fb.group({
      numcpte: ['', Validators.required],
      agence: ['', Validators.required],
      dateFiscale: ['', Validators.required]
    });

    this.formGroup3 = this.fb.group({
      typeP: ['', Validators.required]
    });

    this.dossierForm = this.fb.group({
      debiteur: [null, Validators.required]
    });

    this.debiteurService.getAll().subscribe(data => {
      this.debiteurs = data;
    });
  }

  onDebiteurSelected(debiteur: DebiteurCtx) {
    this.selectedDebiteur = debiteur;
    console.log("Debiteur sélectionné :", debiteur);
  }

  submit() {
    if (this.formGroup1.valid && this.formGroup2.valid && this.formGroup3.valid && this.dossierForm.valid) {
      const prestataire = {
        ...this.formGroup1.value,
        ...this.formGroup2.value,
        ...this.formGroup3.value,
          numCtx: this.selectedDebiteur?.numCtx,
          codeStructureCtx: this.selectedDebiteur?.codeStructureCtx

      };

      this.prestataireService.create(prestataire).subscribe(res => {
        console.log("✅ Prestataire ajouté :", res);
                this.router.navigate(['menu/listeP']);

      });
    }
  }
}
