package net.codejava.RuserProfile;

import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.codejava.Message;


@Controller
public class RuserProfileController {

	@Autowired
	private RuserProfileRepository repo;
	
	@GetMapping("/RuserProfile")
	public String listRuserProfile(Model model,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="3")int size,
			@RequestParam(name="motCle",defaultValue="")String motCle
			) {
		Page<RuserProfile>PageRuserProfile=repo.findBynameContains(motCle,PageRequest.of(page, size));
		model.addAttribute("PageRuserProfile",PageRuserProfile);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		model.addAttribute("size", size);
		model.addAttribute("pages",new int[PageRuserProfile.getTotalPages()]);
		
		return "RuserProfile";
	}
	
	@GetMapping("RuserProfile/new")
	public String showRuserProfileNewForm(Model model) {
		model.addAttribute("ruserP", new RuserProfile());
		return "NewRuserProfile";
	}
	
	@RequestMapping(value = "RuserProfile/save", method = RequestMethod.POST)
	public String saveRuserProfile(RuserProfile ruserP){
		repo.save(ruserP);
		return "redirect:/RuserProfile";
	}
	
	@RequestMapping("/RuserProfile/edit/{id}")
	public String showEditRuserPage(@PathVariable("id") int id , Model model) {
	    RuserProfile ruserP = repo.findById(id).get();
        model.addAttribute("ruserP", ruserP);
        List<RuserProfile> listRuserProfile = repo.findAll();
	    model.addAttribute("listRuserProfile", listRuserProfile); 
	    return "EditRuserProfile";
	} 
	
	@RequestMapping("/RuserProfile/delete/{id}")
	public String deletercurrency(@PathVariable("id") Integer id , Model model
			,Principal principal,HttpSession session) {
		try {
		repo.deleteById(id);
		session.setAttribute("message", new Message("Supression reussite","succes"));
		}catch(Exception e) {
			System.out.println("ERROR "+e.getMessage());
			e.printStackTrace();
			session.setAttribute("message", new Message("Supression failed, Vous devez supprimer les dependances avant","danger"));
			
		}
		return "redirect:/RuserProfile";       
	}
}
