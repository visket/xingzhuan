package com.kedu.xingzhuan.utils.excel;

public class Test {

	public static void main(String[] args) {
		String str = "浙江省杭州市临安市玲珑街道玲珑山路767号";
		String[] addressArray = str.split("[省市区县镇, ]+");
		for (String string : addressArray) {
			System.out.println(string);
		}
		
		str = "上海市浦东新区测试街道";
		addressArray = str.split("[省市区县镇, ]+");
		for (String string : addressArray) {
			System.out.println(string);
		}
		
		str = "浙江省 宁波市 象山县 定塘镇渡头街";
		addressArray = str.split("[省市区县镇, ]+");
		for (String string : addressArray) {
			System.out.println(string);
		}
		
	}
}
