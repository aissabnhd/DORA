package fr.ajaate.dora.services;


import fr.ajaate.dora.entities.Staff;

public interface StaffService{


    Staff findByUsername(String username);

     Staff findByEmail(String email);
    Staff findByID(Long staffID);

    public Staff updateVehicle(Long id, Staff newStaff );
}