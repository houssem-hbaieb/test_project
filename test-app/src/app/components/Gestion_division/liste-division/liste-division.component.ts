import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DivisionServiceService } from '../../../services/division-service.service';
import { Division } from '../../../Models/Division';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { UserServiceService } from '../../../services/user-service.service';
import { User } from '../../../Models/User';
import { UserDivision } from '../../../Models/UserDivision';
import { UserDivisionServiceService } from '../../../services/user-division-service.service';

@Component({
  selector: 'app-liste-division',
  imports: [CommonModule, FormsModule],
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

  constructor(
    private route: ActivatedRoute,
    private divisionService: DivisionServiceService,
    private userService : UserServiceService,
    private userDivisionService: UserDivisionServiceService
  ) {}

  ngOnInit(): void {
    this.departementId = Number(this.route.snapshot.paramMap.get('departementId'));
    this.loadDivisions();
  }

  loadDivisions(): void {
    this.divisionService.getAllDivisions().subscribe(divisions => {
      this.divisions = divisions;

      this.divisions.forEach(division => {
        this.userDivisionService.getUsersByDivision(division.id).subscribe(users => {
          division.users = users;
        });
      });
    });
  }


  openAssignModal(division: any) {
  this.selectedDivision = division;
  this.showAssignModal = true;
  this.loadUsers();
}

  loadUsers() {
  this.userService.getAllUsers().subscribe((data) => {
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







}
