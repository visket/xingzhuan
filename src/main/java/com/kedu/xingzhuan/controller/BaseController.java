package com.kedu.xingzhuan.controller;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.kedu.xingzhuan.utils.AjaxUtils;
import com.kedu.xingzhuan.utils.Result;
import com.kedu.xingzhuan.utils.ResultType;
import com.kedu.xingzhuan.utils.StatusCode;


/**
 * @author		：
 * @date		： 2017年6月4日 下午1:50:28
 * @Description ：基础controller类
 */
public abstract class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		// binder.registerCustomEditor(Date.class, EditorHolder.dateEditor);
		// binder.registerCustomEditor(Integer.class, EditorHolder.integerEditor);
		// binder.registerCustomEditor(Long.class, EditorHolder.longEditor);
		binder.registerCustomEditor(BigDecimal.class, new CustomNumberEditor(BigDecimal.class,
				new DecimalFormat("##.00"), true));
		/**
		 * 自动转换日期类型的字段格式
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		
		/**
		 * 防止XSS攻击
		 */
		//binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false));
	}

	/**
	 * Description:通用返回
	 * @param response 
	 * @param success boolean
	 * @param code 状态码
	 * @param data 对象
	 * @param message 返回信息
	 * @author around
	 * @date 2017年8月15日上午9:03:54
	 */
	public <T> void doResult(HttpServletResponse response, boolean success, Integer code, 
			T data,String message) {
		AjaxUtils.renderJson(response, Result.result(data, success, code, message));
	}
	
	/*@ExceptionHandler
	public void throwsException(HttpServletResponse response, Exception e) {
		AjaxUtils.renderJson(response, Result.result(null, false, 
				StatusCode.EXCEPTIONERROR, ResultType.ERROE));
	}*/
	
	/**
	 * Description:会话失效判断监听
	 * 
	 * @author around
	 * @date 2017年10月12日下午1:34:45
	 */
	public void loginOut(HttpServletResponse resp) {
		doResult(resp, false, StatusCode.LOGINOUT, null, ResultType.LOGINOUT);
	}
	
}
