export enum RoleName {
   DOCTOR,
   NURSE,
   SECRETARY,
   LABORATORY,
   ADMINISTRATOR
}

export interface Role {
  id: number;
  roleName: RoleName;
}
