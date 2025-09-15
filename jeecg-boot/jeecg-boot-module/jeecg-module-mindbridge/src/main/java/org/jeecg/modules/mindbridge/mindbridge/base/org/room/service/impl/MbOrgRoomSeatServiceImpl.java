package org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.impl;

import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomSeat;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper.MbOrgRoomSeatMapper;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.IMbOrgRoomSeatService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 房间功能位
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Service
public class MbOrgRoomSeatServiceImpl extends ServiceImpl<MbOrgRoomSeatMapper, MbOrgRoomSeat> implements IMbOrgRoomSeatService {
	
	@Autowired
	private MbOrgRoomSeatMapper mbOrgRoomSeatMapper;
	
	@Override
	public List<MbOrgRoomSeat> selectByMainId(String mainId) {
		return mbOrgRoomSeatMapper.selectByMainId(mainId);
	}
}
