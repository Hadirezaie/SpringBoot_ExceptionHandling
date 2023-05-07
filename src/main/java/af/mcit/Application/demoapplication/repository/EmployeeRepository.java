package af.mcit.Application.demoapplication.repository;

import af.mcit.Application.demoapplication.Domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

public Employee findByemployeeName(String employeeName);
public Employee findByemployeeNameIgnoreCase(String employeeName);
}
