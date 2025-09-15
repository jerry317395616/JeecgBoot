package org.jeecg.modules.mindbridge.mindbridge.base.org.room.service;

import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomFile;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 房间附件
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
public interface IMbOrgRoomFileService extends IService<MbOrgRoomFile> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<MbOrgRoomFile>
	 */
	public List<MbOrgRoomFile> selectByMainId(String mainId);
}
