package org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.impl;

import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbSysRoomDevice;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper.MbSysRoomDeviceMapper;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.IMbSysRoomDeviceService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 房间/功能位-设备绑定
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Service
public class MbSysRoomDeviceServiceImpl extends ServiceImpl<MbSysRoomDeviceMapper, MbSysRoomDevice> implements IMbSysRoomDeviceService {
	
	@Autowired
	private MbSysRoomDeviceMapper mbSysRoomDeviceMapper;
	
	@Override
	public List<MbSysRoomDevice> selectByMainId(String mainId) {
		return mbSysRoomDeviceMapper.selectByMainId(mainId);
	}
}
