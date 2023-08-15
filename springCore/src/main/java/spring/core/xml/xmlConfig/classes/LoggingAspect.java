package spring.core.xml.xmlConfig.classes;

public class LoggingAspect {
 public void logBeforeAdvice() {

  System.out.println("logBeforeAdvice() is running!");
//  System.out.println("hijacked : " + joinPoint.getSignature().getName());
  System.out.println("******");
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
