package org.example.dao;

import org.example.entity.Employee;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Logger;

public class EmployeeDaoImpl implements EmployeeDao{
    private DataSource dataSource;
    private Logger logger = Logger.getLogger("org.example.dao.EmployeeDaoImpl");
    public EmployeeDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        try {
            Connection connection=dataSource.getConnection();
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
}
