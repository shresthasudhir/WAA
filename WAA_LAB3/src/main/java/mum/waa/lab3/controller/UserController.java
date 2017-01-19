package mum.waa.lab3.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import mum.waa.lab3.domain.User;
import mum.waa.lab3.repository.UserRepository;

@Controller
@SessionAttributes("userInfo")
public class UserController {

	@Autowired
	UserRepository userService;

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public String getLoginForm(Model model, HttpSession session, HttpServletRequest request) {
		User newUser = checkCookie(request);
		if (newUser != null) {
			model.addAttribute("checked", "checked");
			model.addAttribute("userName", newUser.getUsername());
		}

		return "login";

	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String authenticate(@ModelAttribute("user") User user, Model model, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {

		if (userService.authenticate(user)) {

			if (request.getParameter("remember") != null) {
				Cookie ckUsername = new Cookie("username", user.getUsername());
				ckUsername.setMaxAge(30*24*60*60);
				//ckUsername.setMaxAge(60);
				response.addCookie(ckUsername);

				Cookie ckPassword = new Cookie("password", user.getPassword());
				ckPassword.setMaxAge(30*24*60*60);
				//ckPassword.setMaxAge(60);
				response.addCookie(ckPassword);

			}else{
				for(Cookie ck: request.getCookies()){
					if(ck.getName().equalsIgnoreCase("username")){
						ck.setMaxAge(0);
						response.addCookie(ck);
					}
				}
			}

			session.setAttribute("userInfo", user);
			// return "welcome"; // try page refresh, PRG?
			return "redirect:/welcome";
		} else {
			model.addAttribute("msgLoginFailed", "username and/or passord invlaid.");
			model.addAttribute("userName", user.getUsername());
			return "login";
		}
	}

	public User checkCookie(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();

		User user = null;
		String username = "", password = "";

		for (Cookie ck : cookies) {
			if (ck.getName().equalsIgnoreCase("username")) {
				username = ck.getValue();
			}
			if (ck.getName().equalsIgnoreCase("password")) {
				password = ck.getValue();
			}
			if (!username.isEmpty() && !password.isEmpty()) {
				user = new User();
				user.setUsername(username);
				user.setPassword(password);
			}
		}

		return user;

	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcomePage() {
		return "welcome";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(SessionStatus status, HttpSession session, HttpServletRequest request,
			HttpServletResponse response) {

		status.setComplete();
		session.removeAttribute("username");
		session.invalidate();

		return "redirect:/login";
	}

}
