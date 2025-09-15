package org.jeecg.modules.mindbridge.mindbridge.base.org.room.controller;

import java.io.UnsupportedEncodingException;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.vo.LoginUser;
import org.apache.shiro.SecurityUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomSeat;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomProject;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoomFile;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbSysRoomDevice;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.entity.MbOrgRoom;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.vo.MbOrgRoomPage;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.IMbOrgRoomService;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.IMbOrgRoomSeatService;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.IMbOrgRoomProjectService;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.IMbOrgRoomFileService;
import org.jeecg.modules.mindbridge.mindbridge.base.org.room.service.IMbSysRoomDeviceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;


 /**
 * @Description: 房间主数据
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Tag(name="房间主数据")
@RestController
@RequestMapping("/mindbridge/base/org/room/mbOrgRoom")
@Slf4j
public class MbOrgRoomController {
	@Autowired
	private IMbOrgRoomService mbOrgRoomService;
	@Autowired
	private IMbOrgRoomSeatService mbOrgRoomSeatService;
	@Autowired
	private IMbOrgRoomProjectService mbOrgRoomProjectService;
	@Autowired
	private IMbOrgRoomFileService mbOrgRoomFileService;
	@Autowired
	private IMbSysRoomDeviceService mbSysRoomDeviceService;
	
	/**
	 * 分页列表查询
	 *
	 * @param mbOrgRoom
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "房间主数据-分页列表查询")
	@Operation(summary="房间主数据-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<MbOrgRoom>> queryPageList(MbOrgRoom mbOrgRoom,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {
        QueryWrapper<MbOrgRoom> queryWrapper = QueryGenerator.initQueryWrapper(mbOrgRoom, req.getParameterMap());
		Page<MbOrgRoom> page = new Page<MbOrgRoom>(pageNo, pageSize);
		IPage<MbOrgRoom> pageList = mbOrgRoomService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param mbOrgRoomPage
	 * @return
	 */
	@AutoLog(value = "房间主数据-添加")
	@Operation(summary="房间主数据-添加")
    @RequiresPermissions("mindbridge.base.org.room:mb_org_room:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody MbOrgRoomPage mbOrgRoomPage) {
		MbOrgRoom mbOrgRoom = new MbOrgRoom();
		BeanUtils.copyProperties(mbOrgRoomPage, mbOrgRoom);
		mbOrgRoomService.saveMain(mbOrgRoom, mbOrgRoomPage.getMbOrgRoomSeatList(),mbOrgRoomPage.getMbOrgRoomProjectList(),mbOrgRoomPage.getMbOrgRoomFileList(),mbOrgRoomPage.getMbSysRoomDeviceList());
		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param mbOrgRoomPage
	 * @return
	 */
	@AutoLog(value = "房间主数据-编辑")
	@Operation(summary="房间主数据-编辑")
    @RequiresPermissions("mindbridge.base.org.room:mb_org_room:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody MbOrgRoomPage mbOrgRoomPage) {
		MbOrgRoom mbOrgRoom = new MbOrgRoom();
		BeanUtils.copyProperties(mbOrgRoomPage, mbOrgRoom);
		MbOrgRoom mbOrgRoomEntity = mbOrgRoomService.getById(mbOrgRoom.getId());
		if(mbOrgRoomEntity==null) {
			return Result.error("未找到对应数据");
		}
		mbOrgRoomService.updateMain(mbOrgRoom, mbOrgRoomPage.getMbOrgRoomSeatList(),mbOrgRoomPage.getMbOrgRoomProjectList(),mbOrgRoomPage.getMbOrgRoomFileList(),mbOrgRoomPage.getMbSysRoomDeviceList());
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "房间主数据-通过id删除")
	@Operation(summary="房间主数据-通过id删除")
    @RequiresPermissions("mindbridge.base.org.room:mb_org_room:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		mbOrgRoomService.delMain(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "房间主数据-批量删除")
	@Operation(summary="房间主数据-批量删除")
    @RequiresPermissions("mindbridge.base.org.room:mb_org_room:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.mbOrgRoomService.delBatchMain(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功！");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "房间主数据-通过id查询")
	@Operation(summary="房间主数据-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<MbOrgRoom> queryById(@RequestParam(name="id",required=true) String id) {
		MbOrgRoom mbOrgRoom = mbOrgRoomService.getById(id);
		if(mbOrgRoom==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(mbOrgRoom);

	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "房间功能位通过主表ID查询")
	@Operation(summary="房间功能位主表ID查询")
	@GetMapping(value = "/queryMbOrgRoomSeatByMainId")
	public Result<List<MbOrgRoomSeat>> queryMbOrgRoomSeatListByMainId(@RequestParam(name="id",required=true) String id) {
		List<MbOrgRoomSeat> mbOrgRoomSeatList = mbOrgRoomSeatService.selectByMainId(id);
		return Result.OK(mbOrgRoomSeatList);
	}
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "房间-项目白名单通过主表ID查询")
	@Operation(summary="房间-项目白名单主表ID查询")
	@GetMapping(value = "/queryMbOrgRoomProjectByMainId")
	public Result<List<MbOrgRoomProject>> queryMbOrgRoomProjectListByMainId(@RequestParam(name="id",required=true) String id) {
		List<MbOrgRoomProject> mbOrgRoomProjectList = mbOrgRoomProjectService.selectByMainId(id);
		return Result.OK(mbOrgRoomProjectList);
	}
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "房间附件通过主表ID查询")
	@Operation(summary="房间附件主表ID查询")
	@GetMapping(value = "/queryMbOrgRoomFileByMainId")
	public Result<List<MbOrgRoomFile>> queryMbOrgRoomFileListByMainId(@RequestParam(name="id",required=true) String id) {
		List<MbOrgRoomFile> mbOrgRoomFileList = mbOrgRoomFileService.selectByMainId(id);
		return Result.OK(mbOrgRoomFileList);
	}
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "房间/功能位-设备绑定通过主表ID查询")
	@Operation(summary="房间/功能位-设备绑定主表ID查询")
	@GetMapping(value = "/queryMbSysRoomDeviceByMainId")
	public Result<List<MbSysRoomDevice>> queryMbSysRoomDeviceListByMainId(@RequestParam(name="id",required=true) String id) {
		List<MbSysRoomDevice> mbSysRoomDeviceList = mbSysRoomDeviceService.selectByMainId(id);
		return Result.OK(mbSysRoomDeviceList);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param mbOrgRoom
    */
    @RequiresPermissions("mindbridge.base.org.room:mb_org_room:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, MbOrgRoom mbOrgRoom) {

      // Step.1 组装查询条件查询数据
      QueryWrapper<MbOrgRoom> queryWrapper = QueryGenerator.initQueryWrapper(mbOrgRoom, request.getParameterMap());
      LoginUser sysUser = (LoginUser) SecurityUtils.getSubject().getPrincipal();

      //配置选中数据查询条件
      String selections = request.getParameter("selections");
      if(oConvertUtils.isNotEmpty(selections)) {
         List<String> selectionList = Arrays.asList(selections.split(","));
         queryWrapper.in("id",selectionList);
      }
      //Step.2 获取导出数据
      List<MbOrgRoom> mbOrgRoomList = mbOrgRoomService.list(queryWrapper);

      // Step.3 组装pageList
      List<MbOrgRoomPage> pageList = new ArrayList<MbOrgRoomPage>();
      for (MbOrgRoom main : mbOrgRoomList) {
          MbOrgRoomPage vo = new MbOrgRoomPage();
          BeanUtils.copyProperties(main, vo);
          List<MbOrgRoomSeat> mbOrgRoomSeatList = mbOrgRoomSeatService.selectByMainId(main.getId());
          vo.setMbOrgRoomSeatList(mbOrgRoomSeatList);
          List<MbOrgRoomProject> mbOrgRoomProjectList = mbOrgRoomProjectService.selectByMainId(main.getId());
          vo.setMbOrgRoomProjectList(mbOrgRoomProjectList);
          List<MbOrgRoomFile> mbOrgRoomFileList = mbOrgRoomFileService.selectByMainId(main.getId());
          vo.setMbOrgRoomFileList(mbOrgRoomFileList);
          List<MbSysRoomDevice> mbSysRoomDeviceList = mbSysRoomDeviceService.selectByMainId(main.getId());
          vo.setMbSysRoomDeviceList(mbSysRoomDeviceList);
          pageList.add(vo);
      }

      // Step.4 AutoPoi 导出Excel
      ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
      mv.addObject(NormalExcelConstants.FILE_NAME, "房间主数据列表");
      mv.addObject(NormalExcelConstants.CLASS, MbOrgRoomPage.class);
      mv.addObject(NormalExcelConstants.PARAMS, new ExportParams("房间主数据数据", "导出人:"+sysUser.getRealname(), "房间主数据"));
      mv.addObject(NormalExcelConstants.DATA_LIST, pageList);
      return mv;
    }

    /**
    * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("mindbridge.base.org.room:mb_org_room:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
      MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
      Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
      for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
          // 获取上传文件对象
          MultipartFile file = entity.getValue();
          ImportParams params = new ImportParams();
          params.setTitleRows(2);
          params.setHeadRows(1);
          params.setNeedSave(true);
          try {
              List<MbOrgRoomPage> list = ExcelImportUtil.importExcel(file.getInputStream(), MbOrgRoomPage.class, params);
              for (MbOrgRoomPage page : list) {
                  MbOrgRoom po = new MbOrgRoom();
                  BeanUtils.copyProperties(page, po);
                  mbOrgRoomService.saveMain(po, page.getMbOrgRoomSeatList(),page.getMbOrgRoomProjectList(),page.getMbOrgRoomFileList(),page.getMbSysRoomDeviceList());
              }
              return Result.OK("文件导入成功！数据行数:" + list.size());
          } catch (Exception e) {
              log.error(e.getMessage(),e);
              return Result.error("文件导入失败:"+e.getMessage());
          } finally {
              try {
                  file.getInputStream().close();
              } catch (IOException e) {
                  e.printStackTrace();
              }
          }
      }
      return Result.OK("文件导入失败！");
    }

}
