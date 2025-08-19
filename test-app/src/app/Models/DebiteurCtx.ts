import { Departement } from "./Departement";

export interface DebiteurCtx {
  numCtx?: number;
  codeStructureCtx?: number;

  etatCtx?: string;
  sortCtx?: string;
  motifSortCtx?: string;

  dateTransfertCtx?: string;  
  soldeRecouvrementCtx?: number;

  dateClotureCtx?: string;
  motifClotureCtx?: string;

  dateCreationCtx?: string;
  matriculeCreationCtx?: number;
  dateMajCtx?: string;
  matriculeMajCtx?: number;

  dateDecisionCtx?: string;
  dateReceptionDossier?: string;

  departementId?: number;
  divisionId?: number;
  userId?: number;
  departement?: Departement | null;
}
