package spring.core.xml.xmlConfig.ClassesWithAnnotaions;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
@Aspect
public class LoggingAspect {
	@Before("execution(CoreSpring.ClassesWithAnnotaions.EmployeeService.addEmployee())")
	public void loggingBoforeAdvice()  
	{
	  //....
	  //....
	  System.out.println("Advice run. ADD method is called");
	}

 public void logAfterAdvice() {

  System.out.println("logAfterAdvice() is running!");
//  System.out.println("hijacked : " + joinPoint.getSignature().getName());
  System.out.println("******");

 }
 
 public void logAfterReturningAdvice() {

  System.out.println("logAfterReturningAdvice() is running!");
//  System.out.println("hijacked : " + joinPoint.getSignature().getName());
//  System.out.println("Method returned value is : " + result);
  System.out.println("******");

 }
 
 public void logAfterThrowingAdvice() {

  System.out.println("logAfterThrowingAdvice() is running!");
//  System.out.println("hijacked : " + joinPoint.getSignature().getName());
//  System.out.println("Exception : " + error);
  System.out.println("******");

 }
 
 public void logAroundAdvice() throws Throwable {

  System.out.println("logAroundAdvice() is running!");
//  System.out.println("hijacked method : " + joinPoint.getSignature().getName());
//  System.out.println("hijacked arguments : " + Arrays.toString(joinPoint.getArgs()));
  
  System.out.println("Around before is running!");
  //joinPoint.proceed();
  System.out.println("Around after is running!");
  
  System.out.println("******");

 }
}
