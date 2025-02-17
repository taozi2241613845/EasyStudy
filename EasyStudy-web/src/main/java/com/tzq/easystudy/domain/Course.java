package com.tzq.easystudy.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tzq.common.annotation.Excel;
import com.tzq.common.core.domain.BaseEntity;

/**
 * 课程对象 course
 * 
 * @author tzq
 * @date 2025-02-02
 */
public class Course extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程id */
    private Long id;

    /** 课程名称 */
    @Excel(name = "课程名称")
    private String name;

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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .toString();
    }
}
