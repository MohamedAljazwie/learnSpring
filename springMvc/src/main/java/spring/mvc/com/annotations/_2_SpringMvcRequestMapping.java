package spring.mvc.com.annotations;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * The annotation @RequestMapping
It is used to map request URLs to specific controllers.

All elements of @RequestMapping annotation are optional.

It's annotated with @Target(value={METHOD,TYPE}), so it can be used on class level or method level.

If @RequestMapping specifies a path on class level then all paths in the methods 
  are relative.

@RequestMapping on the class level is not required. Without it, 
all paths are simply absolute, and not relative

The handler methods without @RequestMapping won't be mapped, 
even their enclosing class has @Controller and a valid @RequestMapping annotations.


A method without @RequestMapping won't be mapped, 
even though enclosing class annotations are valid. 
For example the following code will not map the method handleAllUsersRequest() 
and will return 404 error for the request
 @Controller
 @RequestMapping("/users")
 public class UserController {

  public String handleAllUsersRequest(){
        .....
  }
 }
 */
@Controller
@RequestMapping("/mvcRequestMapping")
public class _2_SpringMvcRequestMapping {


    @RequestMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
    		                     MediaType.APPLICATION_XML_VALUE},
    		        produces  = {MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public String handleJson(@RequestBody String s) {
        System.out.println("json body : " + s);
        return "";
    }

}
