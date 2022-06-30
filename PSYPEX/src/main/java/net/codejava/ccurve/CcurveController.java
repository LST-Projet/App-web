package net.codejava.ccurve;

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
import net.codejava.Clistsys.Clistsys;
import net.codejava.Clistsys.ClistsysRepository;
import net.codejava.Rcurrency.Rcurrency;
import net.codejava.Rcurrency.RcurrencyRepository;

@Controller
public class CcurveController {

	
	@Autowired
	private ClistsysRepository repoClistsys;

	@Autowired
	private RcurrencyRepository repoRcurrency;
	
		
	@Autowired
	private CcurveRepository repo;
	
	
	
	@GetMapping("/Ccurve")
	public String listCcurve(Model model,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="3")int size,
			@RequestParam(name="motCle",defaultValue="")String motCle
			){
		Page<Ccurve>PageCcurve=repo.findByNameContains(motCle,PageRequest.of(page, size));
		//Page<Ccurve> PageCcurve = repo.findAll(PageRequest.of(page, size));
		model.addAttribute("PageCcurve",PageCcurve);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		model.addAttribute("size", size);
		model.addAttribute("pages",new int[PageCcurve.getTotalPages()]);
		
		return "Ccurve";
	}
	
	@GetMapping("/Ccurve/new")
	public String showCcurveNewForm(Model model) {

		    List<Ccurve> listCcurve = repo.findAll();
			Ccurve ccurve =  new Ccurve();
			List<Clistsys> listClistsys = repoClistsys.findAll();
			List<Rcurrency> listRcurrency = repoRcurrency.findAll();
			model.addAttribute("ccurve",ccurve);		
			model.addAttribute("listCcurve",listCcurve);		
			model.addAttribute("listClistsys",listClistsys);
			model.addAttribute("listRcurrency",listRcurrency);			
		
		return "NewCcurve";
	} 
	
	
	@RequestMapping(value = "/Ccurve/save", method = RequestMethod.POST)
	public String saveCcurve(Ccurve ccurve,Principal principal,HttpSession session){
		try {
			repo.save(ccurve);
			session.setAttribute("message", new Message("Paramétrage est bien sauvegardé","succes"));
			return "redirect:/Ccurve";
			}catch(Exception e) {
				System.out.println("ERROR "+e.getMessage());
				e.printStackTrace();
				session.setAttribute("message", new Message("échec de sauvegarde","danger"));
				return "redirect:/Ccurve/new";
				
			}
		
		
	}
	
	@RequestMapping("/Ccurve/edit/{id}")
	public String showEditCcurvePage(@PathVariable("id") String id , Model model) {
		Ccurve ccurve = repo.findById(id).get();
		List<Ccurve> listCcurve = repo.findAll();
        model.addAttribute("ccurve", ccurve);
		model.addAttribute("listCcurve",listCcurve);		
        List<Clistsys> listClistsys = repoClistsys.findAll();
	    model.addAttribute("listClistsys", listClistsys); 
        List<Rcurrency> listRcurrency = repoRcurrency.findAll();
	    model.addAttribute("listRcurrency", listRcurrency); 
	    return "EditCcurve";
	} 
	
	@RequestMapping("/Ccurve/delete/{id}")
	public String deleteCcurve(@PathVariable("id") String id , Model model
			,Principal principal,HttpSession session) {
		try {
			repo.deleteById(id);
			session.setAttribute("message", new Message("Supression reussite","succes"));
			}catch(Exception e) {
				System.out.println("ERROR "+e.getMessage());
				e.printStackTrace();
				session.setAttribute("message", new Message("Supression failed, Vous devez supprimer les dependances avant","danger"));
				
			}
		
		return "redirect:/Ccurve";
}
}
