package excel.alibaba_easyExcel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * ExcelUtil:excel文件的导入导出工具类
 *
 * @author yumaochun
 * @date  2016年6月30日
 * @version  jdk1.8
 *
 */
public class ExcelUtil {
	
    /*
     * 表头的高度
     */
    private static short headerHeight=30*20;
    
    /**
     * 行的高度
     */
    private static short rowHeight=20*20;

    
    public static void main(String[] args) throws Exception {
//        String sheetName="员工列表";
//        //属性字段及excel头部列名
//        String[] columnArr={"id","code","name"};
//        String[] headerAtrr={"序号","编号","名称"};
//        int[] colWidthArr={10,20,20};
//        List<GwAreaModel> list=new ArrayList<>();
//        GwAreaModel area=new GwAreaModel();
//        area.setId(1);
//        area.setCode(10001);
//        area.setName("四川省");
//        list.add(area);
//        GwAreaModel area1=new GwAreaModel();
//        area1.setId(2);
//        area1.setCode(10003);
//        area1.setName("云南省");
//        list.add(area1);
       // exportExcel(sheetName,list,columnArr,headerAtrr,colWidthArr);
       
    }
    
    /**
     * 
     * exportExcel:导出excel数据
     *
     * @author yumaochun,huangxinyhu
     * @date 2016年7月1日,2018-12-14修改
     * @param sheetName          excel名称
     * @param list               导出的数据集合
     * @param headerAtrr          表头信息集合
     * @param colWidthArr        列宽度数据
     * @return     返回：导出数据是否成功
     * @throws IOException 
     */
    public static <T> boolean exportExcel(String sheetName, List<T> list, String[] columnArr, String[] headerAtrr,int[] colWidthArr,HttpServletRequest request,HttpServletResponse response) throws IOException{
    	boolean flag=false;
    	if(columnArr==null || headerAtrr==null || colWidthArr==null){
    		//logger.info("属性对应数据、表头数组或者单元格数组宽度数组为空");
    		return flag;
    	}
    	
    	if(!(columnArr.length==headerAtrr.length && headerAtrr.length==colWidthArr.length)){
    		//logger.info("属性对应数据、表头数组或者单元格数组宽度数组长度不一致");
    		return flag;
    	}
    	
        // 创建表格
        HSSFWorkbook wb = new HSSFWorkbook();//产生工作簿对象
        HSSFSheet sheet = wb.createSheet();//产生工作表对象
        //为了工作表能支持中文，设置字符编码为UTF_16
        wb.setSheetName(0,sheetName);
        //产生一行
        HSSFRow row = sheet.createRow(0);
        row.setHeight(headerHeight); 
        
        //创建一列
        HSSFCell cell = row.createCell(0);
        //获取样式
        HSSFCellStyle style=getCellStyle(wb,true);
        
        // 定义表头
        for (int i=0;i<headerAtrr.length;i++) {
            cell = row.createCell(i);
            //设置单元格内容为字符串型
            cell.setCellType(HSSFCell.CELL_TYPE_STRING);
            //设置列名称
            cell.setCellValue(headerAtrr[i]);
            
            //设置列样式
            cell.setCellStyle(style);
        }

        //设置excel表格的列宽度
        for(int i=0;i<colWidthArr.length;i++){
            //设置列宽度
            sheet.setColumnWidth(i, colWidthArr[i]*256);
        }
       
        //获取样式
        style=getCellStyle(wb,false);
        //遍历list数据集合
        for(int i=0;i<list.size();i++){
            T t = list.get(i);
            //创建新行
            HSSFRow newRow = sheet.createRow(i + 1);
            newRow.setHeight(rowHeight);//设置行高
            for (int j=0;j<columnArr.length;j++) {
                try {
                    String attribute = columnArr[j];//属性名
                    Field f;//字段对象
                    Method method = t.getClass().getMethod("get" + getSub(attribute));
                    //属性值
                    Object fvalue = method.invoke(t, null);
                    f = getClassField(t.getClass(), attribute);
                    //下面方法无法获取父类属性
//                  f = t.getClass().getDeclaredField(attribute);
                    f.setAccessible(true);
                    //获取属性值
                    //fvalue = f.get(t);

                    //创建新列
                    HSSFCell newCell = newRow.createCell(j);
                    //设置列值
                    if(fvalue instanceof String){
                        newCell.setCellValue((String) fvalue);
                    }else if(fvalue instanceof Integer){
                        newCell.setCellValue((int) fvalue);
                    }else if(fvalue instanceof Double){
                        newCell.setCellValue((double) fvalue);
                    }else if(fvalue instanceof Long){
                        newCell.setCellValue((long) fvalue);
                    }else if(fvalue instanceof Date){
                        newCell.setCellValue(new SimpleDateFormat("yyyy-MM-dd").format((Date) fvalue));
                    }else{
                        newCell.setCellValue(fvalue==null?null:fvalue.toString());
                    }
                    //设置列样式
                    newCell.setCellStyle(style);
                    flag=true;
                } catch (SecurityException e) {
                    e.printStackTrace();
                }catch (IllegalArgumentException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }

        }
        // 保存临时表格到本地，再下载
        String xlsPath =request.getSession().getServletContext().getRealPath("/");
        System.out.println("=="+xlsPath);
        File file = new File(xlsPath + File.separator + "excel");
        if (!file.exists()) {
            file.mkdirs();
        }
        //生成excel的文件路径
        String filePath=xlsPath + File.separator + "excel" + File.separator + "example.xls";
        file = new File(filePath);
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(file.getAbsolutePath());
            wb.write(fout);
            fout.flush();
            fout.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag){
            downLoadExcel(filePath,sheetName,response);
        }
        
       
       
        return flag;
    }

