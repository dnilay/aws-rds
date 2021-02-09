package org.example.dao;

import org.example.entity.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeeDaoImpl implements EmployeeDao{
    private DataSource dataSource;
    private Connection connection;
    private Logger logger = Logger.getLogger("org.example.dao.EmployeeDaoImpl");
    public EmployeeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        try {
            connection=dataSource.getConnection();
            logger.info("connection established..");
            logger.info("started creating new record.");
            PreparedStatement preparedStatement=connection.prepareStatement("insert into employees(employee_id,first_name,last_name,email) " +
                    "values(?,?,?,?)");
            preparedStatement.setInt(1,employee.getEmployeeId());
            preparedStatement.setString(2,employee.getFirstName());
            preparedStatement.setString(3,employee.getLastName());
            preparedStatement.setString(4,employee.getEmail());
            preparedStatement.executeUpdate();
            logger.info("success.!");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return employee;
    }

    @Override
    public List<Employee> getEmployees() {
        List<Employee> employees=new ArrayList<Employee>();
        try
        {
            connection=dataSource.getConnection();
            logger.info("connection established..");
            logger.info("started fetching all records....");
            Employee employee=new Employee();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("select employee_id,first_name,last_name,email from employees");
            while (resultSet.next())
            {
                employee.setEmployeeId(resultSet.getInt("employee_id"));
                employee.setFirstName(resultSet.getString("first_name"));
                employee.setLastName(resultSet.getString("last_name"));
                employee.setEmail(resultSet.getString("email"));
                employees.add(employee);
                logger.info("fetch success.");
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        logger.fine("all record fetched successfully...!");
        return employees;
    }
}
