package com.tzq.easystudy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tzq.easystudy.domain.HomeworkQuestion;
import com.tzq.easystudy.vo.HomeworkQuestionVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeworkQuestionMapper extends BaseMapper<HomeworkQuestion> {
    List<HomeworkQuestionVo> selectHomeworkQuestion(Long homeworkId);
}
