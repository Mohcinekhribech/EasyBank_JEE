package  com.example.easybank_jee.DTO;

import java.util.List;
import  lombok.Data;
@Data
public final class Client extends Person{
    private String code;
    private String adress;
    private List<Account> accounts;
}
