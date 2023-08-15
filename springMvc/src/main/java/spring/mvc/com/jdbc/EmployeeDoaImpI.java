/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

/**
 *
 * @author MohamedSayed
 */
public class EmployeeDoaImpI extends  JdbcDaoSupport implements EmployeeDao{
    
  @Override
    public Employee getEmployee(Integer empID) {
String sql="SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";
return (Employee) getJdbcTemplate().queryForObject(sql,new Object[]{empID},new BeanPropertyRowMapper(Employee.class));
    }

    @Override
    public List<Employee> listEmployees() {
        return getJdbcTemplate().query("SELECT * FROM EMPLOYEES ",  new EmployeeMapper());
    }

    @Override
    public void delete(Integer empid) {
      String sql="DELETE FROM EMPLOYEES EHERE EMPLOYEE_ID=?";
       int val=getJdbcTemplate().update(sql, new Object[]{empid});

       if(val>0)
           System.out.println("Deleted Record with EMPID = " + empid +" Sucess Deleted");
       else
           System.out.println("Deleted Record with EMPID = " + empid +" Falid to delete ");
    }

   

    @Override
    public void addEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
     class EmployeeMapper implements RowMapper<Employee>
    {

        @Override
        public Employee mapRow(ResultSet rs, int i) throws SQLException {
            Employee employees=new Employee();
            employees.setEmail(rs.getString("EMAIL"));
            employees.setCommissionPct(rs.getBigDecimal("COMMISSION_PCT"));
            employees.setFirstName(rs.getString("FIRST_NAME"));
            employees.setLastName(rs.getString("LAST_NAME"));
            employees.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
           return employees;
        }
     }
     
     
}
