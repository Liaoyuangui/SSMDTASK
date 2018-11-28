package com.lyg.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class ImportExcelUtil {
    //.xls的后缀文件
    private final static String SUFFIX_XLS = ".xls";
    //.xlsx的后缀文件
    private final static String SUFFIX_XLSX = ".xlsx";


    /**
     * 读取Excel表格表头的内容
     * 返回格式如：[[id, name], [id1, name1], [num, age]]
     * 多个sheet会一起返回
     * @param file  excel文件
     * @return String 表头内容的数组
     */
    public static List<List<String>> getExcelTitle(MultipartFile file) throws  Exception{
        InputStream is = null;
        String fileName = "";
        if (file.isEmpty()) {
            throw new Exception("文件不存在！");
        }
        is = file.getInputStream();
        fileName = file.getOriginalFilename();
        List<List<String>> titleList = null;
        //创建Excel工作薄
        Workbook work = getWorkbook(is,fileName);

        if(null == work){
            throw new Exception("创建Excel工作薄为空！");
        }
        //sheet表
        Sheet sheet = null;
        //行
        Row row = null;
        //列
        Cell cell = null;

        titleList = new ArrayList<List<String>>();
        //遍历Excel中所有的sheet(表)，一般excel默认有3个sheet表
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            //获取到单个表
            sheet = work.getSheetAt(i);
            if(sheet == null){
                continue;
            }
            row = sheet.getRow(0); //表头，第一行
            if(row == null){
                continue;
            }
            List<String> rowList = new ArrayList<String>();
            for (int n = row.getFirstCellNum(); n < row.getLastCellNum(); n++) {
                cell = row.getCell(n);
                rowList.add(String.valueOf(getCellValue(cell)));
            }
            titleList.add(rowList);
        }
        is.close();
        return titleList;
    }

    /**
     * 获取Excel文件的内容，自动过滤第一行表头
     * 封装成List<List<Object>> 格式返回
     * [[5, 张三], [6, 丽丽], [001, 张三丰], [002, 张无忌], [132001, 盖伦], [13002, 琴女]]
     * 多个sheet的数据会一起返回
     * @param file excel文件
     * @return
     * @throws Exception
     */
    public static List<List<Object>> getListFromExecl(MultipartFile file) throws Exception{
        InputStream is = null;
        String fileName = "";
        if (file.isEmpty()) {
            throw new Exception("文件不存在！");
        }
        is = file.getInputStream();
        fileName = file.getOriginalFilename();
        //存放数据的list集合
        List<List<Object>> dataList = null;

        //创建Excel工作薄
        Workbook work = getWorkbook(is,fileName);

        if(null == work){
            throw new Exception("创建Excel工作薄为空！");
        }
        //sheet表
        Sheet sheet = null;
        //行
        Row row = null;
        //列
        Cell cell = null;

        dataList = new ArrayList<List<Object>>();
        //遍历Excel中所有的sheet(表)，一般excel默认有3个sheet表
        for (int i = 0; i < work.getNumberOfSheets(); i++) {
            //获取到单个表
            sheet = work.getSheetAt(i);
            if(sheet == null){
                continue;
            }
            //遍历当前sheet中的所有行，<= 经测试发现不要 = 获取不到最后一行的数据
            //数据从第二行开始，第一行为表头
            for (int j = sheet.getFirstRowNum()+1; j <= sheet.getLastRowNum(); j++) {
                //获取到其中的单行数据
                row = sheet.getRow(j);
                if(row == null){
                    continue;
                }
                //定义一个集合存取一行的数据
                List<Object> rowList = new ArrayList<Object>();
                //遍历所有的列,得到一行的内容
                for (int n = row.getFirstCellNum(); n < row.getLastCellNum(); n++) {
                    cell = row.getCell(n);
                    rowList.add(getCellValue(cell));
                }
                dataList.add(rowList);
            }
        }
        is.close();
        return dataList;
    }


    /**
     * 获取Excel中sheet1表中的数据
     * 表头与数据库中的字段一致
     * [[{title0=num}, {title1=name}], [{num=3}, {name=lisi}], [{num=4}, {name=wangwu}]]
     * @param file  excel文件
     * @return
     */
    public static List<List<Map<String,Object>>> getListFromExcelSheet1(MultipartFile file) throws  Exception{
        InputStream is = null;
        String fileName = "";
        if (file.isEmpty()) {
            throw new Exception("文件不存在！");
        }
        is = file.getInputStream();
        fileName = file.getOriginalFilename();
        String[] title1Str = null;
        //创建Excel工作薄
        Workbook work = getWorkbook(is,fileName);
        if(null == work){
            throw new Exception("创建Excel工作薄为空！");
        }
        //sheet表
        Sheet sheet = null;
        //行
        Row row = null;
        //列
        Cell cell = null;
        //获取到第一个表
        sheet = work.getSheetAt(0);
        if(sheet == null){
            throw new Exception("获取Excel表异常");
        }
        //获取数据
        List<List<Map<String,Object>>> dataList = new ArrayList<List<Map<String,Object>>>();
        title1Str = new String[sheet.getLastRowNum()];
        for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
            //获取到其中的单行数据
            row = sheet.getRow(j);
            if(row == null){
                continue;
            }
            //定义一个集合存取一行的数据
            List<Map<String,Object>> rowDataList = new ArrayList<Map<String,Object>>();
            //遍历所有的列,得到一行的内容
            for (int k = row.getFirstCellNum(); k < row.getLastCellNum(); k++) {
                cell = row.getCell(k);
                Map<String,Object> dataMap = new HashMap<String,Object>();
                if(j == sheet.getFirstRowNum()){
                    //表头
                    title1Str[k] =  String.valueOf(getCellValue(cell));
                    dataMap.put("title"+k, title1Str[k]);
                }else{
                    //数据
                    dataMap.put(title1Str[k],getCellValue(cell));
                }
                rowDataList.add(dataMap);
                dataMap = null;//清空
            }
            //把表头和数据添加到集合中
            dataList.add(rowDataList);
        }
        title1Str = null; //清空
        return dataList;
    }

    /**
     * 获取工作簿实例
     * @param is
     * @param fileName
     * @return
     * @throws Exception
     */
    private static  Workbook getWorkbook(InputStream is,String fileName) throws Exception{
        Workbook wb = null;
        //获取文件后缀
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        if(SUFFIX_XLS.equals(fileType)){
            wb = new HSSFWorkbook(is);
        }else if(SUFFIX_XLSX.equals(fileType)){
            wb = new XSSFWorkbook(is);
        }else{
            throw new Exception("请上传.xls的文件！");
        }
        return wb;
    }

    /**
     * 对表格中数值进行格式化
     * @param cell
     * @return
     */
    private static  Object getCellValue(Cell cell){
        String strCell = "";
        if (cell == null) {
            return "";
        }
        switch (cell.getCellType()) {
            case XSSFCell.CELL_TYPE_STRING://文本
                strCell = cell.getStringCellValue();
                break;
            case XSSFCell.CELL_TYPE_NUMERIC://日期或数字
                if (DateUtil.isCellDateFormatted(cell)) {
                    //  如果是date类型则 ，获取该cell的date值
                    strCell = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(DateUtil.getJavaDate(cell.getNumericCellValue()));
                } else { // 纯数字
                    strCell = String.valueOf(cell.getNumericCellValue());
                    DecimalFormat df = new DecimalFormat("#.#########");
                    strCell=df.format(Double.valueOf(strCell));
                }
                break;
            case XSSFCell.CELL_TYPE_BOOLEAN://boolean型
                strCell = String.valueOf(cell.getBooleanCellValue());
                break;
            case XSSFCell.CELL_TYPE_BLANK: //空白
                strCell = "";
                break;
            case XSSFCell.CELL_TYPE_FORMULA: //公式
                strCell = String.valueOf(cell.getNumericCellValue());
                DecimalFormat df = new DecimalFormat("#.#########");
                strCell=df.format(Double.valueOf(strCell));
                break;
            default:
                strCell = "";
                break;
        }
        if (strCell.equals("") || strCell == null) {
            return "";
        }
        return strCell;
    }

}
