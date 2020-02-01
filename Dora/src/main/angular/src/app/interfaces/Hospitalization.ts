import {DMP} from "./DMP";
import {Struct} from "./Struct";
import {Affectation} from "./Affectation";

export interface Hospitalization {
  id: number;
  dateHospitalization: any;
  dateEndHospitalization: any;
  roomNumber: number;
  dmp: DMP;
  struct: Struct;
  affectations: Set<Affectation>;
}
