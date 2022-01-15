package org.emp.service;

import org.emp.core.Employee;
import org.emp.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;
@Named
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee get(int id) {
        return employeeDao.getOne(id);
    }

    @Override
    public Collection<Employee> getAll() {
        return employeeDao.getAll().stream().collect(Collectors.toList());
    }

    @Value("#{employeeDao.getAll().?[sect.equals('${section}')]}")
    Collection<Employee> employeeCollection =new ArrayList<Employee>();
    public Collection<Employee> getSect(String sect,String name){
        return employeeCollection;
    }

    @Value("${max}")
    int max;
    public Collection<Employee> getMaxEmployee(){
        return employeeDao.getAll().stream().limit(max).collect(Collectors.toList());
    }

    @Override
    public void add(Employee employee) {
        if(employee.getEmpName()!=null &&employee.getSect()!=null){
            employeeDao.add(employee);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        employeeDao.delete(id);
    }


}



