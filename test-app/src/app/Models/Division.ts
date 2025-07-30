import { User } from "./User";

export interface Division {
  id: number;
  liblle: string;
  codeStructure: string;
  departementId: number;
  users?: User[];
}
