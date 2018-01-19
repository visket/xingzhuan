package com.kedu.xingzhuan.utils.array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.google.common.collect.Lists;

/**
 * Description:List工具类
 * @author around
 * @date 2017年9月28日上午10:22:44
 */
public class DefaultListUtils extends ListUtils {

	
	/**
	 * 清除集合中存在null或""部分的值
	 * @param list
	 * @param flag 是否清除""部分， true=是
	 */
	public static void clearn(List<Object> list) {
		Iterator<Object> it = list.iterator();
		Object obj = null;
		while(it.hasNext()){
			obj = it.next();
		    if(null == obj || "".equals(obj.toString())) {
		        it.remove();
		    }
		}
	}
	
	/**
	 * @Description:Object集合转String
	 * @param list
	 * @return:List<String>
	 * @throws
	 */
	public static List<String> convert(List<Object> list) {
		List<String> newList = new ArrayList<String>();
		for(Object obj : list)
			newList.add(obj.toString());
		return newList;
	}
	
	
	
	/**
	 * Description:分段格式化数据，用于精简大量ID查询数据库语句，减少与数据库交互次数
	 * @param cartIds	全部ID
	 * @param count	拆分长度，每次执行多少次拆分多少
	 * @return List<List<Long>> 
	 * @author around
	 * @date 2017年9月28日上午10:17:23
	 */
	public static List<List<Long>> splitList(List<Long> cartIds, int count) {
		List<List<Long>> returnList = Lists.newArrayList();
		//计算当前的数组大小，若id集合分段截取有多余，则多循环一次，若没有则直接计算
		int total = cartIds.size() % count == 0 ? 
				cartIds.size()/count : (cartIds.size()/count)+1;
		for (int i = 0; i < total; i++) {
			if (i == total-1) {
				returnList.add(cartIds.subList(i*count, cartIds.size()));
			} else 
				returnList.add(cartIds.subList(i*count, i*count+count));
		}
		return returnList;
	}
	
	/**
	 * Description:比较2个集合，在before中找after没有的元素返回
	 * @param before
	 * @param after
	 * @return
	 * @author around
	 * @date 2017年10月9日下午1:55:38
	 */
	public static List<String> equals(List<String> before, List<String> after) {
		boolean flag = false;
		List<String> removeList = Lists.newArrayList();
		for (int i = 0; i < before.size(); i++) {
			for (int j = 0; j < after.size(); j++) {
				if (before.get(i).equals(after.get(j))) {
					flag = false;
					break;
				}
				flag = true;
			}
			if (flag) removeList.add(before.get(i));
		}
		return removeList;
	}
	
	
	public static void main(String[] args) {
		/*List<Long> cartIds = new ArrayList<Long>();
		for (int i = 0; i < 63; i++) 
			cartIds.add(Long.valueOf(i));
		
		System.out.println(cartIds);
		
		List<List<Long>> tempList = splitList(cartIds, 5);
		
		for (List<Long> list : tempList) {
			System.out.println(list);
		}*/
		
		List<String> before = Lists.newArrayList();
		before.add("1");
		before.add("2");
		before.add("3");
		before.add("4");
		List<String> after = Lists.newArrayList();
		after.add("2");
		after.add("5");
		after.add("3");
		after.add("4");
		
		List<String> addList = equals(after, before);
		System.out.println(addList);
		List<String> removeList = equals(before, after);
		System.out.println(removeList);
	}
	
}
