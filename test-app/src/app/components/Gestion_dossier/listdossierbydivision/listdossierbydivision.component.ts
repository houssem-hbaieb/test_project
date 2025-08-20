import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserServiceService } from '../../../services/user-service.service';
import { User } from '../../../Models/User';
import { DebiteurCtx } from '../../../Models/DebiteurCtx';
import { AuthService } from '../../../services/auth.service';
import { DossierService } from '../../../services/dossier.service';
import { DepartementServiceService } from '../../../services/departement-service.service';
import { DivisionServiceService } from '../../../services/division-service.service';

@Component({
  selector: 'app-listdossierbydivision',
  imports: [CommonModule, FormsModule, ReactiveFormsModule],
  templateUrl: './listdossierbydivision.component.html',
  styleUrl: './listdossierbydivision.component.scss'
})
export class ListdossierbydivisionComponent implements OnInit {


 constructor(
    private authService: AuthService,
    private debiteurService: DossierService,
    private departementService: DepartementServiceService,
    private divisionService: DivisionServiceService,
    private userService: UserServiceService
  ) {}
  dossiers: DebiteurCtx[] = [];
  userId: number | null = null;
  departementMap: { [key: number]: string } = {};
  divisionMap: { [key: number]: string } = {};
  selectedDossier: DebiteurCtx | null = null;
  selectedUserId: number | null = null;
  showAffecterUserModal = false;
  users: any[] = [];

  ngOnInit(): void {
        this.loadDossiersForChefByDivision();
        this.loaduser();

  }

 loadDossiersForChefByDivision(): void {
  this.userId = this.authService.getUserId();
  if (!this.userId) {
    console.error('User non connecté');
    return;
  }

  this.divisionService.getDivisionByUserId(this.userId).subscribe({
    next: (divisions) => {
      if (divisions && divisions.length > 0) {
        this.dossiers = [];

        divisions.forEach((div) => {
          if (div.id !== undefined) {
            this.debiteurService.getByDivision(div.id).subscribe({
              next: (dossiers) => {
                dossiers.forEach((dossier) => {
                  if (dossier.departementId && !this.departementMap[dossier.departementId]) {
                    this.departementService.getDepartementById(dossier.departementId).subscribe(dep => {
                      this.departementMap[dossier.departementId!] = dep.liblle;
                    });
                  }

                  if (dossier.divisionId && !this.divisionMap[dossier.divisionId]) {
                    this.divisionService.getDivisionById(dossier.divisionId).subscribe(divObj => {
                      this.divisionMap[dossier.divisionId!] = divObj.liblle;
                    });
                  }
                });

                this.dossiers = [...this.dossiers, ...dossiers];
              },
              error: (err) => console.error(`Erreur dossiers pour la division ${div.id} :`, err)
            });
          } else {
            console.warn('Division sans ID :', div);
          }
        });

      } else {
        console.warn('Aucune division trouvée pour cet utilisateur');
      }
    },
    error: (err) => console.error('Erreur récupération divisions :', err)
  });
}


  openAffecterUserModal(dossier: DebiteurCtx): void {
    this.selectedDossier = dossier;
    this.showAffecterUserModal = true;

     this.userService.getAllChargees().subscribe(users => this.users = users);
  }

  closeAffecterUserModal(): void {
    this.showAffecterUserModal = false;
    this.selectedUserId = null;
    this.selectedDossier = null;
  }

  affecterUser(): void {
    if (this.selectedDossier && this.selectedUserId) {
      this.debiteurService.affecterUser(this.selectedDossier.numCtx!, this.selectedUserId)
        .subscribe(() => {
          this.loadDossiersForChefByDivision();
          this.closeAffecterUserModal();
        });
    }
  }

  getDepartementName(departementId?: number): string {
    return departementId ? this.departementMap[departementId] || 'Chargement...' : 'Non affecté';
  }

  getDivisionName(divisionId?: number): string {
    return divisionId ? this.divisionMap[divisionId] || 'Chargement...' : 'Non affectée';
  }

  getUserName(userId: number): string {
  const u = this.users.find(user => user.id === userId);
  return u ? `${u.nom} ${u.prenom}` : '';
}

getUserEmail(userId: number): string {
  const u = this.users.find(user => user.id === userId);
  return u ? u.email : '';
}

loaduser()
{
       this.userService.getAllChargees().subscribe(users => this.users = users);

}


//   openAffecterUserModal(dossier: any): void {
//   this.selectedDossier = dossier;
//   this.showAffecterUserModal = true;
//   this.userService.getAllUsers().subscribe((data) => {
//     this.users = data;
//   });
// }


// closeAffecterUserModal(): void {
//   this.showAffecterUserModal = false;
//   this.selectedUserId = null;
//   this.selectedDossier = null;
// }

// affecterUser(): void {
//   if (this.selectedDossier && this.selectedUserId) {
//     this.debiteurService.affecterUser(
//       this.selectedDossier.numCtx!,
//       this.selectedUserId
//     ).subscribe(() => {
//       this.loadDossiersForChef();
//       this.closeAffecterUserModal();
//     });
//   }
}







