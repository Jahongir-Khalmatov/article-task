package lesson7.articletask.entity;

import lesson7.articletask.entity.enums.Huquq;
import lesson7.articletask.entity.template.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Lavozim extends AbstractEntity {
    @Column(unique = true,nullable = false)
    private String name;
    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private List<Huquq> huquqList;
    @Column(columnDefinition = "text")
    private String description;
}
