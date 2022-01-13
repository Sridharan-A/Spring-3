package org.emp.dao;

import org.emp.core.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class EmployeeDaoImpl implements EmployeeDao{

    private Map<Integer, Employee> Employee;

    {
        Employee = new HashMap<>();
        Employee.put(1, new Employee(1,"abc","A"));
        Employee.put(2, new Employee(2,"def","B"));
        Employee.put(3, new Employee(3,"ghi","A"));
        Employee.put(4, new Employee(4,"jkl","D"));
    }


    @Override
    public org.emp.core.Employee getOne(int id) {
        return Employee.get(id);
    }

    @Override
    public Collection<Employee> getAll() {
        return Employee.values();
    }


}
