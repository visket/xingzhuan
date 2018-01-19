package com.kedu.xingzhuan.utils.reflection;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.kedu.xingzhuan.entity.xs.XsmxEntity;
import com.kedu.xingzhuan.utils.DateUtil;
import com.kedu.xingzhuan.utils.annotation.Bind;
import com.kedu.xingzhuan.utils.enums.DataType;
import com.kedu.xingzhuan.utils.validate.ObjectUtils;

/**
 * 反射工具类：用于完成导入的Excel的列与实体Entity的属性动态绑定，主要服务于@bind注解
 * @author around
 * @date 2018-1-16
 */
public class ColumnReflect {

	/** 限制递归顶级对象范围 */
	public static final String ROOT_LEVEL = "java.lang.Object";
	
	
	/**
	 * @Description:获取绑定@bind注解的属性名
	 * @param clazz	绑定对象
	 * @param column excel列名
	 * @return:String
	 * @throws
	 */
	public static String getBindColumn(Class<?> clazz, String column) {
		Bind bind = null;
		Field[] fields = clazz.getDeclaredFields();
		
		for (Field field : fields) {
			//忽略不参与统计字段空值
			if(ObjectUtils.isNull(field.getAnnotation(Bind.class))) continue;
			//取存在@bind的字段
			bind = field.getAnnotation(Bind.class);
			//做对应的比较
			if(-1 != bind.vague().indexOf(column)) {
				column = field.getName();
				break;
			}
		}
		return column;
	}
	
	
	public static Map<Integer, String> getBindByReflect(Class<?> clazz, List<Object> fieldList) {
		Map<Integer, String> columnMap = new HashMap<Integer, String>();
		recursiveClass(clazz, fieldList, columnMap);
		
		return columnMap;
	}
	
	/**
	 * 
	 * @Description:递归完成对指定Class对象属性反射绑定
	 * @param clazz	Class
	 * @param fieldList	List<Object>
	 * @param columnMap
	 */
	private static void recursiveClass(Class<?> clazz, List<Object> fieldList, 
			Map<Integer, String> columnMap) {
		getBindColumn(clazz, fieldList, columnMap);
		Class<?> superClazz = clazz.getSuperclass();
		if(superClazz != null && !ROOT_LEVEL.equals(superClazz.getName())) 
			recursiveClass(superClazz, fieldList, columnMap);
	}
	
	
	/**
	 * @Description:获取绑定@bind注解的属性名
	 * @param clazz	绑定对象
	 * @param fieldList excel列名集合
	 * @return:Map<Integer, String>
	 */
	public static Map<Integer, String> getBindColumn(Class<?> clazz, List<Object> fieldList,
			Map<Integer, String> columnMap) {
		Bind bind = null;
		Field[] fields = clazz.getDeclaredFields();
		
		for (int i = 0; i < fieldList.size(); i++) {
			for (Field field : fields) {
				//忽略不参与统计字段空值
				if(ObjectUtils.isNull(field.getAnnotation(Bind.class))) continue;
				//取存在@bind的字段
				bind = field.getAnnotation(Bind.class);
				//做对应的比较
				if(-1 != bind.vague().indexOf(fieldList.get(i).toString())) {
					columnMap.put(i, field.getName());
					break;
				}
			}
		}
		return columnMap;
	}
	
