/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.ClassesWithAnnotaions;

/**
 *
 * @author mohamed.aljazwiee
 */
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
 
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
 @Service                       //    // this annotation is avaliable for execute  annotations/A1pplicationContext.xml
@Scope(value = "singleton")

public class NetworkManager{
 
    private HttpURLConnection connection;
    private String urlStr;
     
    public void setUrlStr(String urlStr){
        this.urlStr = urlStr;
    }
     
    @PostConstruct
    public void init(){
         
        System.out.println("Inside init() method...");
        URL obj;
        try {
            obj = new URL("http://www.google.com");
            //initialize http connection here
            this.connection = (HttpURLConnection) obj.openConnection();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
    @PreDestroy
    public void destroy(){
        try{
            System.out.println("Inside destroy() method...");
            if(this.connection != null) {
                connection.disconnect();
            }
        } catch(Exception ex){
             
        }
    }
     
    public void readData(){
        try {
            int responseCode = this.connection.getResponseCode();
            System.out.println("Response code: "+responseCode);
            /**
             * do your business logic here
             */
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
