import { Struct } from './Struct';
import { Speciality } from './Speciality';
import { Staff } from './Staff';

export enum Level {
  APHP="AP-HP",
  HOSPITAL="HOSPITAL",
  POLE="POLE",
  SERVICE="SERVICE",
  FONCTIONAL_UNIT="FONCTIONAL_UNIT",
  CARE_UNIT="CARE_UNIT"
}

export interface Struct {
  id: number;
  nameStruct: string;
  level: Level;
  postCode: number;
  city: string;
  street: string;
  country: string;
  speciality: Speciality;
  struct: Struct;
  responsible: Staff;
}
