package net.codejava.Clistsys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ClistsysRepository extends JpaRepository<Clistsys, String>{

	
public Page<Clistsys>findByIdContains(String mc ,Pageable pegeable);
	
	@Query("SELECT p FROM Clistsys p WHERE p.id LIKE :x")	
	public Page<Clistsys> chercher
	(@Param("x")String mc,Pageable pegeable);
}
