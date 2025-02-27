package com.CRM.Customer.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.CRM.Customer.Entity.User;

public interface userrepository extends JpaRepository<User, Long> {
	Optional<User> findByUsername(String username);
}