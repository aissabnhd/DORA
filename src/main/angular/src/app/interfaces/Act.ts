import { Affectation } from './Affectation';
import { Staff } from './Staff';

export interface Act{
  id: number;
  type: string;
  date: Date;
  affectation: Affectation;
  staff: Staff;
  done: boolean;
}
