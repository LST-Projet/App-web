package net.codejava.Rcurrency;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface RcurrencyRepository extends JpaRepository<Rcurrency, String>{

public Page<Rcurrency> findByIdContains(String mc ,Pageable pegeable);
	
	@Query("SELECT p FROM Rcurrency p WHERE p.id LIKE :y OR p.name LIKE :y" )	
	public Page<Rcurrency> chercher
	(@Param("y")String mc,Pageable pegeable);
}
