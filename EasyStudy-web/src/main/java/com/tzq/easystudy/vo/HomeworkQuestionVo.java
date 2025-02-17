package com.tzq.easystudy.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class HomeworkQuestionVo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 题目的序号
     */
    private Integer no;

    /** id */
    private Long id;

    /** 题目的类型：1.单选；2.多选；3.判断；4.填空；5.简答 */
    private Long type;

    private String typeName;

    /** 题干 */
    private String content;

    /** 答案，单选取值为：ABCD；多选题的取值为ABCD的组合（保持升序）；3.判断题：0（错误）、1（正确）；4.填空题和简答题为文本 */
    private String answer;

    /** 难度，取值为1-3，3是最高难度 */
    private Long difficulty;
}
