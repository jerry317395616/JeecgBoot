package org.jeecg.modules.mindbridge.mindbridge.base.device.type.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
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
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 设备类型
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Data
@TableName("mb_sys_device_type")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@Schema(description="设备类型")
public class MbSysDeviceType implements Serializable {
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
	/**类型编码*/
	@Excel(name = "类型编码", width = 15)
    @Schema(description = "类型编码")
    private java.lang.String code;
	/**类型名称*/
	@Excel(name = "类型名称", width = 15)
    @Schema(description = "类型名称")
    private java.lang.String name;
	/**类别*/
	@Excel(name = "类别", width = 15, dicCode = "MB_SYS_DEVICE_TYPE_CATEGORY")
	@Dict(dicCode = "MB_SYS_DEVICE_TYPE_CATEGORY")
    @Schema(description = "类别")
    private java.lang.String category;
	/**支持的信号/数据通道*/
	@Excel(name = "支持的信号/数据通道", width = 15)
    @Schema(description = "支持的信号/数据通道")
    private java.lang.String signalsJson;
	/**接口能力*/
	@Excel(name = "接口能力", width = 15)
    @Schema(description = "接口能力")
    private java.lang.String ifaceJson;
	/**是否支持远程控制*/
    @Excel(name = "是否支持远程控制", width = 15,replace = {"是_1","否_0"} )
    @Schema(description = "是否支持远程控制")
    private java.lang.Integer remoteCtrl;
	/**安全边界默认值*/
	@Excel(name = "安全边界默认值", width = 15)
    @Schema(description = "安全边界默认值")
    private java.lang.String safetyJson;
	/**扩展属性*/
	@Excel(name = "扩展属性", width = 15)
    @Schema(description = "扩展属性")
    private java.lang.String extraJson;
	/**状态*/
    @Excel(name = "状态", width = 15,replace = {"是_ACTIVE","否_DISABLED"} )
    @Schema(description = "状态")
    private java.lang.String status;
}
