package  com.example.easybank_jee.DTO;

import java.time.LocalDate;

import  lombok.Data;
@Data
public   class EmployeAffectation {
     private Agence agence;
     private Employee employee;
     private LocalDate creationDate;
}
