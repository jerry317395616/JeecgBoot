package org.jeecg.modules.mindbridge.mindbridge.base.org.room.service;

import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomSeat;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomProject;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomFile;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbSysRoomDevice;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoom;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 房间主数据
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
public interface IMbOrgRoomService extends IService<MbOrgRoom> {

	/**
	 * 添加一对多
	 *
	 * @param mbOrgRoom
	 * @param mbOrgRoomSeatList
	 * @param mbOrgRoomProjectList
	 * @param mbOrgRoomFileList
	 * @param mbSysRoomDeviceList
	 */
	public void saveMain(MbOrgRoom mbOrgRoom,List<MbOrgRoomSeat> mbOrgRoomSeatList,List<MbOrgRoomProject> mbOrgRoomProjectList,List<MbOrgRoomFile> mbOrgRoomFileList,List<MbSysRoomDevice> mbSysRoomDeviceList) ;
	
	/**
	 * 修改一对多
	 *
   * @param mbOrgRoom
   * @param mbOrgRoomSeatList
   * @param mbOrgRoomProjectList
   * @param mbOrgRoomFileList
   * @param mbSysRoomDeviceList
	 */
	public void updateMain(MbOrgRoom mbOrgRoom,List<MbOrgRoomSeat> mbOrgRoomSeatList,List<MbOrgRoomProject> mbOrgRoomProjectList,List<MbOrgRoomFile> mbOrgRoomFileList,List<MbSysRoomDevice> mbSysRoomDeviceList);
	
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);
	
}
