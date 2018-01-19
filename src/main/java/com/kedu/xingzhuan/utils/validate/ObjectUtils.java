package com.kedu.xingzhuan.utils.validate;


/**
 * 封装集成apache工具类
 * @author around
 * 
 */
public class ObjectUtils extends org.apache.commons.lang3.ObjectUtils {

	/**
	 * 仅仅判断非包转类型的判断为空
	 * @param obj
	 * @return boolean true:空
	 */
	public static boolean isNull(Object obj) {
		if(null == obj) return true;
		else if("".equals(obj.toString())) return true;
		//else if("0".equals(obj.toString())) return true;
		else return false;
	}
	
	
}
