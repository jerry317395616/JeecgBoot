package org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity;

import java.io.Serializable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableLogic;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import java.util.Date;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.UnsupportedEncodingException;

/**
 * @Description: 房间附件
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Schema(description="房间附件")
@Data
@TableName("mb_org_room_file")
public class MbOrgRoomFile implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @Schema(description = "主键")
    private java.lang.String id;
	/**创建人*/
    @Schema(description = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @Schema(description = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Schema(description = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @Schema(description = "所属部门")
    private java.lang.String sysOrgCode;
	/**房间ID*/
    @Schema(description = "房间ID")
    private java.lang.String roomId;
	/**文件类型*/
	@Excel(name = "文件类型", width = 15, dicCode = "MB_FILE_TYPE")
    @Schema(description = "文件类型")
    private java.lang.String fileType;
	/**文件/对象存储ID*/
	@Excel(name = "文件/对象存储ID", width = 15)
    @Schema(description = "文件/对象存储ID")
    private java.lang.String fileId;
	/**附件元数据JSON*/
	@Excel(name = "附件元数据JSON", width = 15)
    @Schema(description = "附件元数据JSON")
    private java.lang.String metaJson;
}
