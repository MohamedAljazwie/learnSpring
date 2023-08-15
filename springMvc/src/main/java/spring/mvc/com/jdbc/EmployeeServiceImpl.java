/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.jdbc;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author MohamedSayed
 */
@Service("employeejdbcService")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)

public class EmployeeServiceImpl implements EmployeeService{
private EmployeeDao employeeDao;

    public EmployeeDao getEmployeeDao() {
        return employeeDao;
    }

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }


    @Override
//    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public Employee getEmployee(Integer empID) {
return employeeDao.getEmployee(empID);
    }

    @Override
    public List<Employee> listEmployees() {
return employeeDao.listEmployees();
    }

    @Override
    public void delete(Integer empid) {
employeeDao.delete(empid);
    }

    @Override
    public void delete(Employee employee) {
employeeDao.delete(employee);
    }

    @Override
    public void update(Employee employee) {
employeeDao.update(employee);
    }
    
}
