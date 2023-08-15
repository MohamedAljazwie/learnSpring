package spring.mvc.com.annotations;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@RestController
@RequestMapping("multiValuedQueryParameter")
public class _7_MultiValuedQueryParameter {
	@RequestMapping("/items")
    public String handleRequest(@RequestParam("id") String[] itemIds) {
        String response = "";
        for (String itemId : itemIds) {
            response += "item with string id " + itemId + "<br/>";
        }
        return response;
    }

    @RequestMapping("/items2")
    public String handleRequest2(@RequestParam("id") int[] itemIds) {
        String response = "";
        for (int itemId : itemIds) {
            response += "item with int id " + itemId + "<br/>";
        }
        return response;
    }

    @RequestMapping("/items3")
    public String handleRequest3(@RequestParam MultiValueMap<String, String> queryMap) {
        String response = "";
        List<String> itemIds = queryMap.get("id");
        for (String itemId : itemIds) {
            response += "item from map with String id " + itemId + "<br/>";
        }
        return response;
    }
}
