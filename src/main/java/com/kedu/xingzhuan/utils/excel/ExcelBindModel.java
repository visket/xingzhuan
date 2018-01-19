package com.kedu.xingzhuan.utils.excel;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.kedu.xingzhuan.utils.reflection.ColumnReflect;

/**
 * Description:Excel绑定模板，区分模板项，做对应处理
 * @author around
 * @date 2018-1-15
 */
public class ExcelBindModel {

	/** 表头占位填充符 */
	public static String DEFAULT = "0";
	
	
	/**
	 * 检测模板和表头信息，拆分读取的Excel内容，分离表头和结果集数据
	 * @param dataLists
	 * @return List<List<Object>>
	 */
	public static List<Object> bind(Class<?> clazz, List<List<Object>> dataLists) {
		List<Object> headList = getHeadRow(dataLists);
		//到此步骤，headList=表头行，dataLists=经过剔除表头的精简行数据
		clearn(headList);
		
		//动态绑定实体类字段与对应的excel列名
		Map<Integer, String> columnMap = ColumnReflect.getBindColumn(clazz, headList);
		//插入到指定实体中
		List<Object> dataList = ColumnReflect.dynamicBindValues(clazz, dataLists, columnMap);
		return dataList;
	}
	
	
	/**
	 * 获取最细粒度表头列内容，清除无效行数据
	 * @param dataLists
	 * @return List<Object>
	 */
	public static List<Object> getHeadRow(List<List<Object>> dataLists) {
		Iterator<List<Object>> it = dataLists.iterator();
		List<Object> temp = null;
		int count = 0;
		while(it.hasNext()){
			temp = it.next();
			//清除可能存在的空行
			if(null == temp || 2 > temp.size()) {
				it.remove();
				continue;
			}
			//统计区分表头标题合并行
			for (int i = 0; i < temp.size(); i ++) {
				if (null != temp.get(i) && -1 != temp.get(i).toString().indexOf(DEFAULT)) count++;
			}
			//清除不需要的其他合并标题行
		    if(count > 3) {
		    	count = 0;
		        it.remove();
		        continue;
		    }
		    //获取最细粒度的表头信息，并删除表头
		    it.remove();
		    break;
		}
		return temp;
	}
	
	
	
	/**
	 * 清除集合中存在null、""、"0"部分的值
	 * @param list
	 */
	public static void clearn(List<Object> list) {
		Iterator<Object> it = list.iterator();
		Object obj = null;
		while(it.hasNext()){
			obj = it.next();
		    if(null == obj || "".equals(obj.toString()) || "0".equals(obj.toString())) {
		        it.remove();
		    }
		}
	}
	
}
