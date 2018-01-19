package com.kedu.xingzhuan.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.kedu.xingzhuan.entity.xs.XsmxEntity;
import com.kedu.xingzhuan.utils.ResultType;
import com.kedu.xingzhuan.utils.StatusCode;
import com.kedu.xingzhuan.utils.excel.ExcelBindModel;
import com.kedu.xingzhuan.utils.excel.ExcelRead;

/**
 * 全局读取Excel文件
 * @author around
 *
 */
@Controller
@RequestMapping("/excelReade")
public class ExcelReadController extends BaseController {

	/**
	 * 通用Excel导入
	 * @param file
	 * @param row
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	@RequestMapping(value = "/general", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public void general(@Param("file")MultipartFile file, HttpServletRequest req, 
			HttpServletResponse resp) throws IOException{
		//验证非空
		if( file == null ){ 
			doResult(resp, false, StatusCode.LACKVALUE, null, ResultType.INPUT_NULL);
			return ;
		}
		
		String name = file.getOriginalFilename();  
	    long size = file.getSize();
		
	    //List<Object> headList = ExcelRead.readExcelHead(file, 0, 1, 0, null);
	    //DefaultListUtils.clearn(headList);
	    //读取Excel文件内容
	    List<List<Object>> dataLists = ExcelRead.readExcel(file, 0, null, 0, null);
	    //动态绑定Excel内容到指定实体
	    List<XsmxEntity> resultList = convert(ExcelBindModel.bind(XsmxEntity.class, dataLists));
	    
	    doResult(resp, true, StatusCode.SAVESUCCESS, resultList, ResultType.SAVE_SUCCESS);
	}
	
	private static List<XsmxEntity> convert(List<Object> dataList) {
		List<XsmxEntity> resultList = new ArrayList<XsmxEntity>();
		for (Object obj : dataList) {
			resultList.add((XsmxEntity) obj);
		}
		return resultList;
	}
	
}
