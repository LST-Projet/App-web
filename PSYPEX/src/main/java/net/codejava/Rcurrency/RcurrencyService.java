package net.codejava.Rcurrency;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RcurrencyService {

	@Autowired
	private RcurrencyRepository repo ;
	
	public List<Rcurrency> listAll(){
		return repo.findAll();
	}
	
	public void save(Rcurrency R) {
		repo.save(R);
	}
	
	public Rcurrency get(String id) {
		return repo.getById(id);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
}
