package spring.mvc.com.annotations;

import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.RequestHandledEvent;

@RestController
@RequestMapping("requestHandledEvent")
public class _8_RequestHandledEvent {
	@RequestMapping(value = "/test")
	public String handle() {
		return "test response from /test";
	}

//	@EventListener
//	public void handleEvent(RequestHandledEvent e) {
//		System.out.println("-- RequestHandledEvent --");
//		System.out.println(e);
//	}
}
