package  com.example.easybank_jee.DTO;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;
import  lombok.Data;
@Data
public final   class Employee extends Person {
    private String registrationNumber ;
    private LocalDate recruitmentDate;
    private List<Operation> operations;
    private List<Affectation> affectations;
}
