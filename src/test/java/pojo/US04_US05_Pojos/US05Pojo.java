package pojo.US04_US05_Pojos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class US05Pojo {
    private String birthDay;
    private String birthPlace;
    private String gender;
    private String name;
    private String phoneNumber;
    private String ssn;
    private String surname;
    private String username;
}

