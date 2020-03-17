import { Hospitalization } from './Hospitalization';
import { Struct } from './Struct';
import { Staff } from './Staff';

export interface Affectation {
  id: number;
  dateAffectation: any;
  dateEndAffectation: any;
  hospitalization: Hospitalization;
  struct: Struct;
  listOfStaffs: Set<Staff>;
}
