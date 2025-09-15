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
 * @Description: 房间功能位
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Schema(description="房间功能位")
@Data
@TableName("mb_org_room_seat")
public class MbOrgRoomSeat implements Serializable {
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
	/**所属房间ID*/
    @Schema(description = "所属房间ID")
    private java.lang.String roomId;
	/**功能位编码*/
	@Excel(name = "功能位编码", width = 15)
    @Schema(description = "功能位编码")
    private java.lang.String seatCode;
	/**功能位名称*/
	@Excel(name = "功能位名称", width = 15)
    @Schema(description = "功能位名称")
    private java.lang.String seatName;
	/**功能位类型*/
	@Excel(name = "功能位类型", width = 15, dicCode = "MB_SEAT_TYPE_CODE")
    @Schema(description = "功能位类型")
    private java.lang.String seatTypeCode;
	/**位级并发容量*/
	@Excel(name = "位级并发容量", width = 15)
    @Schema(description = "位级并发容量")
    private java.lang.Integer capacity;
	/**平面图X坐标*/
	@Excel(name = "平面图X坐标", width = 15)
    @Schema(description = "平面图X坐标")
    private java.math.BigDecimal posX;
	/**平面图Y坐标*/
	@Excel(name = "平面图Y坐标", width = 15)
    @Schema(description = "平面图Y坐标")
    private java.math.BigDecimal posY;
	/**允许预约的项目CODE白名单*/
	@Excel(name = "允许预约的项目CODE白名单", width = 15)
    @Schema(description = "允许预约的项目CODE白名单")
    private java.lang.String allowProjects;
	/**扩展属性JSON*/
	@Excel(name = "扩展属性JSON", width = 15)
    @Schema(description = "扩展属性JSON")
    private java.lang.String extraJson;
	/**启用标记*/
    @Excel(name = "启用标记", width = 15,replace = {"是_1","否_2"} )
    @Schema(description = "启用标记")
    private java.lang.Integer enabled;
}
