package lesson7.articletask.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @NotNull(message = "fullName bo'sh bo'lmasin")
    private String fullName;
    @NotNull(message = "username bo'sh bo'lmasin")
    private String username;
    @NotNull(message = "password bo'sh bo'lmasin")
    private String password;
    @NotNull(message = "lavozim bo'sh bo'lmasin")
private Integer lavozimId;
}
