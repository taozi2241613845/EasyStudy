package com.tzq.easystudy.controller;

import com.tzq.common.annotation.Log;
import com.tzq.common.core.controller.BaseController;
import com.tzq.common.core.domain.AjaxResult;
import com.tzq.common.core.page.TableDataInfo;
import com.tzq.common.enums.BusinessType;
import com.tzq.common.utils.poi.ExcelUtil;
import com.tzq.easystudy.domain.Question;
import com.tzq.easystudy.service.IQuestionService;
import com.tzq.easystudy.util.QuestionTypeMap;
import com.tzq.easystudy.vo.QuestionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 题目Controller
 * 
 * @author ruoyi
 * @date 2025-02-02
 */
@RestController
@RequestMapping("/easystudy/question")
public class QuestionController extends BaseController
{
    @Autowired
    private IQuestionService questionService;

    /**
     * 查询题目列表
     */
    @PreAuthorize("@ss.hasPermi('easystudy:question:list')")
    @GetMapping("/list")
    public TableDataInfo listVo(Question question)
    {
        startPage();
        List<QuestionVo> list = questionService.selectQuestionVoList(question);
        list.stream().forEach((item)->{
            String typeName = QuestionTypeMap.getTypeNameByType(item.getType());
            item.setTypeName(typeName);
        });
        return getDataTable(list);
    }


    /**
     * 导出题目列表
     */
    @PreAuthorize("@ss.hasPermi('easystudy:question:export')")
    @Log(title = "题目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Question question)
    {
        List<Question> list = questionService.selectQuestionList(question);
        ExcelUtil<Question> util = new ExcelUtil<Question>(Question.class);
        util.exportExcel(response, list, "题目数据");
    }

    /**
     * 获取题目详细信息
     */
    @PreAuthorize("@ss.hasPermi('easystudy:question:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(questionService.selectQuestionById(id));
    }

    /**
     * 新增题目
     */
    @PreAuthorize("@ss.hasPermi('easystudy:question:add')")
    @Log(title = "题目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Question question)
    {
        return toAjax(questionService.insertQuestion(question));
    }


    /**
     * 修改题目
     */
    @PreAuthorize("@ss.hasPermi('easystudy:question:edit')")
    @Log(title = "题目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Question question)
    {
        return toAjax(questionService.updateQuestion(question));
    }

    /**
     * 删除题目
     */
    @PreAuthorize("@ss.hasPermi('easystudy:question:remove')")
    @Log(title = "题目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(questionService.deleteQuestionByIds(ids));
    }
}
