import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DivisionServiceService } from '../../../services/division-service.service';
import { Division } from '../../../Models/Division';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { UserServiceService } from '../../../services/user-service.service';
import { User } from '../../../Models/User';
import { UserDivision } from '../../../Models/UserDivision';
import { UserDivisionServiceService } from '../../../services/user-division-service.service';
import { DepartementServiceService } from '../../../services/departement-service.service';
import { Departement } from '../../../Models/Departement';

@Component({
  selector: 'app-liste-division',
  imports: [CommonModule, FormsModule , ReactiveFormsModule],
  templateUrl: './liste-division.component.html',
  styleUrl: './liste-division.component.scss'
})
export class ListeDivisionComponent  implements OnInit{

  departementId!: number;
  divisions: Division[] = [];
  selectedDivision: any = null;
  selectedUserMatricule: number | null = null;
  showAssignModal = false;
  users: User[] = [];
  divisionForm!: FormGroup;
  showAddDivisionModal = false;
  departement: Departement | undefined;
  divisionIdToDelete: number | undefined;
  @ViewChild('deleteModal') deleteModalRef!: ElementRef;




  constructor(
    private route: ActivatedRoute,
    private divisionService: DivisionServiceService,
    private userService : UserServiceService,
    private userDivisionService: UserDivisionServiceService,
    private router: Router ,
    private fb: FormBuilder,
    private departementService: DepartementServiceService
  ) {}

  ngOnInit(): void {
    this.departementId = Number(this.route.snapshot.paramMap.get('departementId'));
    this.loadDivisions();
      this.loadDepartement();

    this.divisionForm = this.fb.group({
      liblle: ['', [Validators.required]],
      codeStructure: ['', [Validators.required]],
    });
  }

   loadDepartement() {
    this.departementService.getDepartementById(this.departementId).subscribe(res => {
      console.log('Département chargé:', res);
      this.departement = res;
    });
  }

  loadDivisions(): void {
    this.divisionService.getDivisionsByDepartementId(this.departementId).subscribe(divisions => {
      this.divisions = divisions;

      this.divisions.forEach(division => {
        this.userDivisionService.getUsersByDivision(division.id ).subscribe(users => {
          division.users = users;
        });
      });
    });
  }

  openAddDivisionModal() {
    this.showAddDivisionModal = true;
  }

  closeAddDivisionModal() {
    this.showAddDivisionModal = false;
    this.divisionForm.reset();
  }

  openAssignModal(division: any) {
  this.selectedDivision = division;
  this.showAssignModal = true;
  this.loadUsers(this.selectedDivision?.id);
}

  loadUsers(divid:number | undefined = this.selectedDivision?.id) {
  this.userService.getUsersNotAssignedToDivision(divid).subscribe((data) => {
    this.users = data;
  });
}

closeAssignModal() {
  this.showAssignModal = false;
  this.selectedDivision = null;
  this.selectedUserMatricule = null;
  this.loadDivisions();
}

assignUser() {
  if (this.selectedDivision && this.selectedUserMatricule != null) {
    this.divisionService
      .assignUserToDivision(this.selectedUserMatricule, this.selectedDivision.id)
      .subscribe({
        next: (userDivision: UserDivision) => {
          console.log('User assigned:', userDivision);
          this.userDivisionService.getUsersByDivision(this.selectedDivision.id).subscribe(users => {
            this.selectedDivision.users = users;
          });
          this.closeAssignModal();
        },
        error: (err) => {
          console.error('Error assigning user:', err);
        }
      });
  }
}


submitDivision() {
    if (this.divisionForm.invalid) return;

    const divisionData = {
      ...this.divisionForm.value,
      departementId: this.departementId
    };

    this.divisionService.addDivision(divisionData).subscribe(() => {
      this.closeAddDivisionModal();
      this.loadDivisions();
    });
  }


  confirmDelete(divid: number | undefined): void {
    this.divisionIdToDelete = divid;
  }

  delete(): void {
  if (this.divisionIdToDelete) {
    const idToDelete = this.divisionIdToDelete;
    this.divisionService.deleteDivision(idToDelete).subscribe({
      next: () => {
        console.log('Département supprimé');
        this.loadDivisions(); // Recharge la liste sans reload page
        this.divisionIdToDelete = 0;
      },
      error: err => {
        console.error('Erreur de suppression', err);
      }
    });
  }

}

cancelDelete(): void {
  this.divisionIdToDelete = 0;
}



}
