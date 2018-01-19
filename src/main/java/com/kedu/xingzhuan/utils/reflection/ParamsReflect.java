package com.kedu.xingzhuan.utils.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.kedu.xingzhuan.utils.ServiceException;
import com.kedu.xingzhuan.utils.annotation.Column;
import com.kedu.xingzhuan.utils.enums.DataType;
import com.kedu.xingzhuan.utils.finals.Compare;
import com.kedu.xingzhuan.utils.tuple.TwoTuple;
import com.kedu.xingzhuan.utils.validate.ObjectUtils;


/**
 * 反射工具类：实现前端传参查询等模式的自动封装，并根据@Column预装配成符合要求的SQL内容
 * @author around
 * @date 2017-6-14
 * @deprecated：使用方式，调用getParamsByReflect方法传递待处理的对象数据，可接受vo、entity
 */
public class ParamsReflect {

	/** 限制递归顶级对象范围 */
	public static final String ROOT_LEVEL = "java.lang.Object";

	/** 忽略参与封装字段 */
	public static final String IGNORE_FIELDS = "serialVersionUID";
	
	public static final String GET = "get";
	
	public static final String IS = "is";
	
	
	/**
	 * 自定义反射封装查询条件，主要用于过滤查询使用
	 * @param source 待取值的对象
	 * @return Map<String, Object>
	 */
	public static Map<String, Object> getParamsByReflect(Object source) {
		Map<String, Object> dynamic = new HashMap<String, Object>();
		
		recursiveClass(source, source.getClass(), dynamic);
		return dynamic;
	}
	
	/**
	 * 递归处理对象(当前、父类...BaseEntity),反射取每一级的属性
	 * @param source 原始传参封装对象
	 * @param claz class对象
	 * @param dynamic Map<String, Object> 数据封装容器
	 */
	private static void recursiveClass(Object source, Class<?> clazz, Map<String, Object> dynamic) {
		reflection(source, clazz, dynamic);
		Class<?> superClazz = clazz.getSuperclass();
		if(superClazz != null && !ROOT_LEVEL.equals(superClazz.getName())) 
			recursiveClass(source, superClazz, dynamic);
	}
	
	/**
	 * 反射取值封装方法：
	 * 通过fields获取值，以get方法的方式获取对应的结果集
	 * @param source 原始传参封装对象
	 * @param clazz class对象
	 * @param dynamic Map<String, Object> 数据封装容器
	 */
	private static void reflection(Object source, Class<?> clazz, Map<String, Object> dynamic) {
		Field[] fields = clazz.getDeclaredFields();//反射取当前对象属性集
		Method method = null;
		Object obj = null;
		Column column = null;
		String tempKey = "";
		try {
			for(Field field : fields) {
				if(IGNORE_FIELDS.indexOf(field.getName()) != -1) continue;//忽略取值字段
				//忽略不参与统计字段空值
				if(ObjectUtils.isNull(field.getAnnotation(Column.class))) continue;
				
				//添加boolean类型字段的判断，其get方法是 isXXX
				if("boolean".equals(field.getType().getName().toLowerCase()))
					method = clazz.getMethod(IS + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
				else //以属性名称装配获取对应的get方法： 属性facId ==> getFacId
					method = clazz.getMethod(GET + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1));
				//忽略空值
				if(ObjectUtils.isNull(method.invoke(source))) continue;
				
				//反射得到getXXX方法的值
				obj = method.invoke(source);
				//获取当前Cloumn注解
				column = field.getAnnotation(Column.class);
				
				//setField(dynamic, field.getAnnotation(Column.class), obj);
				//当存在规则注解，进行规则处理参数结果
				obj = setCustomData(column, obj);
				//处理是否自定义绑定数据库字段
				tempKey =  Compare.BLANK.equals(column.value()) ? field.getName() : column.value();
				
				dynamic.put(tempKey + Compare.BLANKSPACE + column.compare(), obj);
			}
		} catch (NoSuchMethodException e) {
			throw new ServiceException("ParamsReflect.reflection is NoSuchMethodException!");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 获取当前对象对应字段的属性（对象）
	 * 声明，需要注意在NoSuchFieldException异常捕捉中捕获自己需要的属性字段进行拦截，
	 * 告诉当查询这些属性名的时候，指定是查找的哪些对象，如果不告诉它，它是不知道的
	 * @param obj	当前对象
	 * @param field	需要获取的属性名，可以是当前对象中的属性名， 也可以是当前对象中的对象的属性名
	 * @return	TwoTuple<String, Object>  当前对象指定属性值
	 * @throws NoSuchMethodException 
	 */
	public static TwoTuple<String, Object> getFieldValue(Object obj, String field) {
		return getValue(obj, obj.getClass(), field);
	}
	
	private static TwoTuple<String, Object> getValue(Object obj, Class<?> claz, String field) {
		Object fieldValue = null;
		Field f = null;
		Method method = null;
		String type = null;
		try {
			//此反射内容比较简单，因为只用于审核方面取数据，所以前台值为绑定成功的一定不会报错，则不需校验字段是否存在
			//method = claz.getDeclaredMethod("get"+field.substring(0, 1).toUpperCase()+field.substring(1), null);
			f = claz.getDeclaredField(field);
			//判断当前的反射字段是否是在当前对象中
			if (claz != null && !ROOT_LEVEL.equals(claz.getName())) {
				if (null == f) return getValue(obj, claz.getSuperclass(), field);
			} else {
				return new TwoTuple<String, Object>(DataType.STRING.toString(), fieldValue);
			}
			
			//添加boolean类型字段的判断，其get方法是 isXXX
			type = f.getType().getName().toLowerCase();
			if("boolean".equals(type))
				method = claz.getMethod(IS + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1));
			else //以属性名称装配获取对应的get方法： 属性facId ==> getFacId
				method = claz.getMethod(GET + f.getName().substring(0, 1).toUpperCase() + f.getName().substring(1));
			
			fieldValue = method.invoke(obj);
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			//此处异常捕获为：找不到属性名异常。
			//注意在此处我们要手工去帮它找到field应该对象到哪个对象里的值，因为我们不知道它们之间的关系，所以需要手工指定关系，找哪个对象去关联
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return new TwoTuple<String, Object>(type, fieldValue);
	}
	
	
	/**
	 * 自定义处理数据的方法
	 * @param column 注解	
	 * @param value Object
	 * @return Object
	 */
	private static Object setCustomData(Column column, Object value) {
		//判断是否存在时间格式的注解，若存在，则取值
		if (!"".equals(column.suffix()))
			value = value + column.suffix();
		else if (!"".equals(column.prefix()))
			value = column.suffix() + value;
		//当比较符为 like时
		else if (Compare.LIKE.equals(column.compare())) 
			value = Compare.PERCENT + value + Compare.PERCENT;
		
		return value;
	}

}
