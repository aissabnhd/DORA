import {Staff} from "./Staff";
import {Act} from "./Act";

export interface Document {
  id: number;
  type: string;
  extension: string;
  dateCreation: any;
  validation: boolean;
  dateValidation: any;
  path: string;
  act: Act;
  staff: Staff;
}
