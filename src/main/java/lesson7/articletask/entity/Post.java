package lesson7.articletask.entity;

import lesson7.articletask.entity.template.AbstractEntity;
import lesson7.articletask.payload.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Post extends AbstractEntity {
    @Column(nullable = false,columnDefinition = "text")
    private String title;
    @Column(nullable = false,columnDefinition = "text")
    private String text;
    @Column(nullable = false,columnDefinition = "text")
    private String url;



}
