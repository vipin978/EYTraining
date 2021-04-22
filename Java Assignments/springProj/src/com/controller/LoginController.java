package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.UserDTO;
import com.service.UserService;

@Controller
@RequestMapping("login")
public class LoginController {
	
	@Autowired
	private UserService userServ;

	public UserService getUserServ() {
		return userServ;
	}

	public void setUserServ(UserService userServ) {
		this.userServ = userServ;
	}
	
	@RequestMapping(value="loadForm", method=RequestMethod.GET)
	public ModelAndView loadLoginForm(ModelAndView mandv) {
		UserDTO user=new UserDTO();
		mandv.addObject("user",user);
		mandv.setViewName("login");
		return mandv;
	}
	
	@RequestMapping(value="submitForm", method=RequestMethod.POST)
	public ModelAndView submitLoginForm(UserDTO user,ModelAndView mandv ,HttpServletRequest request) throws Exception {
		
		HttpSession session = request.getSession();
		if(userServ.checkUser(user.getName(), user.getPass())) {
			if(!userServ.checkIsOnline(user.getName(), user.getPass())) {
				UserDTO user1 =  userServ.updateFlag(user.getName(), user.getPass(), 1);
				session.setAttribute("user", user1);
				if(user.getName().contains("ey")) {
					mandv.setViewName("organization");
				}
				else {
					mandv.setViewName("welcome");
				}
			}
			else {
				mandv.setViewName("already");
			}
		}
		else {
			mandv.addObject("user", user);
			mandv.setViewName("register");
		}
		return mandv;
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(ModelAndView mv, HttpServletRequest request) throws Exception
	{
		HttpSession session = request.getSession();  
		UserDTO user = (UserDTO)session.getAttribute("user");
		userServ.updateFlag(user.getName(), user.getPass(), 0);
		mv.addObject("user", new UserDTO());
		mv.setViewName("login");
		return mv;
	}
	
	@RequestMapping("register")
	public String register(UserDTO user,ModelAndView mandv ,HttpServletRequest request) throws Exception{
		HttpSession session = request.getSession();
		user.setFlag(1);
		userServ.insertNew(user);
		session.setAttribute("user", user);
		return "welcome";
	}
}