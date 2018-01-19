package com.kedu.xingzhuan.utils;

/**
 * @author ：
 * @date   ： 2017年6月3日 下午1:50:46
 * @Desc   ：结果处理类
 */
/**
 * Description:通用返回包装对象
 * @author around
 * @date 2017年10月23日下午3:24:21
 */
public class Result implements java.io.Serializable {

	private static final long serialVersionUID = -7074012067378557866L;

	/** 返回结果集 */
	private Object data;
	
	/** 成功失败 */
	private boolean success;
	
	/** 信息 */
	private String message;
	
	/** 状态码 */
	private Integer code;
	
	/** 前端弹窗模式："warning", "error", "success", "info" */
	private String icon;
	
	public Result() {}
	
	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
		if (success) icon = "success";
		else icon = "error";
	}
	
	public Result(boolean success, Integer code, String message) {
		this(success, message);
		this.code = code;
	}
	
	public Result(boolean success, Integer code, Object data, String message) {
		this(success, code, message);
		this.data = data;
	}

	
	public static Result result(Object data, boolean success, Integer code, String message) {
		Result result = new Result();
		result.data = data;
		result.success = success;
		result.message = message;
		result.code = code;
		return result;
	}
	
	
	

	//返回成功结果
	public static  Result resultSuccess(Object data, String message) {
		Result result = new Result();
		result.data = data;
		result.success = true;
		result.message = message;
		return result;
	}

	//返回失败
	public static  Result resultError(String message) {
		Result result = new Result();
		result.success = false;
		result.message = message;
		return result;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	
}
