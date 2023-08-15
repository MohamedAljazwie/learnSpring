/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.classes;

/**
 *
 * @author mohamed.aljazwiee
 */
public class Address {
	private String city;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

    @Override
    public String toString() {
        return "Address{" + "city=" + city + '}';
    }
        
        
} 
