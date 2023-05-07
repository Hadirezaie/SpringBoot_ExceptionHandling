package af.mcit.Application.demoapplication.controller;

import af.mcit.Application.demoapplication.Domain.Employee;
import af.mcit.Application.demoapplication.error.EmployeeNotFoundException;
import af.mcit.Application.demoapplication.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private final Logger LOGGER= LoggerFactory.getLogger(EmployeeController.class);

    @PostMapping("/employees")
    public Employee saveEmployee(@Valid @RequestBody Employee employee){
        LOGGER.info("Inside seveEmployee of EmployeeController.");
        return employeeService.saveemployee(employee);
    }
    @GetMapping("/employees")
    public List<Employee> fetchEmployeeList(){
        LOGGER.info("Inside fetchEmployeeList of EmployeeController.");
        return employeeService.fetchemployeeList();
    }
    @GetMapping("/employees/{employeeId}")
    public Employee fechEmployeeById(@PathVariable Long employeeId) throws EmployeeNotFoundException {
    return employeeService.fetchEmployeeById(employeeId);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployeeById(@PathVariable Long employeeId){
      employeeService.deleteEmployeeById(employeeId);
        return  "Deleted Successfully!!";

    }
    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId,
                                     @RequestBody Employee employee){
return employeeService.updateEmployee(employeeId, employee);

    }

    @GetMapping("/employees/name/{name}")
    public Employee fechEmployeeByName(@PathVariable("name") String EmployeeName){
        return employeeService.fetchEmployeeByName(EmployeeName);
    }
}
