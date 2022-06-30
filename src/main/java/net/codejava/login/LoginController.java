package net.codejava.login;

import java.security.Principal;

//import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import net.codejava.Message;

//import net.codejava.Ruser.Ruser;
//import net.codejava.RuserProfile.RuserProfile;

//import net.codejava.Ruser.Ruser;
//import net.codejava.Ruser.RuserRepository;
//import net.codejava.RuserProfile.RuserProfile;
//import net.codejava.RuserProfile.RuserProfileRepository;

@Controller
public class LoginController {

	@Autowired
    private UserRepository repo;
	
	/*@Autowired
    private RuserRepository repo;
	@Autowired
    private RuserProfileRepository	repoP;
	
	@GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new Ruser());
         
        List<RuserProfile> listRuserProfile = repoP.findAll();
		model.addAttribute("listRuserProfile",listRuserProfile);
        return "SingUp";
    }
    
    @PostMapping("/process_register")
    public String processRegister(Ruser user) {
    	
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
         
        repo.save(user);
         
        return "Home_Page";
    }*/
    
    @GetMapping("/Welcome_Page")
    public String viewWelcomePage(Model model) {
    	/*Ruser ruser1 =  new Ruser();
		model.addAttribute("ruser1",ruser1);
		RuserProfile ruserP =  new RuserProfile();
		model.addAttribute("ruserP",ruserP);*/
    	return "Welcome_Page";
    }
    
    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){    
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login";
    }
    
	@GetMapping("/login")
	public String login() {
		return "Login";
	}
	
	@RequestMapping("/UpdatePassword")
	public String viewNVPasswordPage() {
		return "NewPassword";
	}
	
	@RequestMapping("/UpdatePassword/save")
	public String viewNewPasswordPage(@RequestParam(required=false,name="oldPassword") String oldPassword,@RequestParam(required=false,name="newPassword") String newPassword
			,Principal principal,HttpSession session) {
		String userName=principal.getName();
		System.out.println("*******************************");
		System.out.println(userName);
		User currentUser =repo.findByUCode(userName);
		
		
        // //////////////////////////////////////////////////

        BCryptPasswordEncoder passwordEncoderTest = new BCryptPasswordEncoder();

		String password = oldPassword;
		boolean isPasswordMatch = passwordEncoderTest.matches(password, currentUser.getPassword());
		System.out.println("Password : " + password + "           isPasswordMatch    : " + isPasswordMatch);
		
		
	
        // ////////////////////////////////////////////
		if(isPasswordMatch) {
			
			BCryptPasswordEncoder passwordEncoderNV = new BCryptPasswordEncoder();
	        String encodedPasswordNV = passwordEncoderNV.encode(newPassword);
	        
			currentUser.setPassword(encodedPasswordNV);
			repo.save(currentUser);
			session.setAttribute("message", new Message("Le mot de passe est modifié avec succès","succes"));
			
		}else {
			
			session.setAttribute("message", new Message("Ancien mot de passe incorrect ","danger"));
			
		}
		
		//System.out.println(currentUser.getPassword());

		
		
		return "redirect:/UpdatePassword";
	}
    
}
