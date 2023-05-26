package my.social.social.model.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class User {

    private Long id;
    @NotBlank
    private String login;
    @Email(message = "Email is incorrect")
    private String email;
    @NotBlank
    private String phone;
    private String username;
    @Past
    private LocalDate birthday;
    private String city;

    public Map<String, Object> toMap() {
        Map<String, Object> values = new HashMap<>();
        values.put("login", login);
        values.put("email", email);
        values.put("username", username);
        values.put("birthday", birthday);
        values.put("city", city);

        return values;
    }
}