package fr.ajaate.dora.service;

import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.entities.Staff;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface StaffService {
    public Staff createStaff(Staff staff);

    public Staff update(Staff staff);

    public List<Staff> findAll();

    Optional<Staff> findById(Long id);

    void deleteById(Long id);

    public Set<Staff> findAllByLastName(String lastName);

    public Set<Staff> findAllByFirsName(String firstName);

    public Optional<Staff> findByEmail(String email);

    public Optional<Staff> findByPhoneNumber(String phoneNumber);

    public Set<Staff> findAllByStructBelongId(Long structBelongId);

    public Set<Staff> findAllByStaffSpeciality(Speciality speciality);



}
