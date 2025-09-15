package org.jeecg.modules.mindbridge.mindbridge.base.org.room.vo;

import java.util.List;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoom;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomSeat;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomProject;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomFile;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbSysRoomDevice;
import lombok.Data;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelEntity;
import org.jeecgframework.poi.excel.annotation.ExcelCollection;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;
import org.jeecg.common.aspect.annotation.Dict;
import org.jeecg.common.constant.ProvinceCityArea;
import org.jeecg.common.util.SpringContextUtils;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @Description: 房间主数据
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Data
@Schema(description="房间主数据")
public class MbOrgRoomPage {

	/**主键*/
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
	/**组织树节点*/
	@Excel(name = "组织树节点", width = 15, dictTable = "sys_depart", dicText = "depart_name", dicCode = "id")
    @Dict(dictTable = "sys_depart", dicText = "depart_name", dicCode = "id")
	@Schema(description = "组织树节点")
    private java.lang.String orgNodeId;
	/**房间编码*/
	@Excel(name = "房间编码", width = 15)
	@Schema(description = "房间编码")
    private java.lang.String roomCode;
	/**房间名称*/
	@Excel(name = "房间名称", width = 15)
	@Schema(description = "房间名称")
    private java.lang.String roomName;
	/**房间类型*/
	@Excel(name = "房间类型", width = 15, dicCode = "MB_ROOM_TYPE_CODE")
    @Dict(dicCode = "MB_ROOM_TYPE_CODE")
	@Schema(description = "房间类型")
    private java.lang.String roomTypeCode;
	/**房间级并发容量*/
	@Excel(name = "房间级并发容量", width = 15)
	@Schema(description = "房间级并发容量")
    private java.lang.Integer capacity;
	/**计容模式*/
	@Excel(name = "计容模式", width = 15, dicCode = "MB_SEAT_MODE")
    @Dict(dicCode = "MB_SEAT_MODE")
	@Schema(description = "计容模式")
    private java.lang.String seatMode;
	/**房间面积*/
	@Excel(name = "房间面积", width = 15)
	@Schema(description = "房间面积")
    private java.math.BigDecimal areaM2;
	/**楼栋/楼名*/
	@Excel(name = "楼栋/楼名", width = 15)
	@Schema(description = "楼栋/楼名")
    private java.lang.String building;
	/**楼层编号*/
	@Excel(name = "楼层编号", width = 15)
	@Schema(description = "楼层编号")
    private java.lang.String floorNo;
	/**位置描述*/
	@Excel(name = "位置描述", width = 15)
	@Schema(description = "位置描述")
    private java.lang.String locationDesc;
	/**纬度*/
	@Excel(name = "纬度", width = 15)
	@Schema(description = "纬度")
    private java.math.BigDecimal geoLat;
	/**经度*/
	@Excel(name = "经度", width = 15)
	@Schema(description = "经度")
    private java.math.BigDecimal geoLon;
	/**开放时段JSON*/
	@Excel(name = "开放时段JSON", width = 15)
	@Schema(description = "开放时段JSON")
    private java.lang.String openingJson;
	/**标签数组JSON*/
	@Excel(name = "标签数组JSON", width = 15)
	@Schema(description = "标签数组JSON")
    private java.lang.String tagsJson;
	/**状态*/
	@Excel(name = "状态", width = 15, dicCode = "MB_STATUS")
    @Dict(dicCode = "MB_STATUS")
	@Schema(description = "状态")
    private java.lang.String status;
	/**扩展属性JSON*/
	@Excel(name = "扩展属性JSON", width = 15)
	@Schema(description = "扩展属性JSON")
    private java.lang.String extraJson;
	/**房间二维码短码/标识*/
	@Excel(name = "房间二维码短码/标识", width = 15)
	@Schema(description = "房间二维码短码/标识")
    private java.lang.String qrCode;

	@ExcelCollection(name="房间功能位")
	@Schema(description = "房间功能位")
	private List<MbOrgRoomSeat> mbOrgRoomSeatList;
	@ExcelCollection(name="房间-项目白名单")
	@Schema(description = "房间-项目白名单")
	private List<MbOrgRoomProject> mbOrgRoomProjectList;
	@ExcelCollection(name="房间附件")
	@Schema(description = "房间附件")
	private List<MbOrgRoomFile> mbOrgRoomFileList;
	@ExcelCollection(name="房间/功能位-设备绑定")
	@Schema(description = "房间/功能位-设备绑定")
	private List<MbSysRoomDevice> mbSysRoomDeviceList;

}
