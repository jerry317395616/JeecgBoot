package org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper;

import java.util.List;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 房间-项目白名单
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
public interface MbOrgRoomProjectMapper extends BaseMapper<MbOrgRoomProject> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<MbOrgRoomProject>
   */
	public List<MbOrgRoomProject> selectByMainId(@Param("mainId") String mainId);
}
