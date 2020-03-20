export enum RoleName {
   DOCTOR="DOCTOR",
   NURSE="NURSE",
   SECRETARY="SECRETARY",
   LABORATORY="LABORATORY",
   ADMINISTRATOR="ADMINISTRATOR"
}

export interface Role {
  id: number;
  name: RoleName;
}
