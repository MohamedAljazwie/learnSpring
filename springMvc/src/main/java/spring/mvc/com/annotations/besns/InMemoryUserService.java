package spring.mvc.com.annotations.besns;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;


@Service
public class InMemoryUserService implements UserService {
	private List<User> users = new ArrayList<>();

	@PostConstruct
	public void init() {
		User user = new User();
		user.setId(1L);
		user.setName("admin");
		user.setEmailAddress("admin@example.com");
		user.setPassword("password");
		users.add(user);
	}

	@Override
	public User loginUser(User user) {
		Optional<User> loggedInUser = users.stream().filter(u -> validateUser(u, user)).findAny();
		return loggedInUser.isPresent() ? loggedInUser.get() : null;
	}

	private boolean validateUser(User existingUser, User user) {
		return existingUser.getEmailAddress().equals(user.getEmailAddress())
				&& existingUser.getPassword().equals(user.getPassword());
	}


	public static class User implements Serializable {
		private Long id;
		private String name;
		private String password;
		private String emailAddress;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", name=" + name + ", password=" + password + ", emailAddress=" + emailAddress
					+ "]";
		}

	}

}
