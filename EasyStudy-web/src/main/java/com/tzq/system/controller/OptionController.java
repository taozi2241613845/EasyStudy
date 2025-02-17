package com.tzq.system.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.tzq.common.annotation.Log;
import com.tzq.common.core.controller.BaseController;
import com.tzq.common.core.domain.AjaxResult;
import com.tzq.common.enums.BusinessType;
import com.tzq.system.domain.Option;
import com.tzq.system.service.IOptionService;
import com.tzq.common.utils.poi.ExcelUtil;
import com.tzq.common.core.page.TableDataInfo;

/**
 * 选择题选项Controller
 * 
 * @author tzq
 * @date 2025-02-11
 */
@RestController
@RequestMapping("/easystudy/option")
public class OptionController extends BaseController
{
    @Autowired
    private IOptionService optionService;

    /**
     * 查询选择题选项列表
     */
    @PreAuthorize("@ss.hasPermi('easystudy:option:list')")
    @GetMapping("/list")
    public TableDataInfo list(Option option)
    {
        startPage();
        List<Option> list = optionService.selectOptionList(option);
        return getDataTable(list);
    }

    /**
     * 导出选择题选项列表
     */
    @PreAuthorize("@ss.hasPermi('easystudy:option:export')")
    @Log(title = "选择题选项", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Option option)
    {
        List<Option> list = optionService.selectOptionList(option);
        ExcelUtil<Option> util = new ExcelUtil<Option>(Option.class);
        util.exportExcel(response, list, "选择题选项数据");
    }

    /**
     * 获取选择题选项详细信息
     */
    @PreAuthorize("@ss.hasPermi('easystudy:option:query')")
    @GetMapping(value = "/{optionId}")
    public AjaxResult getInfo(@PathVariable("optionId") Long optionId)
    {
        return success(optionService.selectOptionByOptionId(optionId));
    }

    /**
     * 新增选择题选项
     */
    @PreAuthorize("@ss.hasPermi('easystudy:option:add')")
    @Log(title = "选择题选项", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Option option)
    {
        return toAjax(optionService.insertOption(option));
    }

    /**
     * 修改选择题选项
     */
    @PreAuthorize("@ss.hasPermi('easystudy:option:edit')")
    @Log(title = "选择题选项", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Option option)
    {
        return toAjax(optionService.updateOption(option));
    }

    /**
     * 删除选择题选项
     */
    @PreAuthorize("@ss.hasPermi('easystudy:option:remove')")
    @Log(title = "选择题选项", businessType = BusinessType.DELETE)
	@DeleteMapping("/{optionIds}")
    public AjaxResult remove(@PathVariable Long[] optionIds)
    {
        return toAjax(optionService.deleteOptionByOptionIds(optionIds));
    }
}
