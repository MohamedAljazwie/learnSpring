/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spring.mvc.com.jdbc;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author MohamedSayed
 */
@Entity
@Table(name = "EMPLOYEES")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeId = :employeeId")
    , @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName")
    , @NamedQuery(name = "Employee.findByLastName", query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")
    , @NamedQuery(name = "Employee.findByEmail", query = "SELECT e FROM Employee e WHERE e.email = :email")
    , @NamedQuery(name = "Employee.findByHireDate", query = "SELECT e FROM Employee e WHERE e.hireDate = :hireDate")
    , @NamedQuery(name = "Employee.findBySalary", query = "SELECT e FROM Employee e WHERE e.salary = :salary")
    , @NamedQuery(name = "Employee.findByCommissionPct", query = "SELECT e FROM Employee e WHERE e.commissionPct = :commissionPct")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "EMPLOYEE_ID")
    private Integer employeeId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Basic(optional = false)
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "SALARY")
    private BigDecimal salary;
    @Column(name = "COMMISSION_PCT")
    private BigDecimal commissionPct;
//    @JoinColumn(name = "DEPARTMENT_ID", referencedColumnName = "DEPARTMENT_ID")
//    @ManyToOne
//    private Departments departmentId;
//    @OneToMany(mappedBy = "managerId")
//    private Set<Employees> employeesSet;
//    @JoinColumn(name = "MANAGER_ID", referencedColumnName = "EMPLOYEE_ID")
//    @ManyToOne
//    private Employees managerId;
//    @JoinColumn(name = "JOB_ID", referencedColumnName = "JOB_ID")
//    @ManyToOne(optional = false)
//    private JOBS jobId;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employees")
//    private Set<Job_History> jobHistorySet;
//    @OneToMany(mappedBy = "managerId")
//    private Set<Departments> departmentsSet;

    public Employee() {
    }

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(Integer employeeId, String lastName, String email, Date hireDate) {
        this.employeeId = employeeId;
        this.lastName = lastName;
        this.email = email;
        this.hireDate = hireDate;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getCommissionPct() {
        return commissionPct;
    }

    public void setCommissionPct(BigDecimal commissionPct) {
        this.commissionPct = commissionPct;
    }

//    public Departments getDepartmentId() {
//        return departmentId;
//    }
//
//    public void setDepartmentId(Departments departmentId) {
//        this.departmentId = departmentId;
//    }
//
//    @XmlTransient
//    public Set<Employees> getEmployeesSet() {
//        return employeesSet;
//    }
//
//    public void setEmployeesSet(Set<Employees> employeesSet) {
//        this.employeesSet = employeesSet;
//    }
//
//    public Employees getManagerId() {
//        return managerId;
//    }
//
//    public void setManagerId(Employees managerId) {
//        this.managerId = managerId;
//    }
//
//    public JOBS getJobId() {
//        return jobId;
//    }
//
//    public void setJobId(JOBS jobId) {
//        this.jobId = jobId;
//    }
//
//    @XmlTransient
//    public Set<Job_History> getJobHistorySet() {
//        return jobHistorySet;
//    }
//
//    public void setJobHistorySet(Set<Job_History> jobHistorySet) {
//        this.jobHistorySet = jobHistorySet;
//    }
//
//    @XmlTransient
//    public Set<Departments> getDepartmentsSet() {
//        return departmentsSet;
//    }
//
//    public void setDepartmentsSet(Set<Departments> departmentsSet) {
//        this.departmentsSet = departmentsSet;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntitisFromTables.HR.Employees[ employeeId=" + employeeId +" employee Name  "+firstName+" "+lastName+ " ]";
    }
    
}
