package net.codejava.Clistcust;

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
public class ClistcustController {

	
	@Autowired
	private ClistcustRepository repo;
	
	@GetMapping("/Clistcust")
	public String listClistcust(Model model,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="3")int size,
			@RequestParam(name="motCle",defaultValue="")String motCle
			){
		Page<Clistcust>PageClistcust=repo.findByNameContains(motCle,PageRequest.of(page, size));
		//Page<Clistcust> PageClistcust = repo.findAll(PageRequest.of(page, size));
		model.addAttribute("PageClistcust",PageClistcust);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		model.addAttribute("size", size);
		model.addAttribute("pages",new int[PageClistcust.getTotalPages()]);
		/*List<Clistcust> listClistcust = repo.findAll();
		model.addAttribute("listClistcust",listClistcust);*/
		
		return "Clistcust";
	}
	
	@GetMapping("/Clistcust/new")
	public String showClistcustNewForm(Model model) {
			model.addAttribute("clistcust", new Clistcust());
			
			return "NewClistcust";
	}
	
	@RequestMapping(value = "Clistcust/save", method = RequestMethod.POST)
	public String saveClistcust(Clistcust clistcust,Principal principal,HttpSession session){
		try {
			repo.save(clistcust);
			session.setAttribute("message", new Message("Paramétrage est bien sauvegardé","succes"));
			return "redirect:/Clistcust";
			}catch(Exception e) {
				System.out.println("ERROR "+e.getMessage());
				e.printStackTrace();
				session.setAttribute("message", new Message("échec de sauvegarde","danger"));
				return "redirect:/Clistcust/new";
			}
		
	}
	
	@RequestMapping("/Clistcust/edit/{id}")
	public String showEditClistcustPage(@PathVariable("id") String id , Model model) {
		Clistcust clistcust = repo.findById(id).get();
        model.addAttribute("clistcust", clistcust);
        List<Clistcust> listClistcust = repo.findAll();
	    model.addAttribute("listClistcust", listClistcust); 
	    return "EditClistcust";
	} 
	
	@RequestMapping("/Clistcust/delete/{id}")
	public String deleteClistcust(@PathVariable("id") String id , Model model
			,Principal principal,HttpSession session) {
		try {
			repo.deleteById(id);
			session.setAttribute("message", new Message("Supression reussite","succes"));
			}catch(Exception e) {
				System.out.println("ERROR "+e.getMessage());
				e.printStackTrace();
				session.setAttribute("message", new Message("Supression failed, Vous devez supprimer les dependances avant","danger"));
				
			}
		return "redirect:/Clistcust";       
	}
}
