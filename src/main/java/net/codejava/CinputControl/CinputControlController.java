package net.codejava.CinputControl;

import java.util.List;

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

import net.codejava.Clistsys.Clistsys;
import net.codejava.Clistsys.ClistsysRepository;

@Controller
public class CinputControlController {

	@Autowired
	private ClistsysRepository repoClistsys;
	
	@Autowired
	private CinputControlRepository repo;

	
	@GetMapping("/CinputControl")
	public String listCinputControl(Model model,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="3")int size,
			@RequestParam(name="motCle",defaultValue="")String motCle
			){
		Page<CinputControl>PageCinputControl=repo.findByMenuContains(motCle,PageRequest.of(page, size));
		//Page<CinputControl> PageCinputControl = repo.findAll(PageRequest.of(page, size));
		model.addAttribute("PageCinputControl",PageCinputControl);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		model.addAttribute("size", size);
		model.addAttribute("pages",new int[PageCinputControl.getTotalPages()]);

		
		return "CinputControl";
	}
	
	@GetMapping("/CinputControl/new")
	public String showCinputControlNewForm(Model model) {
		
		List<Clistsys> listClistsys = repoClistsys.findAll();
		CinputControl cinputControl =  new CinputControl();
		model.addAttribute("cinputControl",cinputControl);		
		model.addAttribute("listClistsys",listClistsys);

		return "NewCinputControl";
	} 
	
	
	@RequestMapping(value = "/CinputControl/save", method = RequestMethod.POST)
	public String saveCinputControl(CinputControl cinputControl){
		repo.save(cinputControl);
		return "redirect:/CinputControl";
	}
	
	@RequestMapping("/CinputControl/edit/{id}")
	public String showEditRuserPage(@PathVariable("id") int id , Model model) {
		CinputControl cinputControl = repo.findById(id).get();
        model.addAttribute("cinputControl", cinputControl);
        List<Clistsys> listClistsys = repoClistsys.findAll();
	    model.addAttribute("listClistsys", listClistsys); 
	    return "EditCinputControl";
	} 
	
	@RequestMapping("/CinputControl/delete/{id}")
	public String deletercurrency(@PathVariable("id") int id , Model model) {
		repo.deleteById(id);
		return "redirect:/CinputControl";       
	}
}
