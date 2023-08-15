/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.core.xml.xmlConfig.ClassesWithAnnotaions;

import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Required;

import spring.core.xml.xmlConfig.classes.*;

/**
 *
 * @author mohamed.aljazwiee
 */
@Resource(name = "employeeInfo")
public class Employee {

    static final Logger logger = Logger.getLogger(Employee.class.toString());

    private Integer id;
    private String firstName;
    private String lastName;

    private String designation;
    @Resource(name = "company")
    private Company company;

    private Address address;

    @PostConstruct
    private void employeePostConstructor() {
        logger.info("execue employeePostConstructor mehtod for Employee Class ");
    }

    @PreDestroy
    private void employeePreDestroy() {
        logger.info("execue employeePreDestroy mehtod for Employee Class ");
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Address getAddress() {
        return address;
    }

    // IN THIS CASE it used on setter attribute and by default  inject address bean with declared by setter property  name

    @Resource
    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    @Required
    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    @Required
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

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", designation=" + designation
                + ", company=" + company
                + ", address=" + address + '}';
    }

}
