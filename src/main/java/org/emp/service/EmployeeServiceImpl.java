package org.emp.service;

import org.emp.core.Employee;
import org.emp.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements EmployeeService {

    EmployeeDao employeeDao;


    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee getEmpId(int id) {
        return employeeDao.getOne(id);
    }

    @Override
    public Collection<Employee> getAll() {
        return employeeDao.getAll().stream().collect(Collectors.toList());
    }

    @Value("#{employeeDao.getAll().?[sect.equals('${section}')]}")
    Collection<Employee> employeeCollection =new ArrayList<Employee>();
    public Collection<Employee> getSect(){
        return employeeCollection;
    }

    @Value("${max}")
    int max;
    public Collection<Employee> getMaxEmployee(){
        return employeeDao.getAll().stream().limit(max).collect(Collectors.toList());
    }


}
