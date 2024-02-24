package com.flight_reservation_app.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.flight_reservation_app.Repository.UserRepository;
import com.flight_reservation_app.entity.User;

@Controller
public class UserController {
	@Autowired
	private UserRepository userRepo;
	
	// for showing the login page in front of the page 
	
	@RequestMapping("/showLoginPage")
	public String showLoinPage() {
		return "login/login";
	}
	
	//localhost:8080/flights/CreateReg
	@RequestMapping("/CreateReg")
	public String CreateReg() {
		return "login/CreateReg";
	}
		
	@RequestMapping("/saveReg")
	public String saveReg(@ModelAttribute("user")User user) {
		userRepo.save(user);
		return "login/login";
	}
	
	@RequestMapping("/verifyLogin")
	public String verifyLogin(@RequestParam("emailId")String emailId,@RequestParam("password")String password, ModelMap model) {
		User user = userRepo.findByEmail(emailId);
		if (user.getEmail().equals(emailId)&& user.getPassword().equals(password)) {
			return "find_flights";
		}
		else {
			model.addAttribute("error", "Invalid Username and Password");
			return "login/login";
		}
	}
	
	}



