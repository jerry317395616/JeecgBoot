package org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.impl;

import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomFile;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper.MbOrgRoomFileMapper;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.IMbOrgRoomFileService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 房间附件
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Service
public class MbOrgRoomFileServiceImpl extends ServiceImpl<MbOrgRoomFileMapper, MbOrgRoomFile> implements IMbOrgRoomFileService {
	
	@Autowired
	private MbOrgRoomFileMapper mbOrgRoomFileMapper;
	
	@Override
	public List<MbOrgRoomFile> selectByMainId(String mainId) {
		return mbOrgRoomFileMapper.selectByMainId(mainId);
	}
}
