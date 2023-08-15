package spring.mvc.com.annotations.besns;

import org.springframework.stereotype.Component;

import spring.mvc.com.annotations.besns.InMemoryUserService.User;


@Component
public interface UserService {
User loginUser(User user);
}

