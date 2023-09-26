package pojo.US04_US05_Pojos;


import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    public US04Pojo(String name, String surname, String birthPlace, String birthDay, String gender, String phoneNumber, String ssn, String username, String password) {
        this.name = name;
        this.surname = surname;
        this.birthPlace = birthPlace;
        this.birthDay = birthDay;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.ssn = ssn;
        this.username = username;
        this.password = password;
    }
}
