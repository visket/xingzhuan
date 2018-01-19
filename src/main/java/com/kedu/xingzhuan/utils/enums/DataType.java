package com.kedu.xingzhuan.utils.enums;

/**
 * Description:基本数据类型状态枚举
 * @author around
 * @date 2017年8月29日下午4:17:25
 */
public enum DataType {

	STRING("string"), CHAR("char"), BOOLEAN("boolean"), BYTE("byte"), SHORT("short"),
	INT("int"), INTEGER("integer"), LONG("long"), 
	BIGDECIMAL("bigdecimal"),
	DATE("date");
	
	private String type;
	
	private DataType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type.toString();
	}
}
