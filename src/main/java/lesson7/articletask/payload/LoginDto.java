package lesson7.articletask.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginDto {
    @NotNull(message = "username bo'sh bo'lmasin")
    private String username;
    @NotNull(message = "password bo'sh bo'lmasin")
    private String password;
}
