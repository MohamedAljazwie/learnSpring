package spring.core.annotation.annotationConfig;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * The order in which Spring container loads beans cannot be predicted.
 *  There's no specific ordering logic specification given by Spring framework. 
 *  But Spring guarantees if a bean A has dependency of B 
 * (e.g. bean A has an instance variable @Autowired B b;) then B will be initialized first.
 *  But what if bean A doesn't have direct dependency of B and we still want B to initialize first?



When we want to control beans initializing order

There might be scenarios where A is depending on B indirectly. 
For example assume A is some kind of events publisher and B is listening to those events.
 This is a typical scenario of observer pattern.
  We don't want B to miss any events and would like to have B being initialize before A.
 * @author Mohamed.Aljazwiee
 *
 */
@Configuration
//@ComponentScan
public class _10_DependAnnotation {

	@Bean
	@DependsOn("eventListenerBean")
	public EventPublisher eventPublisherBean() {
		return new EventPublisher();
	}

	@Bean
	public EventListener eventListenerBean() {
		return new EventListener();
	}

	@Bean
	public EventManager eventManagerBean() {
		return new EventManager();
	}

	public static void main(String... strings) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(_10_DependAnnotation.class);
		context.close();

	}

	public class EventPublisher {
		@Autowired
		private EventManager eventManager;

		@PostConstruct
		public void initialize() {
			System.out.println("initializing: " + this.getClass().getSimpleName());
			eventManager.publish("event published from EventPublisherBean");
		}
	}

	public class EventManager {
		private final List<Consumer<String>> listeners = new ArrayList();

		@PostConstruct
		public void initialize() {
			System.out.println("initializing: " + this.getClass().getSimpleName());
		}

		public void publish(final String message) {
			for (Consumer<String> consumer : listeners) {
				consumer.accept(message);
			}
		}

		public void addListener(Consumer<String> eventConsumer) {
			listeners.add(eventConsumer);
		}
	}

	public class EventListener {
		@Autowired
		private EventManager eventManager;

		@PostConstruct
		private void initialize() {
			System.out.println("initializing: " + this.getClass().getSimpleName());
			eventManager.addListener(new Consumer<String>() {
				public void accept(String s) {
					System.out.println("event received in EventListenerBean : " + s);
				}
			});

		}
	}
}
