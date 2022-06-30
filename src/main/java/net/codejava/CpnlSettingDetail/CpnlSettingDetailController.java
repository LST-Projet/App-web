package net.codejava.CpnlSettingDetail;

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

import net.codejava.Clistcust.Clistcust;
import net.codejava.Clistcust.ClistcustRepository;
import net.codejava.Clistsys.Clistsys;
import net.codejava.Clistsys.ClistsysRepository;
import net.codejava.CpnlSetting.CpnlSetting;
import net.codejava.CpnlSetting.CpnlSettingRepository;

@Controller
public class CpnlSettingDetailController {
	
	
	@Autowired
	private ClistsysRepository repoClistsys;

	@Autowired
	private ClistcustRepository repoClistcust;
	
	@Autowired
	private CpnlSettingRepository repoCpnlSetting;
		
	@Autowired
	private CpnlSettingDetailRepository repo;
	
	
	
	@GetMapping("/CpnlSettingDetail")
	public String listRuser(Model model,
			@RequestParam(name="page",defaultValue="0")int page,
			@RequestParam(name="size",defaultValue="3")int size,
			@RequestParam(name="motCle",defaultValue="")String motCle
			){
		Page<CpnlSettingDetail>PageCpnlSettingDetail=repo.findBypnlSettingIdContains(motCle,PageRequest.of(page, size));
		//Page<CpnlSettingDetail> PageCpnlSettingDetail = repo.findAll(PageRequest.of(page, size));
		model.addAttribute("PageCpnlSettingDetail",PageCpnlSettingDetail);
		model.addAttribute("currentPage", page);
		model.addAttribute("motCle", motCle);
		model.addAttribute("size", size);
		model.addAttribute("pages",new int[PageCpnlSettingDetail.getTotalPages()]);
		
		return "CpnlSettingDetail";
	}
	
	@GetMapping("/CpnlSettingDetail/new")
	public String showRuserProfileNewForm(Model model) {
		
		List<Clistsys> listClistsys = repoClistsys.findAll();
		List<Clistcust> listClistcust = repoClistcust.findAll();
		List<CpnlSetting> listCpnlSetting = repoCpnlSetting.findAll();
		CpnlSettingDetail cpnlSettingDetail =  new CpnlSettingDetail();
		model.addAttribute("cpnlSettingDetail",cpnlSettingDetail);		
		model.addAttribute("listClistsys",listClistsys);
		model.addAttribute("listClistcust",listClistcust);
		model.addAttribute("listCpnlSetting",listCpnlSetting);
		return "NewCpnlSettingDetail";
	} 
	
	
	@RequestMapping(value = "/CpnlSettingDetail/save", method = RequestMethod.POST)
	public String saveCpnlSettingDetail(CpnlSettingDetail cpnlSettingDetail){
		repo.save(cpnlSettingDetail);
		return "redirect:/CpnlSettingDetail";
	}
	
	@RequestMapping("/CpnlSettingDetail/edit/{id}")
	public String showEditRuserPage(@PathVariable("id") int id , Model model) {
		CpnlSettingDetail cpnlSettingDetail = repo.findById(id).get();
        model.addAttribute("cpnlSettingDetail", cpnlSettingDetail);
        List<Clistsys> listClistsys = repoClistsys.findAll();
	    model.addAttribute("listClistsys", listClistsys); 
        List<Clistcust> listClistcust = repoClistcust.findAll();
	    model.addAttribute("listClistcust", listClistcust); 
        List<CpnlSetting> listCpnlSetting = repoCpnlSetting.findAll();
	    model.addAttribute("listCpnlSetting", listCpnlSetting); 
	    return "EditCpnlSettingDetail";
	} 
	
	@RequestMapping("/CpnlSettingDetail/delete/{id}")
	public String deletercurrency(@PathVariable("id") int id , Model model) {
		repo.deleteById(id);
		return "redirect:/CpnlSettingDetail";
}
}
