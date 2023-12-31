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
public class EmployeeDTO {
 
    private Integer id;
    private String firstName;
    private String lastName;
 
    private String designation;
 
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesignation() {
        return designation;
    }

    //Setters and Getters
    public void setDesignation(String designation) { 
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName
                + ", lastName=" + lastName + ", type=" + designation + "]";
    }
    
    
}