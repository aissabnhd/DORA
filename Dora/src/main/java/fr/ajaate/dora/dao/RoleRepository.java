package fr.ajaate.dora.dao;

import fr.ajaate.dora.entities.Role;
import fr.ajaate.dora.entities.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {


}