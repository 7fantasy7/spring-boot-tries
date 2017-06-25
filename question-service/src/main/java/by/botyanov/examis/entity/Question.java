package by.botyanov.examis.entity;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class Question implements Serializable {

    @Id
    @SequenceGenerator(name = "queGen", sequenceName = "queSeq", initialValue = 10, allocationSize = 100)
    @GeneratedValue(generator = "queGen")
    @JsonView(View.Summary.class)
    private Long id;

    @Column(nullable = false, length = 1500)
    @JsonView(View.Summary.class)
    private String text;

    @Column(nullable = false, length = 1500)
    @JsonView(View.Summary.class)
    private String description;

    @OneToMany
    @JoinColumn(name = "QUESTION_ID", referencedColumnName = "ID")
    @JsonView(View.Summary.class)
    private Set<Answer> answers;

}
