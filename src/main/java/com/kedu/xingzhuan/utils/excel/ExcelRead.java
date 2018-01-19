package com.kedu.xingzhuan.utils.excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class ExcelRead {
	
	public static int totalRows; //sheet中总行数  
    public static int totalCells; //每一行总单元格数 

    /**
     * Description:读文件的头列
     * @param file	文件
     * @param rowStart	起始行
     * @param rowEnd	结束行，默认填null
     * @param colStart 起始列，默认填null
     * @param colEnd	结束列，默认填null
     * @return
     * @throws IOException
     * @author around
     * @date 2018-1-9
     */
    public static List<Object> readExcelHead(MultipartFile file, Integer rowStart, 
    		Integer rowEnd, Integer colStart, Integer colEnd) throws IOException {
    	return readExcel(file, rowStart, rowEnd, colStart, colEnd).get(0);
    }
    
    
    /**
     * Description:Read the Excel (.xlsx, .xls)
     * @param file	文件
     * @param rowStart	起始行
     * @param rowEnd	结束行，默认填null
     * @param colStart 起始列，默认填null
     * @param colEnd	结束列，默认填null
     * @return
     * @throws IOException
     * @author around
     * @date 2017年9月22日下午3:36:32
     */
    public static List<List<Object>> readExcel(MultipartFile file, Integer rowStart, 
    		Integer rowEnd, Integer colStart, Integer colEnd) throws IOException {  
        if( file == null || ExcelUtil.EMPTY.equals( file.getOriginalFilename().trim() ) ){  
            return null;  
        }else{
        	//获取path的后缀名
            String postfix = ExcelUtil.getPostfix(file.getOriginalFilename());  
            if(!ExcelUtil.EMPTY.equals(postfix)){  
                if(ExcelUtil.OFFICE_EXCEL_2003_POSTFIX.equals(postfix)){  
                    return readXls(file, rowStart, rowEnd, colStart, colEnd);  
                }else if(ExcelUtil.OFFICE_EXCEL_2010_POSTFIX.equals(postfix)){  
                    return readXlsx(file, rowStart, rowEnd, colStart, colEnd);  
                }else{                    
                    return null;  
                }  
            }  
        }  
        return null;  
    }  

    
    /**
     * Description:Read the Excel 2010 .xlsx
     * @param file
     * @return
     * @author around
     * @date 2017年9月15日下午5:04:30
     */
    @SuppressWarnings("resource")
	public static List<List<Object>> readXlsx(MultipartFile file, 
			Integer rowStart, Integer rowEnd, Integer colStart, Integer colEnd){  
        List<List<Object>> list = new ArrayList<List<Object>>();  
        // IO流读取文件  
        InputStream input = null;  
        XSSFWorkbook wb = null;
        XSSFSheet xssfSheet = null;
        XSSFRow xssfRow = null;
        XSSFCell cell = null;
        List<Object> rowList = null;  
        try {  
            input = file.getInputStream();  
            // 创建文档  
            wb = new XSSFWorkbook(input);                         
            // 读取sheet(页)  
            for(int numSheet=0; numSheet < wb.getNumberOfSheets(); numSheet++){  
                xssfSheet = wb.getSheetAt(numSheet);  
                if(xssfSheet == null){  
                    continue;  
                }  
                totalRows = null == rowEnd ? xssfSheet.getLastRowNum()+2 : rowEnd; 
                // 读取Row,从第row行开始  
                for(int rowNum = rowStart; rowNum < totalRows; rowNum++){  
                    xssfRow = xssfSheet.getRow(rowNum);  
                    if( xssfRow != null ){  
                        rowList = new ArrayList<Object>();
                        totalCells = null == colEnd ? xssfRow.getLastCellNum() : colEnd;  
                        // 读取列，从第一列开始  
                        for(int c = null == colStart ? 0 : colStart; c < totalCells; c++){  
                            cell = xssfRow.getCell(c);  
                            if(cell == null) {  
                                rowList.add(ExcelUtil.EMPTY);  
                                continue;  
                            }                             
                            rowList.add(ExcelUtil.getXValue(cell));  
                        }
                        if (null != rowList) list.add(rowList);
                    }
                }  
            }  
            return list;  
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {  
                input.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
    
    
    /**
     * Description:Read the Excel 2003-2007 .xls 
     * @param file
     * @return
     * @author around
     * @date 2017年9月15日下午4:57:30
     */
    @SuppressWarnings("resource")
	public static List<List<Object>> readXls(MultipartFile file, 
			Integer rowStart, Integer rowEnd, Integer colStart, Integer colEnd){   
        List<List<Object>> list = new ArrayList<List<Object>>();  
        // IO流读取文件  
        InputStream input = null;  
        HSSFWorkbook wb = null;  
        HSSFSheet hssfSheet = null;
        HSSFRow hssfRow = null;
        HSSFCell cell = null;
        List<Object> rowList = null;  
        try {  
            input = file.getInputStream();  
            // 创建文档  
            wb = new HSSFWorkbook(input);                         
            // 读取sheet(页)  
            for( int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++ ){  
                hssfSheet = wb.getSheetAt(numSheet);  
                if( hssfSheet == null ){  
                    continue ;  
                }  
                totalRows = null == rowEnd ? hssfSheet.getLastRowNum() : rowEnd;                
                // 读取Row,从第row行开始  
                for( int rowNum = rowStart; rowNum < totalRows; rowNum++ ){  
                    hssfRow = hssfSheet.getRow(rowNum);  
                    if( hssfRow!=null ){  
                        rowList = new ArrayList<Object>();  
                        totalCells = null == colEnd ? hssfRow.getLastCellNum() : colEnd;  
                        // 读取列，从第一列开始  
                        for(int c = null == colStart ? 0 : colStart; c < totalCells; c++){  
                            cell = hssfRow.getCell(c);  
                            if( cell==null ){  
                                rowList.add(ExcelUtil.EMPTY);  
                                continue;  
                            }                             
                            rowList.add(ExcelUtil.getHValue(cell));  
                        }          
                        if (null != rowList) list.add(rowList);  
                    }                     
                }  
            }  
            return list;  
        } catch (IOException e) {             
            e.printStackTrace();  
        } finally{  
            try {  
                input.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
        return null;  
    }  
}
