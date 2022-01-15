package org.emp.service;

import org.emp.core.Employee;
import org.springframework.beans.factory.annotation.Value;

import java.util.Collection;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class EmployeeServiceProxy implements EmployeeService {
    private Logger logger = Logger.getLogger("EmployeeServiceProxy");

    private EmployeeService service;

    public EmployeeServiceProxy(EmployeeService service) {
        this.service = service;
    }

    @Override
    public Employee get(int id) {
        logger.info("Calling service getEmpId");
        return service.get(id);
    }

    @Override
    public Collection<Employee> getAll() {
        logger.info("Calling service getAllEmployee");
        return service.getAll();
    }

    @Value("${section}")
    String sect;
    public Collection<Employee> getSect(String sect,String name) {
        logger.info("Calling setSect method");
        return service.getAll().stream()
                                .filter(emp -> emp.getSect().equals(sect))
                                .filter(emp->emp.getEmpName().contains(name))
                                .collect(Collectors.toList());
    }

    @Value("${max}")
    int max;
    public Collection<Employee> getMaxEmployee(){
        logger.info("Calling getMaxEmployee method");
        return service.getAll().stream().limit(max).collect(Collectors.toList());
    }

    @Override
    public void add(Employee employee) {
        if(employee.getEmpName()!=null && employee.getSect()!=null){
            service.add(employee);
        }
    }

    @Override
    public void deleteEmployee(int id) {
        service.deleteEmployee(id);
    }
}
