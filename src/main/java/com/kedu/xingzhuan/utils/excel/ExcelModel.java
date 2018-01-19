package com.kedu.xingzhuan.utils.excel;


/**
 * Description:Excel模板类型
 * @author around
 * @date 2018-1-15
 */
public enum ExcelModel {
	
	/**代理信息： 长度= ，和并列占位= ，表头行数= ，是否多工作簿=  */
	DAILI(1), 
	/**通联方式协查样本： 长度= ，和并列占位= ，表头行数= ，是否多工作簿=  */
	TLFSXC(2), 
	/**温州-例表2明细表： 长度=12 ，和并列占位=0 ，表头行数=2 ，是否多工作簿=false  */
	WZ_L2(3), 
	/**物流类型1： 长度=13 ，和并列占位=12 ，表头行数=2 ，是否多工作簿=false  */
	WLLX1(4), 
	/**物流类型2： 长度=21 ，和并列占位=16 ，表头行数=3 ，是否多工作簿=false  */
	WLLX2(5), 
	/**物流类型3： 长度=14 ，和并列占位=0 ，表头行数=1 ，是否多工作簿=false  */
	WLLX3(6), 
	/**物流类型4： 长度=17，和并列占位=0，表头行数=1，是否多工作簿=false */
	WLLX4(7);
	
	private Integer type;
	
	private ExcelModel(Integer type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return this.type.toString();
	}
	
}
