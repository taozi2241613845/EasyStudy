package com.tzq.easystudy.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tzq.common.annotation.Excel;
import com.tzq.common.core.domain.BaseEntity;

/**
 * 题目对象 question
 * 
 * @author ruoyi
 * @date 2025-02-02
 */
public class Question extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 题目的类型：1.单选；2.多选；3.判断；4.填空；5.简答 */
    @Excel(name = "题目的类型：1.单选；2.多选；3.判断；4.填空；5.简答")
    private Long type;

    /** 题干 */
    @Excel(name = "题干")
    private String content;

    /** 答案，单选取值为：ABCD；多选题的取值为ABCD的组合（保持升序）；3.判断题：0（错误）、1（正确）；4.填空题和简答题为文本 */
    @Excel(name = "答案，单选取值为：ABCD；多选题的取值为ABCD的组合", readConverterExp = "保=持升序")
    private String answer;

    /** 难度，取值为1-3，3是最高难度 */
    @Excel(name = "难度，取值为1-3，3是最高难度")
    private Long difficulty;

    /** 题目对应的课程id */
    @Excel(name = "题目对应的课程id")
    private Long courseId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setType(Long type) 
    {
        this.type = type;
    }

    public Long getType() 
    {
        return type;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setAnswer(String answer) 
    {
        this.answer = answer;
    }

    public String getAnswer() 
    {
        return answer;
    }
    public void setDifficulty(Long difficulty) 
    {
        this.difficulty = difficulty;
    }

    public Long getDifficulty() 
    {
        return difficulty;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("type", getType())
            .append("content", getContent())
            .append("answer", getAnswer())
            .append("difficulty", getDifficulty())
            .append("courseId", getCourseId())
            .toString();
    }
}
