package net.codejava.RuserProfile;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface RuserProfileRepository extends JpaRepository<RuserProfile, Integer>{
	
public Page<RuserProfile> findBynameContains(String mc ,Pageable pegeable);
	
	@Query("SELECT p FROM RuserProfile p WHERE p.name LIKE :x" )	
	public Page<RuserProfile> chercher
	(@Param("x")String mc,Pageable pegeable);

}
