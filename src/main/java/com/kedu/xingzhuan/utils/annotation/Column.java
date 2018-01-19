package com.kedu.xingzhuan.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解类-实体使用
 * @author around
 * @date 2017-6-14
 * @Description 同时提供给反射生成后台数据调用，定义反射标准；
 * 字段操作数据库是否是模糊查询，是否是字段属性
 */
@Retention(RetentionPolicy.RUNTIME) //定义注解应用于反射class文件中。
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.METHOD}) //定义注解应用于字段、方法
@Documented
public @interface Column {

	/**
	 * 确定前台后台绑定数据库是否一致，不一致请填写绑定数据库字段
	 * default : ""
	 * @return String
	 */
	String value() default "";
	
	/**
	 * 字段参与的匹配方式，>、<、like等，其他参考静态常量类
	 * default : =
	 * @return String
	 */
	String compare() default "=";
	
	/**
	 * 前缀添加 default：""
	 * @return
	 */
	String prefix() default "";
	
	/**
	 * 后缀添加 default：""
	 * @return
	 */
	String suffix() default "";
	
}
