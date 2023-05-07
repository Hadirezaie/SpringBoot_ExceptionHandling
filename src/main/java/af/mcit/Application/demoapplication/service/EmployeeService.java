package af.mcit.Application.demoapplication.service;

import af.mcit.Application.demoapplication.Domain.Employee;
import af.mcit.Application.demoapplication.error.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {

    public Employee saveemployee(Employee employee);

  public List<Employee> fetchemployeeList();

   public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException;

   public void deleteEmployeeById(Long employeeId);

    public Employee updateEmployee(Long employeeId, Employee employee);

   public Employee fetchEmployeeByName(String employeeName);
}
