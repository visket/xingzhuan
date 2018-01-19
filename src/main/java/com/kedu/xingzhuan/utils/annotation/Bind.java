package com.kedu.xingzhuan.utils.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解类-实体使用
 * @author around
 * @date 2018-1-16
 * @Description：使用反射方式动态绑定前端过来的数据（如Excel等）进行字段属性绑定
 */
@Retention(RetentionPolicy.RUNTIME) //定义注解应用于反射class文件中。
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.METHOD}) //定义注解应用于字段、方法
@Documented
public @interface Bind {

	/**
	 * 待绑定列的列名，对应的属性名参与的模糊匹配，会使用indexOf进行，所以本属性可以传入多个匹配列名，使用“,”隔开
	 * default : ""
	 * @return String
	 */
	String vague() default "";
	
	
}
