package com.tzq.easystudy.controller;

import com.tzq.common.annotation.Log;
import com.tzq.common.core.controller.BaseController;
import com.tzq.common.core.domain.AjaxResult;
import com.tzq.common.core.page.TableDataInfo;
import com.tzq.common.enums.BusinessType;
import com.tzq.common.utils.poi.ExcelUtil;
import com.tzq.easystudy.domain.Homework;
import com.tzq.easystudy.service.IHomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 作业Controller
 * 
 * @author tzq
 * @date 2025-02-07
 */
@RestController
@RequestMapping("/easystudy/homework")
public class HomeworkController extends BaseController
{
    @Autowired
    private IHomeworkService homeworkService;

    /**
     * 查询作业列表
     */
    @PreAuthorize("@ss.hasPermi('easystudy:homework:list')")
    @GetMapping("/list")
    public TableDataInfo list(Homework homework)
    {
        startPage();
        List<Homework> list = homeworkService.selectHomeworkList(homework);
        return getDataTable(list);
    }

    /**
     * 导出作业列表
     */
    @PreAuthorize("@ss.hasPermi('easystudy:homework:export')")
    @Log(title = "作业", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Homework homework)
    {
        List<Homework> list = homeworkService.selectHomeworkList(homework);
        ExcelUtil<Homework> util = new ExcelUtil<Homework>(Homework.class);
        util.exportExcel(response, list, "作业数据");
    }

    /**
     * 获取作业详细信息
     */
    @PreAuthorize("@ss.hasPermi('easystudy:homework:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(homeworkService.selectHomeworkById(id));
    }

    /**
     * 新增作业
     */
    @PreAuthorize("@ss.hasPermi('easystudy:homework:add')")
    @Log(title = "作业", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Homework homework)
    {
        return toAjax(homeworkService.insertHomework(homework));
    }

    /**
     * 修改作业
     */
    @PreAuthorize("@ss.hasPermi('easystudy:homework:edit')")
    @Log(title = "作业", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Homework homework)
    {
        return toAjax(homeworkService.updateHomework(homework));
    }

    /**
     * 删除作业
     */
    @PreAuthorize("@ss.hasPermi('easystudy:homework:remove')")
    @Log(title = "作业", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(homeworkService.deleteHomeworkByIds(ids));
    }
}
