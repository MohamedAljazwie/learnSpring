/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.classes;

import javax.annotation.Resource;

/**
 *
 * @author mohamed.aljazwiee
 */
public class Company {
	private String compName;
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}

    @Override
    public String toString() {
        return "Company{" + "compName=" + compName + '}';
    }
        
}
