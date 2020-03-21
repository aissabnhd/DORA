package fr.ajaate.dora.dao;


import fr.ajaate.dora.entities.Staff;
import fr.ajaate.dora.entities.Struct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

    Optional<Staff> findByemail(String email);

    Boolean existsByEmail(String email);

    List<Staff> findByLastName(String lastname);

    Staff findByPhoneNumber(String phoneNumber);

    public List<Staff> findAllByStructBelong(Struct struct);


    public Optional<Staff> findByStructResponsible(Struct structResponsible);



}
