package org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.impl;

import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoom;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomSeat;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomProject;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomFile;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbSysRoomDevice;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper.MbOrgRoomSeatMapper;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper.MbOrgRoomProjectMapper;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper.MbOrgRoomFileMapper;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper.MbSysRoomDeviceMapper;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper.MbOrgRoomMapper;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.IMbOrgRoomService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import java.io.Serializable;
import java.util.List;
import java.util.Collection;

/**
 * @Description: 房间主数据
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Service
public class MbOrgRoomServiceImpl extends ServiceImpl<MbOrgRoomMapper, MbOrgRoom> implements IMbOrgRoomService {

	@Autowired
	private MbOrgRoomMapper mbOrgRoomMapper;
	@Autowired
	private MbOrgRoomSeatMapper mbOrgRoomSeatMapper;
	@Autowired
	private MbOrgRoomProjectMapper mbOrgRoomProjectMapper;
	@Autowired
	private MbOrgRoomFileMapper mbOrgRoomFileMapper;
	@Autowired
	private MbSysRoomDeviceMapper mbSysRoomDeviceMapper;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void saveMain(MbOrgRoom mbOrgRoom, List<MbOrgRoomSeat> mbOrgRoomSeatList,List<MbOrgRoomProject> mbOrgRoomProjectList,List<MbOrgRoomFile> mbOrgRoomFileList,List<MbSysRoomDevice> mbSysRoomDeviceList) {
		mbOrgRoomMapper.insert(mbOrgRoom);
		if(mbOrgRoomSeatList!=null && mbOrgRoomSeatList.size()>0) {
			for(MbOrgRoomSeat entity:mbOrgRoomSeatList) {
				//外键设置
				entity.setRoomId(mbOrgRoom.getId());
				mbOrgRoomSeatMapper.insert(entity);
			}
		}
		if(mbOrgRoomProjectList!=null && mbOrgRoomProjectList.size()>0) {
			for(MbOrgRoomProject entity:mbOrgRoomProjectList) {
				//外键设置
				entity.setRoomId(mbOrgRoom.getId());
				mbOrgRoomProjectMapper.insert(entity);
			}
		}
		if(mbOrgRoomFileList!=null && mbOrgRoomFileList.size()>0) {
			for(MbOrgRoomFile entity:mbOrgRoomFileList) {
				//外键设置
				entity.setRoomId(mbOrgRoom.getId());
				mbOrgRoomFileMapper.insert(entity);
			}
		}
		if(mbSysRoomDeviceList!=null && mbSysRoomDeviceList.size()>0) {
			for(MbSysRoomDevice entity:mbSysRoomDeviceList) {
				//外键设置
				entity.setRoomId(mbOrgRoom.getId());
				mbSysRoomDeviceMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateMain(MbOrgRoom mbOrgRoom,List<MbOrgRoomSeat> mbOrgRoomSeatList,List<MbOrgRoomProject> mbOrgRoomProjectList,List<MbOrgRoomFile> mbOrgRoomFileList,List<MbSysRoomDevice> mbSysRoomDeviceList) {
		mbOrgRoomMapper.updateById(mbOrgRoom);
		
		//1.先删除子表数据
		mbOrgRoomSeatMapper.deleteByMainId(mbOrgRoom.getId());
		mbOrgRoomProjectMapper.deleteByMainId(mbOrgRoom.getId());
		mbOrgRoomFileMapper.deleteByMainId(mbOrgRoom.getId());
		mbSysRoomDeviceMapper.deleteByMainId(mbOrgRoom.getId());
		
		//2.子表数据重新插入
		if(mbOrgRoomSeatList!=null && mbOrgRoomSeatList.size()>0) {
			for(MbOrgRoomSeat entity:mbOrgRoomSeatList) {
				//外键设置
				entity.setRoomId(mbOrgRoom.getId());
				mbOrgRoomSeatMapper.insert(entity);
			}
		}
		if(mbOrgRoomProjectList!=null && mbOrgRoomProjectList.size()>0) {
			for(MbOrgRoomProject entity:mbOrgRoomProjectList) {
				//外键设置
				entity.setRoomId(mbOrgRoom.getId());
				mbOrgRoomProjectMapper.insert(entity);
			}
		}
		if(mbOrgRoomFileList!=null && mbOrgRoomFileList.size()>0) {
			for(MbOrgRoomFile entity:mbOrgRoomFileList) {
				//外键设置
				entity.setRoomId(mbOrgRoom.getId());
				mbOrgRoomFileMapper.insert(entity);
			}
		}
		if(mbSysRoomDeviceList!=null && mbSysRoomDeviceList.size()>0) {
			for(MbSysRoomDevice entity:mbSysRoomDeviceList) {
				//外键设置
				entity.setRoomId(mbOrgRoom.getId());
				mbSysRoomDeviceMapper.insert(entity);
			}
		}
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delMain(String id) {
		mbOrgRoomSeatMapper.deleteByMainId(id);
		mbOrgRoomProjectMapper.deleteByMainId(id);
		mbOrgRoomFileMapper.deleteByMainId(id);
		mbSysRoomDeviceMapper.deleteByMainId(id);
		mbOrgRoomMapper.deleteById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void delBatchMain(Collection<? extends Serializable> idList) {
		for(Serializable id:idList) {
			mbOrgRoomSeatMapper.deleteByMainId(id.toString());
			mbOrgRoomProjectMapper.deleteByMainId(id.toString());
			mbOrgRoomFileMapper.deleteByMainId(id.toString());
			mbSysRoomDeviceMapper.deleteByMainId(id.toString());
			mbOrgRoomMapper.deleteById(id);
		}
	}
	
}
