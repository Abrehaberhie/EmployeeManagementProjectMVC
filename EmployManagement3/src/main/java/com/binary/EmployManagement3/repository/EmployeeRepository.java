package com.binary.EmployManagement3.repository;

import com.binary.EmployManagement3.model.Employee;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository
public class EmployeeRepository {
    int idcount=1;
    List<Employee> employees = new ArrayList<>();
    public EmployeeRepository()
    {
        Employee empObj= new Employee();
        empObj.setId(1);
        empObj.setName("abreha");
        empObj.setDepartment("education");
        empObj.setRole("teaching students");
        Employee empObje1= new Employee();
        empObje1.setId(2);
        empObje1.setName("helen");
        empObje1.setDepartment("Communication");
        empObje1.setRole("jornalist");
        Employee empObje2= new Employee();
        empObje2.setId(3);
        empObje2.setName("messy");
        empObje2.setDepartment("sport");
        empObje2.setRole("soccer player");
        Employee empObje3= new Employee();
        empObje3.setId(4);
        empObje3.setName("michel jackson");
        empObje3.setDepartment("entartainment");
        empObje3.setRole("singer");

        employees.add(empObj);
        employees.add(empObje1);
        employees.add(empObje2);
        employees.add(empObje3);


    }

    public void addNewEmployee(Employee employee)
    {
        employee.setId(idcount);
        employees.add(employee);
        idcount++;
    }
    public List<Employee>  getAllEmployee()
    {
        return employees;
    }
    public Optional<Employee> getEmployyeeById(int id)
    {
        return employees.stream().filter((Employee->Employee.getId()==id)).findFirst();
    }
    public void updateEmployee(Employee updatedEmployee)
    {
        for(int i=0;i<employees.size();i++)
        {
           if(employees.get(i).getId().equals(updatedEmployee.getId()))
           {
               employees.set(i,updatedEmployee);
               break;
           }
        }
    }
    public void deletEmployeeById(Integer id)
    {
        for(int i=0;i<employees.size();i++)
        {
            if(employees.get(i).getId()==id)
            {
                employees.remove(i);
                break;
            }
        }

    }

}
