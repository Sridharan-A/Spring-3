package com.emp.service;

import org.emp.core.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class EmployeeControllerTest {
    private HttpHeaders header;
    private String URL;
    @BeforeEach
    void SetUp(){
        URL="http://localhost:8081/company/employee";
        header=new HttpHeaders();
        header.add("content-type", MediaType.APPLICATION_JSON_VALUE);
//        header.add("accept", MediaType.APPLICATION_JSON_VALUE);
    }
    @Test
    public void testAddEmployee(){
        Employee employee=new Employee(0,"fds","O");

        ResponseEntity<String> responseEntity =new RestTemplate().postForEntity(URL,new HttpEntity<Employee>(employee,header),String.class);
        String locationUrl=responseEntity.getHeaders().get("location").get(0);
        ResponseEntity<Employee> response=new RestTemplate().getForEntity("http://localhost:8081"+locationUrl,Employee.class);
        System.out.println(response.getBody());
    }
    @Test
    public void testSinglePathParamXml(){
        HttpHeaders headers=new HttpHeaders();
        headers.add("accept",MediaType.APPLICATION_XML_VALUE);
        ResponseEntity<String> responseEntity=new RestTemplate().exchange(URL+"/single?id={id}", HttpMethod.GET,new HttpEntity<String>(headers),String.class,3);
        System.out.println(responseEntity.getBody());
    }
}
