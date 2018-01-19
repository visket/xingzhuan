package com.kedu.xingzhuan.utils.enums;

/**
 * Description:登录类型
 * @author around
 * @date 2017年8月15日上午9:47:05
 */
public enum LoginType {
	
	AGENCY("agency"), FACTORY("factory"), SYSTEM("system"), GUEST("guest");
	
	private String type;
	
	private LoginType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type.toString();
	}
	
}
