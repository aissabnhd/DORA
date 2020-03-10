package fr.ajaate.dora.services;


import fr.ajaate.dora.entities.Staff;

import java.util.Optional;

public interface StaffService{

    public Staff save(Staff staff);

    Optional<Staff> findByEmail(String email);

    Staff findByID(Long staffID);

    public Staff updateStaff(Long id, Staff newStaff);
}