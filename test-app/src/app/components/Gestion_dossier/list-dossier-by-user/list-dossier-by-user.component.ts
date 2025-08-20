import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-list-dossier-by-user',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './list-dossier-by-user.component.html',
  styleUrl: './list-dossier-by-user.component.scss'
})
export class ListDossierByUserComponent {

}
