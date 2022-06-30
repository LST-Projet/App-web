package net.codejava.Clistcust;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ClistcustRepository extends JpaRepository<Clistcust, String>{

	
public Page<Clistcust> findByNameContains(String mc ,Pageable pegeable);
	
	@Query("SELECT p FROM Clistcust p WHERE p.name LIKE :x" )	
	public Page<Clistcust> chercher
	(@Param("x")String mc,Pageable pegeable);
}
