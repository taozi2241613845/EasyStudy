package com.tzq.easystudy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HomeworkQuestion {
    private Long id;
    private Long homeworkId;
    private Long questionId;
    private Integer no;
    private Integer score;
}