    public static String getSub(String s){
        String first = s.substring(0, 1).toUpperCase();
        String rest = s.substring(1, s.length());
       return new StringBuffer(first).append(rest).toString();
    }
    
    /** 
     * 这个方法，是最重要的，关键的实现在这里面 
     *  
     * @param aClazz 
     * @param aFieldName 
     * @return 
     */  
    private static Field getClassField(Class aClazz, String aFieldName) {  
	    Field[] declaredFields = aClazz.getDeclaredFields();  
	    for (Field field : declaredFields) {  
	        // 注意：这里判断的方式，是用字符串的比较。很傻瓜，但能跑。要直接返回Field。我试验中，尝试返回Class，然后用getDeclaredField(String fieldName)，但是，失败了  
	        if (field.getName().equals(aFieldName)) {  
	        return field;// define in this class  
	        }  
	    }  
	  
	    Class superclass = aClazz.getSuperclass();  
	    if (superclass != null) {// 简单的递归一下  
	        return getClassField(superclass, aFieldName);  
	    }  
	    return null;  
    }  
    
    /**
     * 
     * getCellStyle:获取列的样式
     *
     * @author yumaochun
     * @date 2016年7月1日
     * @param wb  HSSFWorkbook
     * @param isHeadCell     是否是表头样式
     * @return
     */
    public static HSSFCellStyle getCellStyle(HSSFWorkbook wb,boolean isHeadCell){
        //产生第一个单元格
        HSSFCellStyle style = wb.createCellStyle();
        // 居中
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
       
        // 边框
        style.setBorderBottom(HSSFCellStyle.BORDER_THIN); //下边框
        style.setBorderLeft(HSSFCellStyle.BORDER_THIN);//左边框
        style.setBorderTop(HSSFCellStyle.BORDER_THIN);//上边框
        style.setBorderRight(HSSFCellStyle.BORDER_THIN);//右边框
        // 单元格自动换行
        style.setWrapText(true);
        // 字体
        HSSFFont font = wb.createFont();
        //如果是表头列
        if(isHeadCell){
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 10);
            font.setBoldweight((short)30);
            style.setFont(font);
            //设置单元格颜色
            style.setFillPattern(XSSFCellStyle.FINE_DOTS );
            style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            style.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.getIndex());
        }else{
            font.setFontName("宋体");
            font.setFontHeightInPoints((short) 10);
            style.setFont(font);
        }
        return style;
    }
    /**
     * 
     * downLoadExcel:下载excel文件
     *
     * @author yumaochun
     * @date 2016年7月1日
     * @param filePath       文件路径
     * @param excelName      导出的excel名称
     * @param response       response
     * @throws IOException 
     */
    public static void downLoadExcel(String filePath,String excelName,HttpServletResponse response) throws IOException{
        InputStream inputStream;
        OutputStream os= new BufferedOutputStream(response.getOutputStream());  
        try {
            inputStream = new FileInputStream(filePath);
            //设置导出文件名   
            String contentType = "application/vnd.ms-excel;charset=utf-8";
            String contentDisposition = "attachment; filename="+ URLEncoder.encode(excelName, "UTF-8") + ".xls";
            response.setContentType(contentType);
            response.addHeader("Content-Disposition", contentDisposition);
            byte[] b = new byte[1024];
            int len;
            try {
                while ((len = inputStream.read(b)) > 0) {
                    os.write(b, 0, len);
                }
                os.flush();  
                os.close();  
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 
     * importExcel:将excel中的数据转换到对应的实体类集合中
     *
     * @author yumaochun
     * @date 2016年8月3日
     * @param t
     * @param columnArr         属性字段列名数组
     * @param headerAtrr        表头名称数组
     * @param filePath          待导入的excel文件路径
     * @return          返回：导入的实体类对象集合
     * @throws Exception
     */
    public static <T> List<T> importExcel(Class<T> clazz,String[] columnArr, String[] headerAtrr,String filePath) throws Exception{
        //excel数据集合
        List<T> list=new ArrayList<T>();
        //读取excel文件
        InputStream is = new FileInputStream(filePath);
        //创建hssf
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(is);
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 1; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                HSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow == null) {
                    continue;
                }
                //实例化对象
                T obj=(T) clazz.newInstance();
                for (int i = 0; i < headerAtrr.length; i++) {
                	//cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    //列对象
                    HSSFCell cell = hssfRow.getCell(i);
                    //cell.setCellType(HSSFCell.CELL_TYPE_STRING);
                    if (cell == null) {
                        continue;
                    }
                    //获取列值
                    String cellVal=getValue(cell);
                    //属性名
                    String attribute = columnArr[i];
                    //字段对象
                    Field field = clazz.getDeclaredField(attribute);
                    //允许访问私有类型
                    field.setAccessible(true);
                    //属性字段类型名称
                    String className = field.getType().getSimpleName();
                    //字符串
                    if(className.equalsIgnoreCase("String")){
                        //为字段赋值
                        field.set(obj, cellVal);
                    }
                    //integer
                    else if(className.equalsIgnoreCase("Integer")){
                        try{
                            int val=(int)Double.parseDouble(cellVal);
                            //为字段赋值
                            field.set(obj, val);
                        }catch (Exception e){
                            throw new RuntimeException("第"+rowNum+"行："+"第"+(i+1)+"列:模板格式错误!");
                        }
                    }
                    //bigDecimal
                    else if(className.equalsIgnoreCase("BigDecimal")){
                        try{
                            BigDecimal val=new BigDecimal(cellVal);
                            System.out.println(cellVal+"te");
                            //为字段赋值
                            field.set(obj, val);
                        }catch (Exception e){
                            throw new RuntimeException("第"+rowNum+"行："+"第"+(i+1)+"列:模板格式错误!");
                        }
                    }
                    //布尔型
                    else if(className.equalsIgnoreCase("Boolen")){
                        try{
                            Boolean val=new Boolean(cellVal);
                            //为字段赋值
                            field.set(obj, val);
                        }catch (Exception e){
                            throw new RuntimeException("第"+rowNum+"行："+"第"+(i+1)+"列:模板格式错误!");
                        }
                    }
                }
                //将对象放入集合中
                list.add(obj);
            }
        } 
        return list;
    }
    /**
     * 得到Excel表中的值
     * 
     * @param hssfCell
     *            Excel中的每一个格子
     * @return Excel中每一个格子中的值
     *
     */
    @SuppressWarnings({ "static-access" })
    private static String getValue(HSSFCell hssfCell) {
    	String inputValue="";
        if (hssfCell.getCellType() == hssfCell.CELL_TYPE_BOOLEAN) {
            // 返回布尔类型的值
        	inputValue=String.valueOf(hssfCell.getBooleanCellValue());
            return inputValue;
        } 
        else if (hssfCell.getCellType() == hssfCell.CELL_TYPE_NUMERIC) {
//        	long longVal = Math.round(hssfCell.getNumericCellValue());  
        	inputValue=String.valueOf(hssfCell.getNumericCellValue());
        	// 返回数值类型的值
            //return String.valueOf(hssfCell.getNumericCellValue());
            return inputValue;
        }
        else {
            // 返回字符串类型的值
        	inputValue=String.valueOf(hssfCell.getStringCellValue());
            return inputValue;
        }
    }
}
