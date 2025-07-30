import { Division } from "./Division";
import { User } from "./User";

export interface UserDivision {
  userMatricule: number;
  divisionId: number;
  user?: User;
  division?: Division;
}
