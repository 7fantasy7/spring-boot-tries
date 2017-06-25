package by.botyanov.examis.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(of = "id")
@EqualsAndHashCode(of = "id")
public class Answer implements Serializable {

    @Id
    @SequenceGenerator(name = "ansGen", sequenceName = "ansSeq", initialValue = 37, allocationSize = 100)
    @GeneratedValue(generator = "ansGen")
    @JsonView(View.Summary.class)
    private Long id;

    @Column(nullable = false, length = 1500)
    @JsonView(View.Summary.class)
    private String text;

    @Column(nullable = false)
//    @JsonView(View.Full.class)
    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "QUESTION_ID")
    @JsonIgnore
    private Question question;

}
