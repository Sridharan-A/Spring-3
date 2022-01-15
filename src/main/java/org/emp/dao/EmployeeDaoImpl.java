package org.emp.dao;

import org.emp.core.Employee;

import javax.inject.Named;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
@Named
public class EmployeeDaoImpl implements EmployeeDao{

    private Map<Integer, Employee> Employee;

    {
        Employee = new HashMap<>();
        Employee.put(1, new Employee(1,"abca","A"));
        Employee.put(2, new Employee(2,"defa","B"));
        Employee.put(3, new Employee(3,"ghia","A"));
        Employee.put(4, new Employee(4,"jkla","B"));
    }


    @Override
    public Employee getOne(int id) {
        return Employee.get(id);
    }

    @Override
    public Collection<Employee> getAll() {
        return Employee.values();
    }

    @Override
    public void add(Employee employee) {
        int id= Employee.keySet().size();
        id++;
        employee.setEmpId(id);
        Employee.put(id,employee);
    }

    @Override
    public void delete(int id) {
        Employee.remove(id);
    }

    @Override
    public void updateName(org.emp.core.Employee employee) {

    }

//    @Override
//    public void updateName(Employee employee) {
//        employee.setEmpName(name);
//        employee.setEmpId(id);
//        Employee.put(id, employee);
//    }


}
