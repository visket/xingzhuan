package com.kedu.xingzhuan.framework.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.kedu.xingzhuan.utils.AjaxUtils;
import com.kedu.xingzhuan.utils.Result;
import com.kedu.xingzhuan.utils.ResultType;
import com.kedu.xingzhuan.utils.ServiceException;
import com.kedu.xingzhuan.utils.StatusCode;



/**
 * Description:自定义异常处理方法
 * @author around
 * @date 2017年8月3日下午5:06:04
 */
public class DefaultHandlerExceptionResolver implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, 
			HttpServletResponse response, Object handler, Exception ex) {
		Integer code = StatusCode.EXCEPTIONERROR;//状态码
		String message = ResultType.ERROE;//错误信息
		if (ex instanceof ServiceException) {//自定义异常
			code = ((ServiceException)ex).getCode() == 0 ? StatusCode.EXCEPTIONERROR : ((ServiceException)ex).getCode();
			message = ex.getMessage();
		} else if (ex instanceof DuplicateKeyException) {//数据库唯一键重复
			code = StatusCode.SAVEERROR;
			message = ex.getMessage().indexOf("MySQLIntegrityConstraintViolationException") == -1 ? ex.getMessage() :ResultType.INPUT_REPEAT;
		} else if(ex instanceof com.alibaba.fastjson.JSONException) {
			code = StatusCode.SAVEERROR;
			message = ResultType.INPUT_ERROR;
		} /*else if(ex instanceof org.apache.shiro.authz.UnauthorizedException) {
			code = StatusCode.NOPERMISS;
			message = ex.getMessage().substring(ex.getMessage().indexOf("[")).concat("权限不足,请联系管理员!");
		}*/ else {
			message = ex.getMessage() == null ? ResultType.ERROE : ex.getMessage();
		}
		
		AjaxUtils.renderJson(response, Result.result(null, false, code, message));
		return null;
	}

}
