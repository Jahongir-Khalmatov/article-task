package lesson7.articletask.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    @NotNull(message = "title bo'sh bolmasin")
    private String title;
    @NotNull(message = "text bo'sh bolmasin")
    private String text;
    private String url;
}
