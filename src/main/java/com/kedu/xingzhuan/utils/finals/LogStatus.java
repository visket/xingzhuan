package com.kedu.xingzhuan.utils.finals;

/**
 * Description:日志状态
 * @author around
 * @date 2017年9月5日下午3:03:34
 */
public class LogStatus {

	/** 新增退货单 */
	public static final Integer RETURN_ADD = 1;

	/** 提交退货单 */
	public static final Integer RETURN_SUBMIT = 2;

	/** 审核退货单 */
	public static final Integer RETURN_AUDIT = 3;

	/** 发货 */
	public static final Integer RETURN_DELIVE = 4;

	/** 收货确认 */
	public static final Integer RETURN_DELIVERY = 5;

	/** 退款确认 */
	public static final Integer RETURN_REFUND = 6;
	
	//发货单
	/** 新增发货单 */
	public static final Integer DELIVERY_ADD = 1;

	/** 提交发货单 */
	public static final Integer DELIVERY_SUBMIT = 2;

	/** 审核发货单 */
	public static final Integer DELIVERY_AUDIT = 3;

	/** 发货 */
	public static final Integer DELIVERY_DELIVE = 4;

	/** 收货 */
	public static final Integer DELIVERY_DELIVERY = 4;
}
