package com.kedu.xingzhuan.utils.excel;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class ExcelUtil {
	
	public static final String OFFICE_EXCEL_2003_POSTFIX = "xls";  
    public static final String OFFICE_EXCEL_2010_POSTFIX = "xlsx";  
    public static final String EMPTY = "";  
    public static final String POINT = ".";  
    public static SimpleDateFormat sdf =   new SimpleDateFormat("yyyy/MM/dd"); 
    
    /** 
     * 获得path的后缀名 
     * @param path 
     * @return 
     */  
    public static String getPostfix(String path){  
        if(path==null || EMPTY.equals(path.trim())){  
            return EMPTY;  
        }  
        if(path.contains(POINT)){  
            return path.substring(path.lastIndexOf(POINT)+1,path.length());  
        }  
        return EMPTY;  
    }
    
    /** 
     * 单元格格式 
     * @param hssfCell 
     * @return 
     */  
    @SuppressWarnings({ "static-access", "deprecation" })  
    public static Object getHValue(HSSFCell hssfCell){
    	String cellValue = "";
    	
    	if ( hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN ) {  
            return Boolean.valueOf(hssfCell.getBooleanCellValue());  
        }
    	if ( hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC ) {
    		return Integer.valueOf((int) hssfCell.getNumericCellValue());
    	}  
    	if ( hssfCell.getCellType() == hssfCell.CELL_TYPE_STRING ) {
    		return String.valueOf(hssfCell.getStringCellValue());
		}
        if ( HSSFDateUtil.isCellDateFormatted(hssfCell) ){  
            Date date = XSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue());  
            cellValue = sdf.format(date);
        } else {
        	DecimalFormat df = new DecimalFormat("#.##");  
        	cellValue = df.format(hssfCell.getNumericCellValue());  
            String strArr = cellValue.substring(cellValue.lastIndexOf(POINT)+1,cellValue.length());  
            if(strArr.equals("00")){  
                cellValue = cellValue.substring(0, cellValue.lastIndexOf(POINT));  
            }    
        }
        return cellValue;
         /*if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {  
             return Boolean.valueOf(hssfCell.getBooleanCellValue());  
         } else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {  
             String cellValue = "";  
             if(HSSFDateUtil.isCellDateFormatted(hssfCell)){                  
                 Date date = HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue());  
                 cellValue = sdf.format(date);  
             }else{  
                 DecimalFormat df = new DecimalFormat("#.##");  
                 cellValue = df.format(hssfCell.getNumericCellValue());  
                 String strArr = cellValue.substring(cellValue.lastIndexOf(POINT)+1,cellValue.length());  
                 if(strArr.equals("00")){  
                     cellValue = cellValue.substring(0, cellValue.lastIndexOf(POINT));  
                 }    
             }  
             return cellValue;  
         } else {  
            return String.valueOf(hssfCell.getStringCellValue());  
         }  */
    }
    
    /** 
     * 单元格格式 
     * @param xssfCell 
     * @return 
     */  
    @SuppressWarnings("deprecation")
	public static Object getXValue(XSSFCell xssfCell){
    	String cellValue = "";
    	
    	if ( xssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN ) {  
            return Boolean.valueOf(xssfCell.getBooleanCellValue());  
        }
    	if ( xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC ) {
    		return Integer.valueOf((int) xssfCell.getNumericCellValue());
    	}  
    	if ( xssfCell.getCellType() == Cell.CELL_TYPE_STRING ) {
    		return String.valueOf(xssfCell.getStringCellValue());
		}
        if ( XSSFDateUtil.isCellDateFormatted(xssfCell) ){  
            Date date = XSSFDateUtil.getJavaDate(xssfCell.getNumericCellValue());  
            cellValue = sdf.format(date);
        } else {
        	DecimalFormat df = new DecimalFormat("#.##");  
        	cellValue = df.format(xssfCell.getNumericCellValue()); 
            String strArr = cellValue.substring(cellValue.lastIndexOf(POINT)+1,cellValue.length());  
            if(strArr.equals("00")){  
                cellValue = cellValue.substring(0, cellValue.lastIndexOf(POINT));  
            }    
        }
        return cellValue;
         /*if (xssfCell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {  
             return String.valueOf(xssfCell.getBooleanCellValue());  
         } else if (xssfCell.getCellType() == Cell.CELL_TYPE_NUMERIC) {  
             String cellValue = "";  
             if(XSSFDateUtil.isCellDateFormatted(xssfCell)){  
                 Date date = XSSFDateUtil.getJavaDate(xssfCell.getNumericCellValue());  
                 cellValue = sdf.format(date);
             }else{  
                 DecimalFormat df = new DecimalFormat("#.##");  
                 cellValue = df.format(xssfCell.getNumericCellValue());  
                 String strArr = cellValue.substring(cellValue.lastIndexOf(POINT)+1,cellValue.length());  
                 if(strArr.equals("00")){  
                     cellValue = cellValue.substring(0, cellValue.lastIndexOf(POINT));  
                 }    
             }  
             return cellValue;  
         } else {  
            return String.valueOf(xssfCell.getStringCellValue());  
         }*/  
    }     
	
    /** 
	 * 自定义xssf日期工具类 
	 * @author lp 
	 * 
	 */  
	static class XSSFDateUtil extends DateUtil{  
	    protected static int absoluteDay(Calendar cal, boolean use1904windowing) {    
	        return DateUtil.absoluteDay(cal, use1904windowing);    
	    }   
	}
}
