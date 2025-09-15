package org.jeecg.modules.mindbridge.mindbridge.base.org.room.service;

import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomProject;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 房间-项目白名单
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
public interface IMbOrgRoomProjectService extends IService<MbOrgRoomProject> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<MbOrgRoomProject>
	 */
	public List<MbOrgRoomProject> selectByMainId(String mainId);
}
