package spring.mvc.com.annotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.mvc.com.annotations.besns.Visitor;

import javax.inject.Provider;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@RestController
@RequestMapping("sessionScope")
public class _9_SessionScope {
	@Autowired
    private Provider<Visitor> visitorProvider;
	
    @RequestMapping("/**")
    public Visitor handleRequestById (Model model, HttpServletRequest request,HttpSession httpSession) {
        model.addAttribute("msg", "trades request, serving page " + request.getRequestURI());
        visitorProvider.get()
                       .addPageVisited( request.getRemoteAddr(), request.getRequestURI());
        Visitor visitor=(Visitor)httpSession.getAttribute("visitor");
        if(visitor!=null)
        	System.out.println(visitor);
        return   visitorProvider.get();
    }
    
  
}
