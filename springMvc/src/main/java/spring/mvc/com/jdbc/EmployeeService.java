/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.jdbc;

import java.util.List;

/**
 *
 * @author MohamedSayed
 */
public interface EmployeeService {

  void addEmployee(Employee employee);
    Employee getEmployee(Integer empID);

    List<Employee> listEmployees();

    void delete(Integer empid);
 void delete(Employee employee);
    void update(Employee employee);
}
