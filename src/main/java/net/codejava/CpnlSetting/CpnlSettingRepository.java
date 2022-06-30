package net.codejava.CpnlSetting;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CpnlSettingRepository extends JpaRepository<CpnlSetting, String>{

	
public Page<CpnlSetting> findByNameContains(String mc ,Pageable pegeable);
	
	@Query("SELECT p FROM CpnlSetting p WHERE p.name LIKE :x")	
	public Page<CpnlSetting> chercher
	(@Param("x")String mc,Pageable pegeable);
}
