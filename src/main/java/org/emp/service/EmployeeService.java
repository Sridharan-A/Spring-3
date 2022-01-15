package org.emp.service;

import org.emp.core.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee get(int id);
    Collection<Employee> getAll();
    Collection<Employee> getSect(String sect,String name);
    public Collection<Employee> getMaxEmployee();
    void add(Employee employee);
    void deleteEmployee(int id);
}
