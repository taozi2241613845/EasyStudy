package com.tzq.easystudy.domain;

import com.tzq.common.annotation.Excel;
import com.tzq.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 文件信息对象 sys_file_info
 * 
 * @author tzq
 * @date 2025-02-06
 */
@Data
@NoArgsConstructor
public class SysFileInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 文件id */
    private Long fileId;

    /** 文件名称 */
    @Excel(name = "文件名称")
    private String fileName;

    /** 文件路径 */
    private String filePath;

    /** 创建者 */
    @Excel(name = "创建者")
    private Long createUserId;

    /** 文件大小 */
    @Excel(name = "文件大小")
    private Long fileSize;

    private Integer deleted;

    public SysFileInfo(String fileName, String filePath, Long createUserId, Long fileSize) {
        this.fileName = fileName;
        this.filePath = filePath;
        this.createUserId = createUserId;
        this.fileSize = fileSize;
        this.deleted = 0;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fileId", getFileId())
            .append("fileName", getFileName())
            .append("filePath", getFilePath())
            .append("createUserId", getCreateUserId())
            .append("fileSize", getFileSize())
            .toString();
    }
}
