package net.codejava.Clistsys;

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
public class ClistsysController {

	
	@Autowired
	private ClistsysRepository repo;
	
	@GetMapping("/Clistsys")
	public String listClistsys(Model model,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="3")int size,
			@RequestParam(name="motCle",defaultValue="")String motCle
			){
		Page<Clistsys>PageClistsys=repo.findByIdContains(motCle,PageRequest.of(page, size));
		//Page<Clistsys>PageClistsys=repo.findAll(PageRequest.of(page, size));
		model.addAttribute("PageClistsys",PageClistsys);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		model.addAttribute("size", size);
		model.addAttribute("pages",new int[PageClistsys.getTotalPages()]);
		
		
		return "Clistsys";
	}
	
	@GetMapping("/Clistsys/new")
	public String showClistsysNewForm(Model model) {
			model.addAttribute("clistsys", new Clistsys());
		return "NewClistsys";
	}
	
	@RequestMapping(value = "/Clistsys/save", method = RequestMethod.POST)
	public String saveClistsys(Clistsys clistsys,Principal principal,HttpSession session){
		try {
			repo.save(clistsys);
			session.setAttribute("message", new Message("Paramétrage est bien sauvegardé","succes"));
			return "redirect:/Clistsys";
			}catch(Exception e) {
				System.out.println("ERROR "+e.getMessage());
				e.printStackTrace();
				session.setAttribute("message", new Message("échec de sauvegarde","danger"));
				return "redirect:/Clistsys/new";
			}
	}
	
	@RequestMapping("/Clistsys/edit/{id}")
	public String showEditClistsysPage(@PathVariable("id") String id , Model model) {
		Clistsys clistsys = repo.findById(id).get();
        model.addAttribute("clistsys", clistsys);
        List<Clistsys> listClistsys = repo.findAll();
	    model.addAttribute("listClistsys", listClistsys); 
	    return "EditClistsys";
	} 
	
	@RequestMapping("/Clistsys/delete/{id}")
	public String deleteClistsys(@PathVariable("id") String id , Model model
			,Principal principal,HttpSession session) {
		try {
			repo.deleteById(id);
			session.setAttribute("message", new Message("Supression reussite","succes"));
			}catch(Exception e) {
				System.out.println("ERROR "+e.getMessage());
				e.printStackTrace();
				session.setAttribute("message", new Message("Supression failed, Vous devez supprimer les dependances avant","danger"));
				
			}
		
		return "redirect:/Clistsys";       
	}
}
