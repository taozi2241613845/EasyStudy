package com.tzq.easystudy.controller;

import com.tzq.common.annotation.Log;
import com.tzq.common.core.controller.BaseController;
import com.tzq.common.core.domain.AjaxResult;
import com.tzq.common.core.page.TableDataInfo;
import com.tzq.common.enums.BusinessType;
import com.tzq.easystudy.domain.SysFileInfo;
import com.tzq.easystudy.service.ISysFileInfoService;
import com.tzq.easystudy.vo.SysFileInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 文件信息Controller
 * 
 * @author tzq
 * @date 2025-02-06
 */
@RestController
@RequestMapping("/easystudy/fileInfo")
public class SysFileInfoController extends BaseController
{
    @Autowired
    private ISysFileInfoService sysFileInfoService;

    @Value("${ruoyi.profile}")
    private String UPLOAD_DIR;

    /**
     * 添加文件
     */
    @PostMapping()
    public AjaxResult add(@RequestBody SysFileInfo fileInfo)
    {
        sysFileInfoService.insertSysFileInfo(fileInfo);
        return AjaxResult.success("文件上传成功: " + fileInfo.getFileName());
    }

    /**
     * 查询文件信息列表
     */
    @PreAuthorize("@ss.hasPermi('easystudy:fileInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysFileInfo sysFileInfo)
    {
        startPage();
        List<SysFileInfoVo> list = sysFileInfoService.selectSysFileInfoList(sysFileInfo);
        return getDataTable(list);
    }

    /**
     * 删除文件信息
     */
    @PreAuthorize("@ss.hasPermi('easystudy:fileInfo:remove')")
    @Log(title = "文件信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fileIds}")
    public AjaxResult remove(@PathVariable Long[] fileIds)
    {
        return toAjax(sysFileInfoService.deleteSysFileInfoByFileIds(fileIds));
    }
}
