package com.kedu.xingzhuan.utils;


/**
 * 状态码，对应前端处理
 * @author around
 * @date 2017-7-26
 */
public class StatusCode {
	
	/** 没有权限 */
	public static final Integer NOPERMISS = 401;
	
	/** 权限不足 */
	public static final Integer PERMISSION_LESS = 402;

	/** 会话ing */
	public static final Integer LOGING = 299;
	
	/** 会话失效 */
	public static final Integer LOGINOUT = 400;
	
	/** 操作成功*/
	public static final Integer OPERATIONSUCCESS = 200;
	
	/** 操作失败*/
	public static final Integer OPERATIONERROR = 500;
	
	/** 查询成功 */
	public static final Integer FINDSUCCESS = 201;
	
	/** 查询失败 */
	public static final Integer FINDERROR = 501;
	
	/** 保存成功 */
	public static final Integer SAVESUCCESS = 202;
	
	/** 保存失败 */
	public static final Integer SAVEERROR = 502;
	
	/** 删除成功 */
	public static final Integer REMOVESUCCESS = 203;
	
	/** 删除失败 */
	public static final Integer REMOVEERROR = 503;
	
	/** 退出成功 */
	public static final Integer TOLOGINOUT = 204;
	
	/** 程序异常 */
	public static final Integer EXCEPTIONERROR = 510;
	
	/** 缺少必填项 */
	public static final Integer LACKVALUE = 511;
	
	/** 字段重复 */
	public static final Integer DUPLICATIONERROR = 512;
	
	/** 无对应数据 */
	public static final Integer NORETRUNDATA = 513;
	
	/** 默认状态 */
	public static final Integer DEFAULT = 251;
	
	
}
