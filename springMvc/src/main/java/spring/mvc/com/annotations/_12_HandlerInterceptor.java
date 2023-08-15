package spring.mvc.com.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import spring.mvc.com.annotations.besns.InMemoryUserService.User;
import spring.mvc.com.annotations.besns.UserService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
@RestController
@RequestMapping("handlerInterceptor")
public class _12_HandlerInterceptor {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String handleLoginGetRequest() {
		return "you must login first call post method";
	}

	@RequestMapping(value = "login",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			method = RequestMethod.POST)
	public String handleLoginPostRequest(@RequestBody User user, Model model, HttpServletRequest request) {

		User loggedUser = userService.loginUser(user);
		if (loggedUser != null) {
			request.getSession(true).setAttribute("user", loggedUser);
			return "you are login successfully ";
		} else {
//			model.addAttribute("error", "Not a valid user");
			return "Not a valid user ";
		}
	}

	@RequestMapping(value = "app/**", method = RequestMethod.GET)
	public String handleAppRequest(Model model, HttpServletRequest request) {
//		model.addAttribute("uri", request.getRequestURI());
//		model.addAttribute("user", request.getAttribute("user"));
		StringBuilder builder=new StringBuilder();
		builder.append("uri : ").append( request.getRequestURI());
		builder.append("user : ").append( request.getSession().getAttribute("user"));
		return builder.toString();
	}


}
