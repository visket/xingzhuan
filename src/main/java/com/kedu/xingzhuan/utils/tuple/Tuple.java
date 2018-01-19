package com.kedu.xingzhuan.utils.tuple;


/**
 * 元组，用于自定义方法返回参数个数。
 * 例如当需要返回值为多个对象内容时，则使用该模块下内容。
 * @author 周围
 *
 */
public class Tuple {

	static TwoTuple<String, Integer> getTwo() {
		return new TwoTuple<String, Integer>("abc", 123);
	}
	
	public static void main(String[] args) {
		TwoTuple<String, Integer> two = getTwo(); 
		System.out.println(two);
	}
}
