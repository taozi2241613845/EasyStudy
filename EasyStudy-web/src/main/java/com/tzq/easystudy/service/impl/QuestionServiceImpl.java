package com.tzq.easystudy.service.impl;

import com.tzq.easystudy.domain.Question;
import com.tzq.easystudy.mapper.QuestionMapper;
import com.tzq.easystudy.service.IQuestionService;
import com.tzq.easystudy.vo.HomeworkQuestionVo;
import com.tzq.easystudy.vo.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 题目Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-02-02
 */
@Service
public class QuestionServiceImpl implements IQuestionService 
{
    @Autowired
    private QuestionMapper questionMapper;

    /**
     * 查询题目
     * 
     * @param id 题目主键
     * @return 题目
     */
    @Override
    public Question selectQuestionById(Long id)
    {
        return questionMapper.selectQuestionById(id);
    }

    /**
     * 查询题目列表
     *
     * @param question 题目
     * @return 题目
     */
    @Override
    public List<QuestionVo> selectQuestionVoList(Question question)
    {
        return questionMapper.selectQuestionVoList(question);
    }

    @Override
    public List<Question> selectQuestionList(Question question)
    {
        return questionMapper.selectQuestionList(question);
    }

    /**
     * 新增题目
     * 
     * @param question 题目
     * @return 结果
     */
    @Override
    public int insertQuestion(Question question)
    {
        return questionMapper.insertQuestion(question);
    }

    /**
     * 修改题目
     * 
     * @param question 题目
     * @return 结果
     */
    @Override
    public int updateQuestion(Question question)
    {
        return questionMapper.updateQuestion(question);
    }

    /**
     * 批量删除题目
     * 
     * @param ids 需要删除的题目主键
     * @return 结果
     */
    @Override
    public int deleteQuestionByIds(Long[] ids)
    {
        return questionMapper.deleteQuestionByIds(ids);
    }

    /**
     * 删除题目信息
     * 
     * @param id 题目主键
     * @return 结果
     */
    @Override
    public int deleteQuestionById(Long id)
    {
        return questionMapper.deleteQuestionById(id);
    }

}
