package fr.ajaate.dora.repository;


import fr.ajaate.dora.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository {
    User findByUsername(String username);
}