package org.emp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/")
@SpringBootApplication
@EnableConfigurationProperties(value = EmployeeProperties.class)
public class EmployeeApp {
    public static void main(String[] args) {
        SpringApplication.run(EmployeeApp.class,args);
    }
    @GetMapping
    RedirectView getHome(){
        return new RedirectView("employee/msg");
    }
}
