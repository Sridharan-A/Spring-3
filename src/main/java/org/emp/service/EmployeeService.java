package org.emp.service;

import org.emp.core.Employee;

import java.util.Collection;

public interface EmployeeService {
    Employee getEmpId(int id);
    Collection<Employee> getAll();
    Collection<Employee> getSect();
    public Collection<Employee> getMaxEmployee();
}
