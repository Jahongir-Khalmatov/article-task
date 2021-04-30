package lesson7.articletask.payload;

import lesson7.articletask.entity.Lavozim;
import lesson7.articletask.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StaffDto {
@NotNull(message = "adda")
private String username;

 @NotNull(message = "lavozim bo'sh bo'lmasin")
    private Integer lavozimId;
}
