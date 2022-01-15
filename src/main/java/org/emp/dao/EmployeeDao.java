package org.emp.dao;

import org.emp.core.Employee;

import java.util.Collection;

public interface EmployeeDao {

    public Employee getOne(int id);

    public Collection<Employee> getAll();

    public void add(Employee employee);

    public void delete(int id);

    public void updateName(Employee employee);
}
