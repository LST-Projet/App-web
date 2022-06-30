package net.codejava.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM User u WHERE u.uCode = ?1")
    public User findByUCode(String uCode);
	
}
