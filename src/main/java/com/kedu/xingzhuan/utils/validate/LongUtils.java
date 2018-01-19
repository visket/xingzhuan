package com.kedu.xingzhuan.utils.validate;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

/**
 * Long 类型验证
 * @author around
 * @date 2017-6-13
 */
public class LongUtils {

	
	/**
	 * 校验Long类型数据是否为空
	 * @param data Long
	 * @return boolean true:为空
	 */
	public static boolean isEmpty(Long data) {
		if(data == null) return true;
		else if(data == 0L) return true;
		else return false;
	}
	
	public static Long[] convert(String[] data) {
		List<Long> longList = new ArrayList<Long>();
		for (int i = 0; i < data.length; i++) {
			if (StringUtils.isNotEmpty(data[i]))
				longList.add(Long.valueOf(data[i]));
		}
		return longList.toArray(new Long[longList.size()]);
	}
	
	
}
