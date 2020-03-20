import { Struct } from './Struct';
import { Speciality } from './Speciality';
import { Role } from './Role';


export interface Staff {
  id: number;
  firstName: string;
  lastName: string;
  birthday: Date;
  nationality: string;
  phoneNumber: string;
  email: string;
  rib: string;
  postcode: number;
  city: string;
  street: string;
  country: string;
  password: string;
  linkCalendar: string;
  roles: Set<Role>;
  structBelong: Struct;
  structResponsible: Struct;
  specialities: Set<Speciality>;
}
