package org.emp;

import org.emp.service.EmployeeService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {
    @Bean
    public EmployeeService employeeService(){
        EmployeeService employeeService=new EmployeeService();
        return employeeService;
    }
}
