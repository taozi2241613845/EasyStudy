package com.tzq.easystudy.param;

import com.tzq.easystudy.domain.HomeworkQuestion;
import com.tzq.easystudy.domain.Question;
import lombok.Data;

import java.io.Serializable;

@Data
public class HomeworkQuestionParam implements Serializable {
    private static final long serialVersionUID = 1L;
    private HomeworkQuestion homeworkQuestion;
    private Question question;
}
