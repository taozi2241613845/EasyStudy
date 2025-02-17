package com.tzq.easystudy.controller;

import com.tzq.common.annotation.Log;
import com.tzq.common.core.controller.BaseController;
import com.tzq.common.core.domain.AjaxResult;
import com.tzq.common.core.page.TableDataInfo;
import com.tzq.common.enums.BusinessType;
import com.tzq.common.utils.poi.ExcelUtil;
import com.tzq.easystudy.domain.Course;
import com.tzq.easystudy.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 课程Controller
 * 
 * @author tzq
 * @date 2025-02-02
 */
@RestController
@RequestMapping("/easystudy/course")
public class CourseController extends BaseController
{
    @Autowired
    private ICourseService courseService;

    /**
     * 查询课程列表
     */
    @PreAuthorize("@ss.hasPermi('easystudy:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(Course course)
    {
        startPage();
        List<Course> list = courseService.selectCourseList(course);
        return getDataTable(list);
    }

    /**
     * 查询课程列表，不分页
     */
    @PreAuthorize("@ss.hasPermi('easystudy:course:list')")
    @GetMapping("/list/all")
    public AjaxResult listAll()
    {
        return AjaxResult.success(courseService.selectCourseList(new Course()));
    }


    /**
     * 导出课程列表
     */
    @PreAuthorize("@ss.hasPermi('easystudy:course:export')")
    @Log(title = "课程", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Course course)
    {
        List<Course> list = courseService.selectCourseList(course);
        ExcelUtil<Course> util = new ExcelUtil<Course>(Course.class);
        util.exportExcel(response, list, "课程数据");
    }

    /**
     * 获取课程详细信息
     */
    @PreAuthorize("@ss.hasPermi('easystudy:course:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(courseService.selectCourseById(id));
    }

    /**
     * 新增课程
     */
    @PreAuthorize("@ss.hasPermi('easystudy:course:add')")
    @Log(title = "课程", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Course course)
    {
        return toAjax(courseService.insertCourse(course));
    }

    /**
     * 修改课程
     */
    @PreAuthorize("@ss.hasPermi('easystudy:course:edit')")
    @Log(title = "课程", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Course course)
    {
        return toAjax(courseService.updateCourse(course));
    }

    /**
     * 删除课程
     */
    @PreAuthorize("@ss.hasPermi('easystudy:course:remove')")
    @Log(title = "课程", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(courseService.deleteCourseByIds(ids));
    }
}
