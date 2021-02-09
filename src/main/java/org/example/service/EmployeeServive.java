package org.example.service;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeServive {
    public Employee createEmployee(Employee employee);
    public List<Employee> getEmployees();
}
