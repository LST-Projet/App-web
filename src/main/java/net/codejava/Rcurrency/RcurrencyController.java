package net.codejava.Rcurrency;

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
public class RcurrencyController {


	
	@Autowired
	private RcurrencyRepository repo;
	@GetMapping("/Rcurrency")
	public String listRcurrency(Model model,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="3")int size,
			@RequestParam(name="motCle",defaultValue="")String motCle
			){
		Page<Rcurrency>PageRcurrency=repo.findByIdContains(motCle,PageRequest.of(page, size));
		//Page<Rcurrency> PageRcurrency = repo.findAll(PageRequest.of(page, size));
		model.addAttribute("PageRcurrency",PageRcurrency);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		model.addAttribute("size", size);
		model.addAttribute("pages",new int[PageRcurrency.getTotalPages()]);
		
		return "Rcurrency";
	}
	
	@GetMapping(value="/Rcurrency/new")
	public String showRcurrencyNewForm(Model model) {
			model.addAttribute("rcurrency1", new Rcurrency());

			return "NewRcurrency";
	}
	
	@RequestMapping(value = "/Rcurrency/save", method = RequestMethod.POST)
	public String saveRcurrency(Rcurrency rcurrency,Principal principal,HttpSession session){
		try {
			repo.save(rcurrency);
			session.setAttribute("message", new Message("Devise est bien sauvegardée","succes"));
			
			return "redirect:/Rcurrency";
			}catch(Exception e) {
				System.out.println("ERROR "+e.getMessage());
				e.printStackTrace();
				session.setAttribute("message", new Message("échec de sauvegarde","danger"));
			
			return "redirect:/Rcurrency/new";
			}
		
	}
	
	/*@RequestMapping("/edit/{id}")
	public ModelAndView showEditRcurrencyPage(@PathVariable(name = "id") String id) {
	    ModelAndView mav = new ModelAndView("EditRcurrency");
	    Rcurrency rcurrency1 = service.get(id);
	    mav.addObject("rcurrency1", rcurrency1);
	     
	    return mav;
	}*/
	
	@RequestMapping("/Rcurrency/edit/{id}")
	public String showEditRcurrencyPage(@PathVariable("id") String id , Model model) {
		Rcurrency rcurrency1 = repo.findById(id).get();
        model.addAttribute("rcurrency1", rcurrency1);
        List<Rcurrency> listRcurrency = repo.findAll();
	    model.addAttribute("listRcurrency", listRcurrency); 
	    return "EditRcurrency";
	} 
	
	@RequestMapping("/Rcurrency/delete/{id}")
	public String deleteRcurrency(@PathVariable("id") String id , Model model
			,Principal principal,HttpSession session) {
		try {
			repo.deleteById(id);
			session.setAttribute("message", new Message("Supression reussite","succes"));
			}catch(Exception e) {
				System.out.println("ERROR "+e.getMessage());
				e.printStackTrace();
				session.setAttribute("message", new Message("Supression failed, Vous devez supprimer les dependances avant","danger"));
				
			}
		
		return "redirect:/Rcurrency";       
	}
}
