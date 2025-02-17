package com.tzq.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tzq.system.mapper.OptionMapper;
import com.tzq.system.domain.Option;
import com.tzq.system.service.IOptionService;

/**
 * 选择题选项Service业务层处理
 * 
 * @author tzq
 * @date 2025-02-11
 */
@Service
public class OptionServiceImpl implements IOptionService 
{
    @Autowired
    private OptionMapper optionMapper;

    /**
     * 查询选择题选项
     * 
     * @param optionId 选择题选项主键
     * @return 选择题选项
     */
    @Override
    public Option selectOptionByOptionId(Long optionId)
    {
        return optionMapper.selectOptionByOptionId(optionId);
    }

    /**
     * 查询选择题选项列表
     * 
     * @param option 选择题选项
     * @return 选择题选项
     */
    @Override
    public List<Option> selectOptionList(Option option)
    {
        return optionMapper.selectOptionList(option);
    }

    /**
     * 新增选择题选项
     * 
     * @param option 选择题选项
     * @return 结果
     */
    @Override
    public int insertOption(Option option)
    {
        return optionMapper.insertOption(option);
    }

    /**
     * 修改选择题选项
     * 
     * @param option 选择题选项
     * @return 结果
     */
    @Override
    public int updateOption(Option option)
    {
        return optionMapper.updateOption(option);
    }

    /**
     * 批量删除选择题选项
     * 
     * @param optionIds 需要删除的选择题选项主键
     * @return 结果
     */
    @Override
    public int deleteOptionByOptionIds(Long[] optionIds)
    {
        return optionMapper.deleteOptionByOptionIds(optionIds);
    }

    /**
     * 删除选择题选项信息
     * 
     * @param optionId 选择题选项主键
     * @return 结果
     */
    @Override
    public int deleteOptionByOptionId(Long optionId)
    {
        return optionMapper.deleteOptionByOptionId(optionId);
    }
}
