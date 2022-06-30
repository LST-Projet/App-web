package net.codejava.ccurve;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CcurveRepository extends JpaRepository<Ccurve, String>{

	
public Page<Ccurve> findByNameContains(String mc ,Pageable pegeable);
	
	@Query("SELECT p FROM Ccurve p WHERE p.name LIKE :z" )	
	public Page<Ccurve> chercher
	(@Param("z")String mc,Pageable pegeable);
	

}
