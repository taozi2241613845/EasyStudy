package com.tzq.easystudy.service;

import java.util.List;
import com.tzq.easystudy.domain.Homework;

/**
 * 作业Service接口
 * 
 * @author tzq
 * @date 2025-02-07
 */
public interface IHomeworkService 
{
    /**
     * 查询作业
     * 
     * @param id 作业主键
     * @return 作业
     */
    public Homework selectHomeworkById(Long id);

    /**
     * 查询作业列表
     * 
     * @param homework 作业
     * @return 作业集合
     */
    public List<Homework> selectHomeworkList(Homework homework);

    /**
     * 新增作业
     * 
     * @param homework 作业
     * @return 结果
     */
    public int insertHomework(Homework homework);

    /**
     * 修改作业
     * 
     * @param homework 作业
     * @return 结果
     */
    public int updateHomework(Homework homework);

    /**
     * 批量删除作业
     * 
     * @param ids 需要删除的作业主键集合
     * @return 结果
     */
    public int deleteHomeworkByIds(Long[] ids);

    /**
     * 删除作业信息
     * 
     * @param id 作业主键
     * @return 结果
     */
    public int deleteHomeworkById(Long id);
}
