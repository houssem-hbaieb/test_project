// src/app/models/departement.model.ts

export interface Departement {
  id?: number;
  nomDepartement: string;
  liblle: string;
  codeStructure: string;

  divisions?: {
    id?: number;
    nomDivision?: string;
  }[];

  dossiers?: {
    id?: number;
    numCtx?: string;
  }[];
}
