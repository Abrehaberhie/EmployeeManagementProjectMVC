package com.binary.EmployManagement3.controller;

import com.binary.EmployManagement3.model.Comment;
import com.binary.EmployManagement3.model.Employee;
import com.binary.EmployManagement3.repository.CommentRepository;
import com.binary.EmployManagement3.service.CommentService;
import com.binary.EmployManagement3.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;
    private final CommentService commentService;
    @GetMapping("/allEmployee")
    public String getAllEmployee(Model m)
    {
        m.addAttribute("allEmp",employeeService.getAllEmployee());
        return "allEmployee";
    }
    @GetMapping("/create")
    public String createEmployeePage(Model m)
    {
        m.addAttribute("newEmployee", new Employee());
        return "createNewEmployee";
    }
    @PostMapping("/create")
    public String createEmployee(@ModelAttribute("newEmployee") @Valid Employee newEmployee, Errors error)
    {
        if(error.hasErrors())
        {
            return "/createNewEmployee";
        }
        employeeService.addEmployee(newEmployee);
        return  "redirect:/allEmployee";
    }
    @GetMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") Integer id ,Model m)
    {
        Optional<Employee> optionalEmployee =employeeService.getEmployeeById(id);
        Employee updatedEmployee=null;
        if(optionalEmployee.isPresent())
        {
            updatedEmployee=optionalEmployee.get();
        }else{
            return "redirect:/allEmployee";
        }

        m.addAttribute("employeNeedToUpdated",updatedEmployee);
        System.out.println(updatedEmployee);
        return "updateEmployee";
    }
    @PostMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable("id") Integer id, @ModelAttribute("employeeNeedToUpdate") @Valid Employee updatedEmployee, Errors errors){

        if(errors.hasErrors()){
            System.out.println(errors.getAllErrors());
            return "updateEmployee";
        }
        System.out.println(updatedEmployee);

        employeeService.updatingEmployee(updatedEmployee);

        return "redirect:/allEmployee";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee1(@PathVariable("id") Integer id ,Model m){
        employeeService.deletEmployee(id);
        return "deleteEmployee";
    }
    @PostMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){


        return "redirect:/allEmployee";
    }
    @GetMapping("/comments")
    public String addComents(Model m )
    {
        m.addAttribute("addedComments",new Comment());
        return "comments";

    }

    @PostMapping("/comments")
    public String addCommentpage(@ModelAttribute("addedComments") @Valid Comment newComment, Errors error,Integer id)
    {
        if(error.hasErrors())
        {
            return "/comments";
        }
        commentService.addComment(id,newComment);

        return  "redirect:/allEmployee";
    }

}
