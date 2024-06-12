package com.example.EmployeeDemo.controller;

import com.example.EmployeeDemo.model.Employee;
import com.example.EmployeeDemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService empService;

    @GetMapping("/listEmployees")
    public List<Employee> getEmployeesList(){
        return empService.getEmployeesList();
    }

    @GetMapping("/employeeAddressesList")
    public String employeeAddressesList(){
        return empService.employeeAddressesList();
    }

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee employee){
        return empService.addEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<Employee> addEmployees(@RequestBody List<Employee> employees){
        return empService.addEmployees(employees);
    }

    @PutMapping("/updateEmployee/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee){
        return empService.updateEmployee(id, employee);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return empService.deleteEmployee(id);
    }

}
