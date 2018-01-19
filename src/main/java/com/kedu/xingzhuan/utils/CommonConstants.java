package com.kedu.xingzhuan.utils;

/**
 * @author ：
 * @date   ： 2017年6月6日 下午1:56:13
 * @Desc   ：通用常量
 */
public class CommonConstants {
	public interface CONTENT_TYPE {
		public static final String TEXT_TYPE = "text/plain";
		public static final String JSON_TYPE = "application/json";
		public static final String XML_TYPE = "text/xml";
		public static final String HTML_TYPE = "text/html";
		public static final String JS_TYPE = "text/javascript";
		public static final String EXCEL_TYPE = "application/vnd.ms-excel";
	}

	public interface ENCODE {
		public static final String UTF_8 = "UTF-8";
		public static final String ISO_8859_1 = "ISO-8859-1";
		public static final String GB2312 = "GB2312";
		public static final String GET = "GET";
		public static final String POST = "POST";
	}

	/**
	 * 全局常量-文件路径等适用
	 * @author around
	 * @date 2017-6-15
	 */
	public interface FilePath {
		//系统文件上传分类
		public static final String SEPARATOR = "/";
		/** 用户照片 */
		public static final String USER_IMAGE = "userImg";
		//厂商图片
		public static final String FACTORY_IMAGE ="factory";
		
		public static final String EXCEL = "excel";
	}

	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";

	public static final String USERINFO = "userinfo";//用户对象session名
	
	/** 数据库实例 */
	public static final String DATABASE= "cloud";
}
