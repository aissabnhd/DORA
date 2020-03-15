package fr.ajaate.dora.repository;

import fr.ajaate.dora.entities.Speciality;
import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface StaffRepository extends JpaRepository<Staff,Long> {
    public List<Staff> findAllByStructBelong(Struct struct);

    public Staff findByEmail(String email);
    public List<Staff> findByLastName(String lastname);

    public Optional<Staff> findByStructResponsible(Struct structResponsible);

    Optional<Staff> findByPhoneNumber(String phoneNumber);

}
