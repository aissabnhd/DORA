import { Hospitalization } from './Hospitalization';

export interface DMP {
  id: number;
  socialSecurityNumber: string;
  firstName: string;
  lastName: string;
  birthday: any;
  nationality: string;
  phoneNumber: string;
  email: string;
  postcode: number;
  city: string;
  street: string;
  country: string;
  allergy: string;
  hospitalizations: Set<Hospitalization>;

}
