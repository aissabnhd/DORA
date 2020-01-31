import { Struct } from './Struct';
import { Speciality } from './Speciality';
import { Staff } from './Staff';


export interface Struct {
  id: number;
  nameStruct: string;
  level: number;
  postCode: number;
  city: string;
  street: string;
  country: string;
  speciality: Speciality;
  struct: Struct;
  responsible: Staff;
}
