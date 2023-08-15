package spring.mvc.com.annotations.besns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
@Component
@Scope(WebApplicationContext.SCOPE_SESSION)
public class Visitor implements Serializable {
    private  String ip;
    private final List<String> pageVisited = new ArrayList<>();
    public Visitor () {
    	ip=null;
    }
    public Visitor (String ip) {
        this.ip = ip;
    }

    public String getIp () {
        return ip;
    }

    public void addPageVisited (String ip,String page) {
        pageVisited.add(page);
        if(this.ip==null)
        this.ip=ip;
    }

    public List<String> getPagesVisited () {
        return pageVisited;
    }

	@Override
	public String toString() {
		return "Visitor [ip=" + ip + ", pageVisited=" + pageVisited + "]";
	}
   
}
