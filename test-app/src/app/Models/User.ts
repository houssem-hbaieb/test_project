export interface User {
  id?: number;
  matricule: number;
  email: string;
  password: string;
  code_structure: number;
  nom: string;
  prenom: string;
  roles: string[]; 
}
