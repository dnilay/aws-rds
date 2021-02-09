package org.example;

import org.example.entity.Employee;
import org.example.service.EmployeeServive;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.util.Random;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner scanner=null;

    static
    {
        scanner=new Scanner(System.in);
    }
    public static void main( String[] args )
    {
        try {

                ClassPathXmlApplicationContext context=
                        new ClassPathXmlApplicationContext("applicationContext.xml");
            EmployeeServive employeeServive=context.getBean("employeeService",EmployeeServive.class);
            String firstName=null;
            String lastName=null;
            String email=null;
            System.out.print("Enter First Name: ");
            firstName=scanner.next();
            System.out.print("Enter Last Name: ");
            lastName=scanner.next();
            System.out.print("Enter Email: ");
            email=scanner.next();
            Employee employee=new Employee(new Random().nextInt(1000),firstName,lastName,email);
            System.out.println(employeeServive.createEmployee(employee));

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
