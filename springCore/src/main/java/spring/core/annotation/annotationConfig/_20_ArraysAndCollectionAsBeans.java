package spring.core.annotation.annotationConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.util.*;

@Configuration
public class _20_ArraysAndCollectionAsBeans {

	
	 public static void main(String[] args) {
	        AnnotationConfigApplicationContext annotationConfigApplicationContext =
	        		new AnnotationConfigApplicationContext(_20_ArraysAndCollectionAsBeans.class);
	    }
	 
	@Bean
	public String[] arrayString() {
        return new String[]{"apple", "banana", "orange"};
    }

	@Bean
    public Set<String> setString() {
        return new HashSet(Arrays.asList("apple", "banana", "orange"));
    }
	
	@Bean
	public List<String> listString() {
		return Arrays.asList("apple", "banana", "orange");
	}

	@Bean
	public HashMap<String, String> mapString() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("apple", "every morning");
		map.put("banana", "after lunch");
		map.put("orange", "every evening");
		return map;
	}

	@Bean
	public List<Fruit> listObject() {
		return Arrays.asList(new Fruit("apple", "every morning"), new Fruit("banana", "after lunch"),
				new Fruit("orange", "every evening"));
	}

	@Bean
	public TestBean testBean() {
		return new TestBean();
	}

	private static class TestBean {
		@Autowired
		private String[] arrayString;

		@Autowired
		private List<String> listString;
		@Autowired
		private Set<String> setString;
		@Autowired
		private Map<String, String> mapString;
		@Autowired
		private List<Fruit> listObject;

		@PostConstruct
		public void postConstruct() {
			System.out.println("Arrays OF Strings " + Arrays.toString(arrayString));

			System.out.println(" List OF Strings  " + listString);
			System.out.println(" Set OF Strings  " + setString);
			System.out.println(" Map  OF Strings  " + mapString);
			
			System.out.println(" Lis  OF Objects  " + listObject);
		}
	}

	private static class Fruit {
		private String name;
		private String whenToEat;

		public Fruit(String name, String whenToEat) {
			this.name = name;
			this.whenToEat = whenToEat;
		}

		@Override
		public String toString() {
			return "Fruit{" + "name='" + name + '\'' + ", whenToEat='" + whenToEat + '\'' + '}';
		}
	}
}
