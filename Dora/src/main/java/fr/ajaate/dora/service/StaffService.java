package fr.ajaate.dora.service;


import fr.ajaate.dora.entities.Staff;

public interface StaffService{
    void save(Staff staff);

    Staff findByUsername(String username);

   // Staff findByEmail(String email);
}
