/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.hibernate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import spring.mvc.com.xml.dao.*;
import spring.mvc.com.xml.model.Employee;

/**
 *
 * @author MohamedSayed
 */
@Repository("hibernateEmployeeDoa")
public class HibernateEmployeeDoaImpI extends HibernateDaoSupport implements EmployeeDao {

  public Employee getEmployee(Integer empID) {
       
            Employee employee = (Employee) getHibernateTemplate().get(Employee.class, empID);
         
            return employee;
       
        
    }
  
    public List<Employee> listEmployees() {
        Session session = getHibernateTemplate().getSessionFactory().openSession();
        try {
            session.beginTransaction();
            return session.createQuery("from Employee").list();

        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(" \n\n \t Message Is " + e.getMessage()
                    + "\n  Caouse" + e.getCause());
            e.printStackTrace();
        } finally {
            session.close();
        }
        return new ArrayList();
    }

  
    public void delete(Integer empid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void delete(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
    public void update(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void addEmployee(Employee employee) {
 Session session = getHibernateTemplate().getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(employee);
            session.getTransaction().commit();
//            Serializable s=employee.getEmployeeId();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(" \n\n \t Message Is " + e.getMessage()
                    + "\n  Caouse" + e.getCause());
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
	@Override
	public List<Employee> listEmployeess() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Employee getEmployee(int empid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
	}

}
