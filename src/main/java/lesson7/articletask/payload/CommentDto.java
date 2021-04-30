package lesson7.articletask.payload;

import lesson7.articletask.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
   @NotNull(message = "text bo'sh bo'lmasin")
    private String text;
   @NotNull(message = "post id bo'sh bo'lmasin")
    private Integer postId;
}
