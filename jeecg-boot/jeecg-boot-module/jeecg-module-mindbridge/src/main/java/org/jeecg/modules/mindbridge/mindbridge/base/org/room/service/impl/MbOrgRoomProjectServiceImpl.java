package org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.impl;

import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomProject;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.mapper.MbOrgRoomProjectMapper;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.IMbOrgRoomProjectService;
import org.springframework.stereotype.Service;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: 房间-项目白名单
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Service
public class MbOrgRoomProjectServiceImpl extends ServiceImpl<MbOrgRoomProjectMapper, MbOrgRoomProject> implements IMbOrgRoomProjectService {
	
	@Autowired
	private MbOrgRoomProjectMapper mbOrgRoomProjectMapper;
	
	@Override
	public List<MbOrgRoomProject> selectByMainId(String mainId) {
		return mbOrgRoomProjectMapper.selectByMainId(mainId);
	}
}
