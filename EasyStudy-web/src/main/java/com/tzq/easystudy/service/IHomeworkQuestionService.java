package com.tzq.easystudy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tzq.easystudy.domain.HomeworkQuestion;
import com.tzq.easystudy.param.HomeworkQuestionParam;
import com.tzq.easystudy.vo.HomeworkQuestionVo;

import java.util.List;

public interface IHomeworkQuestionService extends IService<HomeworkQuestion> {
    List<HomeworkQuestionVo> selectHomeworkQuestion(Long homeworkId);


    int add(HomeworkQuestionParam homeWorkQuestionParam);

    int edit(HomeworkQuestionParam homeworkQuestion);

}
