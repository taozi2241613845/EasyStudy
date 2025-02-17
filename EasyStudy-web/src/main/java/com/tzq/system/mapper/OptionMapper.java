package com.tzq.system.mapper;

import java.util.List;
import com.tzq.system.domain.Option;

/**
 * 选择题选项Mapper接口
 * 
 * @author tzq
 * @date 2025-02-11
 */
public interface OptionMapper 
{
    /**
     * 查询选择题选项
     * 
     * @param optionId 选择题选项主键
     * @return 选择题选项
     */
    public Option selectOptionByOptionId(Long optionId);

    /**
     * 查询选择题选项列表
     * 
     * @param option 选择题选项
     * @return 选择题选项集合
     */
    public List<Option> selectOptionList(Option option);

    /**
     * 新增选择题选项
     * 
     * @param option 选择题选项
     * @return 结果
     */
    public int insertOption(Option option);

    /**
     * 修改选择题选项
     * 
     * @param option 选择题选项
     * @return 结果
     */
    public int updateOption(Option option);

    /**
     * 删除选择题选项
     * 
     * @param optionId 选择题选项主键
     * @return 结果
     */
    public int deleteOptionByOptionId(Long optionId);

    /**
     * 批量删除选择题选项
     * 
     * @param optionIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOptionByOptionIds(Long[] optionIds);
}
