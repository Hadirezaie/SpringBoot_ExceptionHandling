package af.mcit.Application.demoapplication.service;

import af.mcit.Application.demoapplication.Domain.Employee;
import af.mcit.Application.demoapplication.error.EmployeeNotFoundException;
import af.mcit.Application.demoapplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveemployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> fetchemployeeList() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee fetchEmployeeById(Long employeeId) throws EmployeeNotFoundException {
        Optional<Employee> employee= employeeRepository.findById(employeeId);
        if(!employee.isPresent()){
           throw new EmployeeNotFoundException("Employee Not Available!");
        }
        return employee.get();
    }

    @Override
    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    @Override
    public Employee updateEmployee(Long employeeId, Employee employee) {
        Employee dprDb= employeeRepository.findById(employeeId).get();
        if(Objects.nonNull(employee.getEmployeeName())&&
        !"".equalsIgnoreCase(employee.getEmployeeName())){
            dprDb.setEmployeeName(employee.getEmployeeName());
                    }
        if(Objects.nonNull(employee.getEmployeeAddress())&&
                !"".equalsIgnoreCase(employee.getEmployeeAddress())){
            dprDb.setEmployeeAddress(employee.getEmployeeAddress());
        }
        if(Objects.nonNull(employee.getEmployeeCode())&&
                !"".equalsIgnoreCase(employee.getEmployeeCode())){
            dprDb.setEmployeeCode(employee.getEmployeeCode());
        }
return employeeRepository.save(dprDb);
    }

    @Override
    public Employee fetchEmployeeByName(String employeeName) {
//        return employeeRepository.findByemployeeName(employeeName);
        return employeeRepository.findByemployeeNameIgnoreCase(employeeName);
    }

}
