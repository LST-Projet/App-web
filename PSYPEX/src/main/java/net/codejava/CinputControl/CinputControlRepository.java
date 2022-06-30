package net.codejava.CinputControl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CinputControlRepository extends JpaRepository<CinputControl, Integer>{

	
public Page<CinputControl> findByMenuContains(String mc ,Pageable pegeable);
	
	@Query("SELECT p FROM CinputControl p WHERE p.menu LIKE :x" )	
	public Page<CinputControl> chercher
	(@Param("x")String mc,Pageable pegeable);
}
