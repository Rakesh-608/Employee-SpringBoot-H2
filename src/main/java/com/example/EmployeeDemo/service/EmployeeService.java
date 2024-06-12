package com.example.EmployeeDemo.service;

import com.example.EmployeeDemo.model.Employee;
import com.example.EmployeeDemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getEmployeesList(){
        return repo.findAll();
    }

    public Employee addEmployee(Employee employee) {
        return repo.save(employee);
    }

    public String employeeAddressesList(){

        List<Employee> emps=repo.findAll();
        StringBuilder employeeWithAddress=new StringBuilder();
        for(Employee emp:emps){
            StringBuilder temp = new StringBuilder("EmployeeId: " + emp.getId() + " Name: " + emp.getName() + " City: " + emp.getCity() + " Country: " + emp.getCountry()+"\n");
            employeeWithAddress.append(temp);
        }
        return employeeWithAddress.toString();
    }

    public String updateEmployee(Long id,Employee employee){

            Employee existingEmployee = repo.findById(id).orElse(null);
        Objects.requireNonNull(existingEmployee).setId(employee.getId());
        existingEmployee.setName(employee.getName());
        existingEmployee.setCity(employee.getCity());
        existingEmployee.setCountry(employee.getCountry());
        repo.save(existingEmployee);
        return "Employee with ID: "+id+" is updated";
    }

    public String deleteEmployee(Long id){
        repo.deleteById(id);
        return "Employee with ID: "+id+" is deleted";
    }

    public List<Employee> addEmployees(List<Employee> employees){
        return repo.saveAll(employees);
    }
}
