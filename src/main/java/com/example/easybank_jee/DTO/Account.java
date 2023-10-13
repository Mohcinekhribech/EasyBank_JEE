package  com.example.easybank_jee.DTO;

import com.example.easybank_jee.DTO.Enum.Status;
import  lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public abstract class Account {
    private String accountNumber;
    private double balance;
    private LocalDate creationDate;
    private Status status;
    private Client client;
    private List<Operation> operations;
    
}
