package af.mcit.Application.demoapplication.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employee_id;
    @NotBlank(message = "employee name is mandatory!")
    @Length(max = 10, min = 1)

    private String employeeName;
    @NotBlank
    private String employeeAddress;
    @NotBlank
    private String employeeCode;




}
