package com.tzq.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.tzq.common.annotation.Excel;
import com.tzq.common.core.domain.BaseEntity;

/**
 * 选择题选项对象 option
 * 
 * @author tzq
 * @date 2025-02-11
 */
public class Option extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 选项id */
    private Long optionId;

    /** 选项序号 */
    @Excel(name = "选项序号")
    private Long no;

    /** 选项内容 */
    @Excel(name = "选项内容")
    private String content;

    public void setOptionId(Long optionId) 
    {
        this.optionId = optionId;
    }

    public Long getOptionId() 
    {
        return optionId;
    }
    public void setNo(Long no) 
    {
        this.no = no;
    }

    public Long getNo() 
    {
        return no;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("optionId", getOptionId())
            .append("no", getNo())
            .append("content", getContent())
            .toString();
    }
}
