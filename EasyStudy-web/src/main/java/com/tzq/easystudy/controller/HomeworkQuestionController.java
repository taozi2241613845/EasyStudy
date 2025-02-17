package com.tzq.easystudy.controller;

import com.tzq.common.core.controller.BaseController;
import com.tzq.common.core.domain.AjaxResult;
import com.tzq.common.core.page.TableDataInfo;
import com.tzq.easystudy.param.HomeworkQuestionParam;
import com.tzq.easystudy.service.IHomeworkQuestionService;
import com.tzq.easystudy.vo.HomeworkQuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/easytudy/homeworkQuestion")
public class HomeworkQuestionController extends BaseController {

    @Autowired
    IHomeworkQuestionService homeworkQuestionService;

    /**
     * 查询题目列表
     */
    @GetMapping("list/{homeworkId}")
    public TableDataInfo listHomeworkQuestion(@PathVariable("homeworkId") Long homeworkId)
    {
        startPage();
        List<HomeworkQuestionVo> list = homeworkQuestionService.selectHomeworkQuestion(homeworkId);
        return getDataTable(list);
    }

    @PostMapping
    public AjaxResult add(@RequestBody HomeworkQuestionParam homeWorkQuestionParam){
        return toAjax(homeworkQuestionService.add(homeWorkQuestionParam));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody HomeworkQuestionParam homeworkQuestion){
        return toAjax(homeworkQuestionService.edit(homeworkQuestion));
    }

    @DeleteMapping("{ids}")
    public AjaxResult delete(@PathVariable("ids")List<Long> ids){
        return toAjax(homeworkQuestionService.removeBatchByIds(ids));
    }

    
}
