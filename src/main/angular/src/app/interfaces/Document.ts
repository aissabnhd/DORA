import {Staff} from "./Staff";
import {Act} from "./Act";

export enum DocumentNature {
  IMAGE, VIDEO, TEXT


}


export enum DocumentType {

  BILAN,SCANNER,IRM,EXAM, ORDER, CR, DIAGNOSTIC,NOTES,MEASURMENTS

}


export interface Document {
  id: number;
  type: DocumentType;
  nature: DocumentNature;
  extension: string;
  dateCreation: Date;
  validation: boolean;
  dateValidation: Date;
  path: string;
  act: Act;
  staffValidator: Staff;
  staffCreator: Staff;
}
