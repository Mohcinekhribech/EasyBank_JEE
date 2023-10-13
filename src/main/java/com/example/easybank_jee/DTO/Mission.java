package  com.example.easybank_jee.DTO;

import java.util.List;
import lombok.Data;
@Data
public   class Mission {
    private String code;
    private String name;
    private String description;
    private List<Affectation> affectations;
}
