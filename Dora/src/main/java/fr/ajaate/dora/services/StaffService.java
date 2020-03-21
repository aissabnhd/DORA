package fr.ajaate.dora.services;


import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;

import java.util.List;
import java.util.Optional;

public interface StaffService{

    public Staff save(Staff staff);

    Optional<Staff> findByEmail(String email);
    public Optional<Staff> findByStructResponsible(Struct structResponsible);
    Staff findByID(Long staffID);
    public List<Staff> getAllFromStruct(Struct struct);

    public Staff updateStaff(Long id, Staff newStaff);
    public List<Staff> findByLastName(String lastname);


    Staff findByPhoneNumber(String phoneNumber);

    public void updateStaffResponsible(Staff s, Struct struct);

}
