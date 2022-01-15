package org.emp.core;

public class Employee {

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setSect(String sect) {
        this.sect = sect;
    }

    private int empId;
    private String empName;
    private String sect;

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getSect() {
        return sect;
    }



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
