import {Role} from "./Role";

export interface Token {
  token : String;
  type : String;
  id : number;
  name : String;
  familyname : String;
  email : String;
  roles : Array<Role>;
}
