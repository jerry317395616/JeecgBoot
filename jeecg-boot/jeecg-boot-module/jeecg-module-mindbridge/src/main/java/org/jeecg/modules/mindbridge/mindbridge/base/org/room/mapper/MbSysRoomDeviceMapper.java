package org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper;

import java.util.List;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbSysRoomDevice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 房间/功能位-设备绑定
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
public interface MbSysRoomDeviceMapper extends BaseMapper<MbSysRoomDevice> {

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
   * @return List<MbSysRoomDevice>
   */
	public List<MbSysRoomDevice> selectByMainId(@Param("mainId") String mainId);
}
