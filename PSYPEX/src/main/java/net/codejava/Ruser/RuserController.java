package net.codejava.Ruser;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.codejava.RuserProfile.RuserProfile;
import net.codejava.RuserProfile.RuserProfileRepository;

@Controller
public class RuserController {

	@Autowired
	private RuserProfileRepository repoRuserP;
	
	@Autowired
	private RuserRepository repo;

	
	@GetMapping("/Ruser")
	public String Rusers(Model model,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="3")int size,
			@RequestParam(name="motCle",defaultValue="")String motCle
			){
		Page<Ruser>PageRuser=repo.findByfnameContains(motCle,PageRequest.of(page, size));
		//Page<Ruser> PageRuser = repo.findAll(PageRequest.of(page, size));
		model.addAttribute("PageRuser",PageRuser);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		model.addAttribute("size", size);
		model.addAttribute("pages",new int[PageRuser.getTotalPages()]);

		
		return "Ruser";
	}
	
	@GetMapping("/Ruser/new")
	public String showRuserProfileNewForm(Model model) {
		
		List<RuserProfile> listRuserProfile = repoRuserP.findAll();
		Ruser ruser1 =  new Ruser();
		model.addAttribute("ruser1",ruser1);		
		model.addAttribute("listRuserProfile",listRuserProfile);

		return "NewRuser";
	} 
	
	
	@RequestMapping(value = "/Ruser/save", method = RequestMethod.POST)
	public String saveRuser(Ruser ruser1){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(ruser1.getPassword());
        ruser1.setPassword(encodedPassword);
		repo.save(ruser1);
		return "redirect:/Ruser";
	}
	
	@RequestMapping("/Ruser/edit/{id}")
	public String showEditRuserPage(@PathVariable("id") int id , Model model) {
	    Ruser ruser1 = repo.findById(id).get();
        model.addAttribute("ruser1", ruser1);
        List<RuserProfile> listRuserProfile = repoRuserP.findAll();
	    model.addAttribute("listRuserProfile", listRuserProfile); 
	    return "EditRuser";
	} 
	
	@RequestMapping("/Ruser/delete/{id}")
	public String deletercurrency(@PathVariable("id") Integer id , Model model) {
		repo.deleteById(id);
		return "redirect:/Ruser";       
	}
}
