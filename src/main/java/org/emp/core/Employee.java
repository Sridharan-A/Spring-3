package org.emp.core;

public class Employee {

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getSect() {
        return sect;
    }

    private int empId;
    private String empName;
    private String sect;

    public Employee() {
    }

    public Employee(int empId, String empName, String sect) {
        this.empId = empId;
        this.empName = empName;
        this.sect = sect;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", section='" + sect + '\'' +
                '}';
    }
}
