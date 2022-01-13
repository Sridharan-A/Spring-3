package org.emp.service;

import org.emp.core.Employee;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
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
    public Employee getEmpId(int id) {
        logger.info("Calling service getEmpId:1");
        return service.getEmpId(id);
    }

    @Override
    public Collection<Employee> getAll() {
        logger.info("Calling service getAllEmployee");
        return service.getAll();
    }

    @Value("${section}")
    String sect;
    public Collection<Employee> getSect() {
        logger.info("Calling setSect method");
        return service.getAll().stream().filter(emp -> emp.getSect().equals(sect)).collect(Collectors.toList());
    }

    @Value("${max}")
    int max;
    public Collection<Employee> getMaxEmployee(){
        logger.info("Calling getMaxEmployee method");
        return service.getAll().stream().limit(max).collect(Collectors.toList());
    }
}
