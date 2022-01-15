package org.emp;

import org.emp.dao.EmployeeDao;
import org.emp.dao.EmployeeDaoImpl;
import org.emp.service.EmployeeService;
import org.emp.service.EmployeeServiceImpl;
import org.emp.service.EmployeeServiceProxy;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;


@Configuration
//@PropertySource({"classpath:employee.properties"})
@PropertySource({"classpath:application.yaml"})
public class EmployeeConfig {

    @Bean(name = "employeeDao")
    public EmployeeDao employeeDao(){
        EmployeeDaoImpl employeeDao=new EmployeeDaoImpl();
        return employeeDao;
    }

    @Bean(name = "employeeService")
    @ConditionalOnExpression(
            "'${env}'=='prod'"
    )
    public EmployeeService employeeService(){
        EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
        employeeService.setEmployeeDao(employeeDao());
        return employeeService;
    }


    @Bean(name = "employeeService")
    @ConditionalOnExpression(
            "'${env}'=='test'"
    )
    public EmployeeService employeeServiceTest(){
        EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
        employeeService.setEmployeeDao(employeeDao());
        return new EmployeeServiceProxy(employeeService);
    }

}
