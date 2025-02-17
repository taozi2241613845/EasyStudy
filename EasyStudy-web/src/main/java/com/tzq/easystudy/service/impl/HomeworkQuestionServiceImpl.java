package com.tzq.easystudy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tzq.easystudy.domain.HomeworkQuestion;
import com.tzq.easystudy.mapper.HomeworkQuestionMapper;
import com.tzq.easystudy.mapper.QuestionMapper;
import com.tzq.easystudy.param.HomeworkQuestionParam;
import com.tzq.easystudy.service.IHomeworkQuestionService;
import com.tzq.easystudy.vo.HomeworkQuestionVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomeworkQuestionServiceImpl extends ServiceImpl<HomeworkQuestionMapper, HomeworkQuestion> implements IHomeworkQuestionService {
    @Resource
    HomeworkQuestionMapper homeworkQuestionMapper;

    @Resource
    QuestionMapper questionMapper;

    @Override
    public List<HomeworkQuestionVo> selectHomeworkQuestion(Long homeworkId) {
        return homeworkQuestionMapper.selectHomeworkQuestion(homeworkId);
    }

    @Override
    public int add(HomeworkQuestionParam homeWorkQuestionParam) {
        int count = 0;
        HomeworkQuestion homeworkQuestion = new HomeworkQuestion();
        homeworkQuestion.setHomeworkId(homeWorkQuestionParam.getHomeworkQuestion().getHomeworkId());
        homeworkQuestion.setQuestionId(homeWorkQuestionParam.getQuestion().getId());
        count += homeworkQuestionMapper.insert(homeworkQuestion);
        count += questionMapper.insertQuestion(homeWorkQuestionParam.getQuestion());
        return count;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int edit(HomeworkQuestionParam homeworkQuestion) {
        int count = 0;
        count += updateById(homeworkQuestion.getHomeworkQuestion()) ? 1:0;
        count += questionMapper.updateQuestion(homeworkQuestion.getQuestion());
        return count;
    }

}
