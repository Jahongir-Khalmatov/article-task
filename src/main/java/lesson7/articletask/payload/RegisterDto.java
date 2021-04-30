package lesson7.articletask.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDto {
@NotNull(message = "fullName bo'sh bo'lmasin")
    private String fullName;
    @NotNull(message = "username bo'sh bo'lmasin")
private String username;
    @NotNull(message = "password bo'sh bo'lmasin")
    private String password;
 @NotNull(message = "takroriy password bo'sh bo'lmasin")
 private String prePassword;
}
