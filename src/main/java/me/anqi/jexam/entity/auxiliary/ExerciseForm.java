package me.anqi.jexam.entity.auxiliary;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ExerciseForm {

    @NotEmpty
    private String title;
    private String content;
    private long subjectId;
    @NotEmpty
    private String type;
    @Min(1)
    private int score;
    private String A;
    private String B;
    private String C;
    private String D;
    private String remark;
    private long paperId;

    public ExerciseForm() {
    }
}
