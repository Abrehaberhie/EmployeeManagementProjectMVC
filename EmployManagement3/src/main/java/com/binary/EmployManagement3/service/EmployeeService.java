package com.binary.EmployManagement3.service;

import com.binary.EmployManagement3.model.Comment;
import com.binary.EmployManagement3.model.Employee;
import com.binary.EmployManagement3.repository.CommentRepository;
import com.binary.EmployManagement3.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class EmployeeService {

   private final CommentRepository commentRepository;
    private final EmployeeRepository employeeRepository;
  public Employee addEmployee(Employee employee)
  {
      employeeRepository.addNewEmployee(employee);
      return employee;
  }
  public List<Employee> getAllEmployee()
  {
      List<Employee> employees= employeeRepository.getAllEmployee();
      for(int i=0;i<employees.size();i++)
      {
          Employee employee= employees.get(i);
          List<Comment> comments= commentRepository.getAllCommentsByEmployeeId(employee.getId());
          employee.setComments(comments);
      }
      return employees;
  }
  public Optional<Employee> getEmployeeById(int id)
  {
      return employeeRepository.getEmployyeeById(id);
  }
  public void updatingEmployee(Employee updatedEmp)
  {
      employeeRepository.updateEmployee(updatedEmp);
  }
  public void deletEmployee(Integer id)
  {
      employeeRepository.deletEmployeeById(id);
  }

}
