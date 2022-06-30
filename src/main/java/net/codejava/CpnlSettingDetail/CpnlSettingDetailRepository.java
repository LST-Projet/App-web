package net.codejava.CpnlSettingDetail;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CpnlSettingDetailRepository extends JpaRepository<CpnlSettingDetail, Integer>{

	
public Page<CpnlSettingDetail> findBypnlSettingIdContains(String mc ,Pageable pegeable);
	
	@Query("SELECT p FROM CpnlSettingDetail p WHERE p.pnlSetting.id LIKE :x ")	
	public Page<CpnlSettingDetail> chercher
	(@Param("x")String mc,Pageable pegeable);
}
