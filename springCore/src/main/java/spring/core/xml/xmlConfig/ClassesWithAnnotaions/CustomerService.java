/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.ClassesWithAnnotaions;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import spring.core.xml.xmlConfig.classes.*;

/**
 *
 * @author mohamed.aljazwiee
 */
@Service()
@Scope("singleton")
public class CustomerService 
{
	String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
