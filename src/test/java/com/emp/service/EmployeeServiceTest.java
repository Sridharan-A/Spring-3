package com.emp.service;

import org.emp.EmployeeConfig;
import org.emp.service.EmployeeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EmployeeServiceTest {

    private ApplicationContext context;
    private EmployeeService service;

    @BeforeEach
    void setUp() {
        context = new AnnotationConfigApplicationContext(EmployeeConfig.class);
        service = context.getBean("employeeService", EmployeeService.class);
    }
    @Test
    public void testemployeeNotNull(){
        assertNotNull(service);
    }
    @Test
    public void testoneEmployee(){
        System.out.println(service.getEmpId(2));
    }
    @Test
    public void testallEmployee(){
        System.out.println(service.getAll());
    }

    @Test
    public void testEmployeeSection(){
        assertEquals(service.getSect().size(),1);
    }
    @Test
    public void testGetMaxEmployee(){
        assertEquals(service.getMaxEmployee().size(),4);
    }
}