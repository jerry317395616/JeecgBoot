package org.jeecg.modules.mindbridge.mindbridge.base.org.room.service;

import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomSeat;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 房间功能位
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
public interface IMbOrgRoomSeatService extends IService<MbOrgRoomSeat> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<MbOrgRoomSeat>
	 */
	public List<MbOrgRoomSeat> selectByMainId(String mainId);
}
