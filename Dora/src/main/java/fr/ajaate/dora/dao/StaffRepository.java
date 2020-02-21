package fr.ajaate.dora.dao;


import fr.ajaate.dora.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StaffRepository extends JpaRepository<Staff, Long> {

   // Staff findByusername(String username);
    Staff findByemail(String email);

    Optional<Staff> findByUsername(String username);
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}