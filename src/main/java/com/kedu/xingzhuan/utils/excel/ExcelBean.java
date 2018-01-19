package com.kedu.xingzhuan.utils.excel;

/**
 * Description:Excel导出工具实体
 * @author around
 * @date 2017年8月28日下午4:32:21
 */
public class ExcelBean {

	
	/** 文件名称前缀，例如：人员信息12324554.xls，中的中文 */
	private String excelName;
	
	/** 工作簿名称 */
	private String sheetName;
	
	/** excel导出模式， 当前选择行：getSelections,当前页：getPages, 当前过滤条件:getForms */
	private String exportModel;
	
	private String filterSelections;
	
	/** 需要导出的列 */
	private String columnStr;
	
	private String[] columnArray;
	
	/** 导出的列对应的中文 */
	private String titleStr;
	
	private String[] titleArray;
	
	
	/** 用于过滤选择单据的ID字段 */
	private String filterIds;
	

	public String getExcelName() {
		return excelName;
	}

	public void setExcelName(String excelName) {
		this.excelName = excelName;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	
	public String getExportModel() {
		return exportModel;
	}

	public void setExportModel(String exportModel) {
		this.exportModel = exportModel;
	}
	
	public String getColumnStr() {
		return columnStr;
	}

	public void setColumnStr(String columnStr) {
		this.columnStr = columnStr;
	}
	
	public String getTitleStr() {
		return titleStr;
	}

	public void setTitleStr(String titleStr) {
		this.titleStr = titleStr;
	}

	public String getFilterSelections() {
		return filterSelections;
	}

	public void setFilterSelections(String filterSelections) {
		this.filterSelections = filterSelections;
	}

	public String getFilterIds() {
		return filterIds;
	}

	public void setFilterIds(String filterIds) {
		this.filterIds = filterIds;
	}

	public String[] getColumnArray() {
		return columnArray;
	}

	public void setColumnArray(String[] columnArray) {
		this.columnArray = columnArray;
	}

	public String[] getTitleArray() {
		return titleArray;
	}

	public void setTitleArray(String[] titleArray) {
		this.titleArray = titleArray;
	}
	
	
}
