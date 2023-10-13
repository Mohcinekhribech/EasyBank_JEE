package  com.example.easybank_jee.DTO;


import com.example.easybank_jee.DTO.Enum.OperationType;
import lombok.Data;

import java.time.LocalDate;
@Data
public class Operation {
    private int operationNumber;
    private LocalDate date;
    private Account account;
    private Employee employee;
    private OperationType type;
    private double price;
}
