package net.codejava.CpnlSetting;

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
public class CpnlSettingController {

	
	@Autowired
	private CpnlSettingRepository repo;
	
	@GetMapping("/CpnlSetting")
	public String listCpnlSetting(Model model,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="3")int size,
			@RequestParam(name="motCle",defaultValue="")String motCle
			){
		Page<CpnlSetting>PageCpnlSetting=repo.findByNameContains(motCle,PageRequest.of(page, size));
		model.addAttribute("PageCpnlSetting",PageCpnlSetting);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		model.addAttribute("size", size);
		model.addAttribute("pages",new int[PageCpnlSetting.getTotalPages()]);				
		
		return "CpnlSetting";
	}
	
	@GetMapping("CpnlSetting/new")
	public String showCpnlSettingNewForm(Model model) {
			model.addAttribute("cpnlSetting", new CpnlSetting());
		
		return "NewCpnlSetting";
	}
	
	@RequestMapping(value = "CpnlSetting/save", method = RequestMethod.POST)
	public String saveCpnlSetting(CpnlSetting cpnlSetting,Principal principal,HttpSession session){
	
	try {
		repo.save(cpnlSetting);
		session.setAttribute("message", new Message("Paramétrage est bien sauvegardé ","succes"));
		return "redirect:/CpnlSetting";
	}catch(Exception e) {
		System.out.println("ERROR "+e.getMessage());
		e.printStackTrace();
		session.setAttribute("message", new Message("échec de sauvegarde","danger"));
		return "redirect:/CpnlSetting/new";
	}
		
	}
	
	@RequestMapping("/CpnlSetting/edit/{id}")
	public String showEditCpnlSettingPage(@PathVariable("id") String id , Model model) {
		CpnlSetting cpnlSetting = repo.findById(id).get();
        model.addAttribute("cpnlSetting", cpnlSetting);
        List<CpnlSetting> listCpnlSetting = repo.findAll();
	    model.addAttribute("listCpnlSetting", listCpnlSetting); 
	    return "EditCpnlSetting";
	} 
	
	@RequestMapping("/CpnlSetting/delete/{id}")
	public String deleteCpnlSetting(@PathVariable("id") String id , Model model
			,Principal principal,HttpSession session) {
		try {
			repo.deleteById(id);
			session.setAttribute("message", new Message("Supression reussite","succes"));
			}catch(Exception e) {
				System.out.println("ERROR "+e.getMessage());
				e.printStackTrace();
				session.setAttribute("message", new Message("Supression failed, Vous devez supprimer les dependances avant","danger"));
				
			}
		
		return "redirect:/CpnlSetting";       
	}
}
