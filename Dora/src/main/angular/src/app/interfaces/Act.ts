import { Affectation } from './Affectation';
import { Staff } from './Staff';

export interface Act{
  id: number;
  type: string;
  date: any;
  affectation: Affectation;
  staff: Staff;
}
