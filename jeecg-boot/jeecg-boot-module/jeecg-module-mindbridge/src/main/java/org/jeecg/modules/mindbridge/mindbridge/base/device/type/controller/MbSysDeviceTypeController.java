package org.jeecg.modules.mindbridge.mindbridge.base.device.type.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.system.query.QueryGenerator;
import org.jeecg.common.system.query.QueryRuleEnum;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.mindbridge.mindbridge.base.device.type.entity.MbSysDeviceType;
import org.jeecg.modules.mindbridge.mindbridge.base.device.type.service.IMbSysDeviceTypeService;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;

import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.jeecg.common.system.base.controller.JeecgController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.jeecg.common.aspect.annotation.AutoLog;
import org.apache.shiro.authz.annotation.RequiresPermissions;
 /**
 * @Description: 设备类型
 * @Author: jeecg-boot
 * @Date:   2025-09-15
 * @Version: V1.0
 */
@Tag(name="设备类型")
@RestController
@RequestMapping("/mindbridge/base/device/type/mbSysDeviceType")
@Slf4j
public class MbSysDeviceTypeController extends JeecgController<MbSysDeviceType, IMbSysDeviceTypeService> {
	@Autowired
	private IMbSysDeviceTypeService mbSysDeviceTypeService;
	
	/**
	 * 分页列表查询
	 *
	 * @param mbSysDeviceType
	 * @param pageNo
	 * @param pageSize
	 * @param req
	 * @return
	 */
	//@AutoLog(value = "设备类型-分页列表查询")
	@Operation(summary="设备类型-分页列表查询")
	@GetMapping(value = "/list")
	public Result<IPage<MbSysDeviceType>> queryPageList(MbSysDeviceType mbSysDeviceType,
								   @RequestParam(name="pageNo", defaultValue="1") Integer pageNo,
								   @RequestParam(name="pageSize", defaultValue="10") Integer pageSize,
								   HttpServletRequest req) {


        QueryWrapper<MbSysDeviceType> queryWrapper = QueryGenerator.initQueryWrapper(mbSysDeviceType, req.getParameterMap());
		Page<MbSysDeviceType> page = new Page<MbSysDeviceType>(pageNo, pageSize);
		IPage<MbSysDeviceType> pageList = mbSysDeviceTypeService.page(page, queryWrapper);
		return Result.OK(pageList);
	}
	
	/**
	 *   添加
	 *
	 * @param mbSysDeviceType
	 * @return
	 */
	@AutoLog(value = "设备类型-添加")
	@Operation(summary="设备类型-添加")
	@RequiresPermissions("mindbridge.base.device.type:mb_sys_device_type:add")
	@PostMapping(value = "/add")
	public Result<String> add(@RequestBody MbSysDeviceType mbSysDeviceType) {
		mbSysDeviceTypeService.save(mbSysDeviceType);

		return Result.OK("添加成功！");
	}
	
	/**
	 *  编辑
	 *
	 * @param mbSysDeviceType
	 * @return
	 */
	@AutoLog(value = "设备类型-编辑")
	@Operation(summary="设备类型-编辑")
	@RequiresPermissions("mindbridge.base.device.type:mb_sys_device_type:edit")
	@RequestMapping(value = "/edit", method = {RequestMethod.PUT,RequestMethod.POST})
	public Result<String> edit(@RequestBody MbSysDeviceType mbSysDeviceType) {
		mbSysDeviceTypeService.updateById(mbSysDeviceType);
		return Result.OK("编辑成功!");
	}
	
	/**
	 *   通过id删除
	 *
	 * @param id
	 * @return
	 */
	@AutoLog(value = "设备类型-通过id删除")
	@Operation(summary="设备类型-通过id删除")
	@RequiresPermissions("mindbridge.base.device.type:mb_sys_device_type:delete")
	@DeleteMapping(value = "/delete")
	public Result<String> delete(@RequestParam(name="id",required=true) String id) {
		mbSysDeviceTypeService.removeById(id);
		return Result.OK("删除成功!");
	}
	
	/**
	 *  批量删除
	 *
	 * @param ids
	 * @return
	 */
	@AutoLog(value = "设备类型-批量删除")
	@Operation(summary="设备类型-批量删除")
	@RequiresPermissions("mindbridge.base.device.type:mb_sys_device_type:deleteBatch")
	@DeleteMapping(value = "/deleteBatch")
	public Result<String> deleteBatch(@RequestParam(name="ids",required=true) String ids) {
		this.mbSysDeviceTypeService.removeByIds(Arrays.asList(ids.split(",")));
		return Result.OK("批量删除成功!");
	}
	
	/**
	 * 通过id查询
	 *
	 * @param id
	 * @return
	 */
	//@AutoLog(value = "设备类型-通过id查询")
	@Operation(summary="设备类型-通过id查询")
	@GetMapping(value = "/queryById")
	public Result<MbSysDeviceType> queryById(@RequestParam(name="id",required=true) String id) {
		MbSysDeviceType mbSysDeviceType = mbSysDeviceTypeService.getById(id);
		if(mbSysDeviceType==null) {
			return Result.error("未找到对应数据");
		}
		return Result.OK(mbSysDeviceType);
	}

    /**
    * 导出excel
    *
    * @param request
    * @param mbSysDeviceType
    */
    @RequiresPermissions("mindbridge.base.device.type:mb_sys_device_type:exportXls")
    @RequestMapping(value = "/exportXls")
    public ModelAndView exportXls(HttpServletRequest request, MbSysDeviceType mbSysDeviceType) {
        return super.exportXls(request, mbSysDeviceType, MbSysDeviceType.class, "设备类型");
    }

    /**
      * 通过excel导入数据
    *
    * @param request
    * @param response
    * @return
    */
    @RequiresPermissions("mindbridge.base.device.type:mb_sys_device_type:importExcel")
    @RequestMapping(value = "/importExcel", method = RequestMethod.POST)
    public Result<?> importExcel(HttpServletRequest request, HttpServletResponse response) {
        return super.importExcel(request, response, MbSysDeviceType.class);
    }

}
