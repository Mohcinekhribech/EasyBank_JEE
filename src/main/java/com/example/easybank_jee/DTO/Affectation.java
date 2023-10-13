package  com.example.easybank_jee.DTO;

import java.time.LocalDate;
import  lombok.Data;

@Data
public class Affectation {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee employee;
    private Mission mission;

}
