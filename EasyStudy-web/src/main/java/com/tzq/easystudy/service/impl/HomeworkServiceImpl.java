package com.tzq.easystudy.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tzq.easystudy.mapper.HomeworkMapper;
import com.tzq.easystudy.domain.Homework;
import com.tzq.easystudy.service.IHomeworkService;

/**
 * 作业Service业务层处理
 * 
 * @author tzq
 * @date 2025-02-07
 */
@Service
public class HomeworkServiceImpl implements IHomeworkService 
{
    @Autowired
    private HomeworkMapper homeworkMapper;

    /**
     * 查询作业
     * 
     * @param id 作业主键
     * @return 作业
     */
    @Override
    public Homework selectHomeworkById(Long id)
    {
        return homeworkMapper.selectHomeworkById(id);
    }

    /**
     * 查询作业列表
     * 
     * @param homework 作业
     * @return 作业
     */
    @Override
    public List<Homework> selectHomeworkList(Homework homework)
    {
        return homeworkMapper.selectHomeworkList(homework);
    }

    /**
     * 新增作业
     * 
     * @param homework 作业
     * @return 结果
     */
    @Override
    public int insertHomework(Homework homework)
    {
        return homeworkMapper.insertHomework(homework);
    }

    /**
     * 修改作业
     * 
     * @param homework 作业
     * @return 结果
     */
    @Override
    public int updateHomework(Homework homework)
    {
        return homeworkMapper.updateHomework(homework);
    }

    /**
     * 批量删除作业
     * 
     * @param ids 需要删除的作业主键
     * @return 结果
     */
    @Override
    public int deleteHomeworkByIds(Long[] ids)
    {
        return homeworkMapper.deleteHomeworkByIds(ids);
    }

    /**
     * 删除作业信息
     * 
     * @param id 作业主键
     * @return 结果
     */
    @Override
    public int deleteHomeworkById(Long id)
    {
        return homeworkMapper.deleteHomeworkById(id);
    }
}
