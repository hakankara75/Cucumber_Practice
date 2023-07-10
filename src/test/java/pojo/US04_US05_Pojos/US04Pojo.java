package pojo.US04_US05_Pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class US04Pojo {

    private String name;
    private String surname;
    private String birthPlace;
    private String birthDay;
    private String gender;
    private String phoneNumber;
    private String ssn;
    private String username;
    private String password;
    private String userId;




}
