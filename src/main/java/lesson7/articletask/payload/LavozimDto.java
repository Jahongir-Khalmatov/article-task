package lesson7.articletask.payload;

import lesson7.articletask.entity.enums.Huquq;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LavozimDto {
    @NotBlank
    private String name;
    private String description;
    @NotEmpty
    private List<Huquq> huquqList;
}
