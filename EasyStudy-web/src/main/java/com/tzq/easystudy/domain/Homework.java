package com.tzq.easystudy.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.tzq.common.annotation.Excel;
import com.tzq.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 作业对象 homework
 * 
 * @author tzq
 * @date 2025-02-07
 */
public class Homework extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 作业id */
    @Excel(name = "作业id")
    private Long id;

    /** 作业名称 */
    @Excel(name = "作业名称")
    private String name;

    /** 限时（分钟）） */
    @Excel(name = "限时", readConverterExp = "分钟")
    private Integer limitTime;

    /** 满分 */
    @Excel(name = "满分")
    private Integer fullGrade;

    /** 创建者 */
    @Excel(name = "创建者")
    private Long createUserId;

    /** 作业所属课程 */
    @Excel(name = "作业所属课程")
    private Long courseId;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 截止时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "截止时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setLimitTime(Integer limitTime) 
    {
        this.limitTime = limitTime;
    }

    public Integer getLimitTime() 
    {
        return limitTime;
    }
    public void setFullGrade(Integer fullGrade) 
    {
        this.fullGrade = fullGrade;
    }

    public Integer getFullGrade() 
    {
        return fullGrade;
    }
    public void setCreateUserId(Long createUserId) 
    {
        this.createUserId = createUserId;
    }

    public Long getCreateUserId() 
    {
        return createUserId;
    }
    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("limitTime", getLimitTime())
            .append("fullGrade", getFullGrade())
            .append("createUserId", getCreateUserId())
            .append("courseId", getCourseId())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .toString();
    }
}
