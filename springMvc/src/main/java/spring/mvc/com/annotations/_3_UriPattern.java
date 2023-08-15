package spring.mvc.com.annotations;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

public class _3_UriPattern {
	   @RequestMapping("/car?/s?o?/info")//score 0
	    public String test1(HttpServletRequest request) {
	        return "from test1(), request uri: " + request.getRequestURI();
	    }

	    @RequestMapping("/c*/s*d/info")//score 2, length = 12
	    public String test2(HttpServletRequest request) {
	        return "from test2(), request uri: " + request.getRequestURI();
	    }

	    @RequestMapping("/card/**")//score 2 but will be used after others because of prefix pattern
	    public String test3(HttpServletRequest request) {
	        return "from test3(), request uri: " + request.getRequestURI();
	    }

	    @RequestMapping("/card/{type}/{id:i.*}")//2 template variables + 1 wildcard = score 3
	    public String test4(@PathVariable String type, @PathVariable String id,
	                        HttpServletRequest request) {
	        return "from test4(), request uri: " + request.getRequestURI() + "\n" +
	                "type: " + type + ", id: " + id;
	    }

	    @RequestMapping("/card/{type}/{id:i.+}")//score 2, length 9 (/card/#/#)
	    public String test5(@PathVariable String type, @PathVariable String id,
	                        HttpServletRequest request) {
	        return "from test5(), request uri: " + request.getRequestURI() + "\n" +
	                "type: " + type + ", id: " + id;
	    }
	    

	    @RequestMapping("/c*/s*d/info")//score 2, length = 12, wildcards=2
	    public String otherTest1(HttpServletRequest request) {
	        return "from otherTest1(), request uri: " + request.getRequestURI();
	    }

	    @RequestMapping("/card/{type}/info")//score 1, length 12 (/card/#/info), wildcards=0
	    public String otherTest2(@PathVariable String type, HttpServletRequest request) {
	        return "from otherTest2(), request uri: " + request.getRequestURI() + "\n" +
	                "type: " + type;
	    }
	    

	    @RequestMapping("/c*/s*d/info")//score 2, length = 12, wildcards=2
	    public String anotherTest1(HttpServletRequest request) {
	        return "from anotherTest1(), request uri: " + request.getRequestURI();
	    }


	    @RequestMapping("/card/{type}/inf{id:.+}")//score 2, length 12 (/card/#/info), wildcard = 0
	    public String anotherTest2(@PathVariable String type, @PathVariable String id,
	                        HttpServletRequest request) {
	        return "from anotherTest2(), request uri: " + request.getRequestURI()+"\n"+
	                "type: "+type+", id: "+id;
	    }
}