	/**
	 * @Description:获取绑定@bind注解的属性名
	 * @param clazz	绑定对象
	 * @param fieldList excel列名集合
	 * @return:Map<Integer, String>
	 */
	public static Map<Integer, String> getBindColumn(Class<?> clazz, List<Object> fieldList) {
		Map<Integer, String> columnMap = new HashMap<Integer, String>();
		Bind bind = null;
		Field[] fields = clazz.getDeclaredFields();
		
		for (int i = 0; i < fieldList.size(); i++) {
			for (Field field : fields) {
				//忽略不参与统计字段空值
				if(ObjectUtils.isNull(field.getAnnotation(Bind.class))) continue;
				//取存在@bind的字段
				bind = field.getAnnotation(Bind.class);
				//做对应的比较
				if(-1 != bind.vague().indexOf(fieldList.get(i).toString())) {
					columnMap.put(i, field.getName());
					break;
				}
			}
		}
		return columnMap;
	}
	
	
	public static List<Object> dynamicBindValues(Class<?> clazz, 
			List<List<Object>> dataLists, Map<Integer, String> columnMap) {
		//作为待绑定值的实体对象，实体类动态newInstance
		Object obj = null;
		List<Object> returnList = new ArrayList<Object>();
		List<Object> excelObjectList = null;
		Field field = null;
		
		try {
			//迭代Excel读取的数据集
			for (int i = 0; i < dataLists.size(); i++) {
				//动态实例化需要绑定的对象
				obj = clazz.newInstance();
				excelObjectList = dataLists.get(i);
				//迭代Excel每行对象
				for (int j = 0; j < excelObjectList.size(); j++) {
					//System.out.println(i + "," + j);
					if (null == columnMap.get(j)) continue;
					field = clazz.getDeclaredField(columnMap.get(j));
					setFieldValue(obj, excelObjectList.get(j), field);
					
				}
				returnList.add(obj);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		
		
		return returnList;
	}
	
	
	private static void setFieldValue(Object source, Object value, Field field) {
		field.setAccessible(true);
		try {
			if (field.getType().getSimpleName().toLowerCase().equals(DataType.STRING.toString())
					|| field.getType().getSimpleName().toLowerCase().equals(DataType.CHAR.toString())) {
				field.set(source, value.toString());
			} else if (field.getType().getSimpleName().toLowerCase().equals(DataType.INT.toString()) ||
					field.getType().getSimpleName().toLowerCase().equals(DataType.INTEGER.toString())) {
				field.setInt(source, Integer.valueOf(value.toString()));
			} else if (field.getType().getSimpleName().toLowerCase().equals(DataType.LONG.toString())) {
				field.setLong(source, Long.valueOf(value.toString()));
			} else if (field.getType().getSimpleName().toLowerCase().equals(DataType.BIGDECIMAL.toString())) {
				field.set(source, new BigDecimal(value.toString()));
			} else if (field.getType().getSimpleName().toLowerCase().equals(DataType.DATE.toString())) {
				field.set(source, DateUtil.stringToDate(Long.valueOf(value.toString()), DateUtil.DATE_TO_STRING_SHORT_PATTERN));
			} else if (field.getType().getSimpleName().toLowerCase().equals(DataType.BOOLEAN.toString())) {
				field.setBoolean(source, Boolean.valueOf(value.toString()));
			} else if (field.getType().getSimpleName().toLowerCase().equals(DataType.SHORT.toString())) {
				field.setShort(source, Short.valueOf(value.toString()));
			} else  {
				field.set(source, value.toString());
			}
			
			
			/*switch (field.getType().getName().toLowerCase()) {
			case DataType.STRING.toString():
			case DataType.CHAR.toString():
				field.set(source, value.toString());
				break;
			case DataType.INT.toString():
			case DataType.INTEGER.toString():
				field.setInt(source, Integer.valueOf(value.toString()));
				break;
			case DataType.LONG.toString():
				field.setLong(source, Long.valueOf(value.toString()));
				break;
			case DataType.BIGDECIMAL.toString():
				field.set(source, new BigDecimal(value.toString()));
				break;
			case DataType.BOOLEAN.toString():
				field.setBoolean(source, Boolean.valueOf(value.toString()));
				break;
			case DataType.SHORT.toString():
				field.setShort(source, Short.valueOf(value.toString()));
				break;
			default:
				field.set(source, value.toString());
				break;
			}*/
			
			
			
			
			
			
		} catch (IllegalArgumentException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException, 
		InstantiationException, IllegalAccessException {
		Class<?> clazz = XsmxEntity.class;
		//Annotation[] annotations = clazz.getAnnotations();
		//annotations = clazz.getDeclaredAnnotations();
		clazz.getAnnotation(Bind.class);
		
		Object c = Class.forName("com.kedu.xingzhuan.entity.xs.XsmxEntity").newInstance();
		//c = new XsmxEntity();
		System.out.println(c);
	}
}
