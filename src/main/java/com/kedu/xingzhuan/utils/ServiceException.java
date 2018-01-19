package com.kedu.xingzhuan.utils;

/**
 * @author ：
 * @date   ： 2017年6月8日 上午10:05:31
 * @Desc   ：自定义异常.错误
 */
public class ServiceException extends RuntimeException {
	private static final long serialVersionUID = 6151663311847865014L;

	/** 异常错误返回码 */
	private Integer code = 0;
	
	
	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}
	
	public ServiceException(Integer code, String message) {
		super(message);
		this.code = code;
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}
	
	public ServiceException(Integer code, String message, Throwable cause) {
		super(message, cause);
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
