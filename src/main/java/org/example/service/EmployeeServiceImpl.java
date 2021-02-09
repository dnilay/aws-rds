package org.example.service;

import org.example.dao.EmployeeDao;
import org.example.entity.Employee;

public class EmployeeServiceImpl implements EmployeeServive{

    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeDao.createEmployee(employee);
    }
}
