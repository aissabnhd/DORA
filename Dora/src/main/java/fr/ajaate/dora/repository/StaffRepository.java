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
    boolean existsByPhoneNumber(String phoneNumber);

    public Set<Staff> findAllByLastName(String lastName);

    public Set<Staff> findAllByFirsName(String firstName);

    public Optional<Staff> findByEmail(String email);

    public Optional<Staff> findByPhoneNumber(String phoneNumber);

    public Set<Staff> findAllByStructBelongId(Long structBelongId);

    public Set<Staff> findAllBySpecialitiesIsContaining(Speciality speciality);

    public Optional<Staff> findByStructResponsible(Struct structResponsible);

}
