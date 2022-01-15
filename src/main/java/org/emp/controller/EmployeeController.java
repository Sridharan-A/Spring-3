package org.emp.controller;

import org.emp.EmployeeProperties;
import org.emp.core.Employee;
import org.emp.service.EmployeeService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.inject.Inject;
import java.net.URI;
import java.util.Collection;
import java.util.Optional;

@RequestMapping("/employee")
@RestController
public class EmployeeController {

    @Inject
    EmployeeService employeeService;
    @Inject
    EmployeeProperties employeeProperties;

    @GetMapping
    public Collection<Employee> getAll(){
        return employeeService.getAll();
    }

//    @GetMapping
//    public ModelAndView getAll(){
//        return new ModelAndView("company","employeeService",employeeService.getAll());
//    }

    @GetMapping(path="/msg")
    public String getMessage(@RequestHeader("user-agent") String userAgent){
        return employeeProperties.getGreeting()+" using "+userAgent;
    }

    @GetMapping("/{id}")
    public Employee getOneEmployee(@PathVariable int id){
        return employeeService.get(id);
    }

    @GetMapping(path = "/single" ,produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Employee> getSingleEmployee(@RequestParam("id") Optional<Integer> optional) {
        Employee employee = employeeService.get(optional.orElse(1));
        System.out.println(employee);
        return ResponseEntity.ok(employee);
    }

     @GetMapping("/search/{section}")
    public Collection<Employee> getEmployeeInSection(@PathVariable("section") String sect,@RequestParam("name") Optional<String> optional){
        return employeeService.getSect(sect, optional.orElse(""));
    }

    @PostMapping
    public ResponseEntity<String> addEmployee(@RequestBody Employee employee){
        employeeService.add(employee);
        if(employee.getEmpId()>0)
        {
            URI uri=URI.create("/company/employee/"+employee.getEmpId());
            return ResponseEntity.accepted().location(uri).build();
        }
       return ResponseEntity.badRequest().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmp(@PathVariable("id") int id){
        employeeService.deleteEmployee(id);
        if(employeeService.get(id)==null){
            URI uri=URI.create("/company/employee/"+employeeService.get(id));
            return ResponseEntity.accepted().location(uri).build();
        }
        return ResponseEntity.badRequest().build();
    }



}
