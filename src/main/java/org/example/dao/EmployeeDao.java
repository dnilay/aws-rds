package org.example.dao;

import org.example.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public Employee createEmployee(Employee employee);
    public List<Employee> getEmployees();
}
