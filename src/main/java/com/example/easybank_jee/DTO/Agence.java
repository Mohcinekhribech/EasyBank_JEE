package  com.example.easybank_jee.DTO;

import java.util.List;
import  lombok.Data;
@Data
public   class Agence {
    private String code ;
    private String name ;
    private String adress;
    private String phoneNumber;
    private List<Account> accounts;

}
