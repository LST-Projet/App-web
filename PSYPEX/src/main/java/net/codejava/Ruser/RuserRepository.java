package net.codejava.Ruser;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RuserRepository extends JpaRepository<Ruser, Integer>{
	
	public Page<Ruser> findByfnameContains(String mc ,Pageable pegeable);
	
	@Query("SELECT p FROM Ruser p WHERE p.fname LIKE :x OR p.lname LIKE :x OR p.uCode LIKE :x OR p.function LIKE :x" )	
	public Page<Ruser> chercher
	(@Param("x")String mc,Pageable pegeable);
}
