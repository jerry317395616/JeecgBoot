package org.jeecg.modules.mindbridge.mindbridge.base.org.room.service;

import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbSysRoomDevice;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 房间/功能位-设备绑定
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
public interface IMbSysRoomDeviceService extends IService<MbSysRoomDevice> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<MbSysRoomDevice>
	 */
	public List<MbSysRoomDevice> selectByMainId(String mainId);
}
