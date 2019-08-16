package cn.jd.excel.apache_poi;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.util.CellRangeAddress;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;

public class Excel_Create {


    /**
     * POI-EXCEL入门程序
     * 读取文件同样还是使用这几个对象，只是把相应的createXXX方法变成了getXXX方法即可
     */
    public static void main(String[] args) throws IOException {
        //创建HSSFWorkbook对象
        HSSFWorkbook wb = new HSSFWorkbook();

        //创建HSSFSheet对象
        HSSFSheet sheet = wb.createSheet("sheet1");

        //创建HSSFRow对象
        HSSFRow row = sheet.createRow(0);

        //创建HSSFCell对象
        HSSFCell cell = row.createCell(0);

        //设置单元格的值
        cell.setCellValue("单元格中的中文");

        //输出Excel文件
        FileOutputStream output = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\workbook.xls");
        wb.write(output);
        output.flush();
    }


    /**
     * 测试文件输出、下载输出
     *
     * @throws IOException
     */
    @Test
    public void testExcel1() throws IOException {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("成绩表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("学员考试成绩一览表");
        //合并单元格CellRangeAddress构造参数依次表示：起始行，截至行，起始列， 截至列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));

        //在sheet里创建第二行
        HSSFRow row2 = sheet.createRow(1);
        //创建单元格并设置单元格内容
        row2.createCell(0).setCellValue("姓名");
        row2.createCell(1).setCellValue("班级");
        row2.createCell(2).setCellValue("笔试成绩");
        row2.createCell(3).setCellValue("机试成绩");

        //在sheet里创建第三行
        HSSFRow row3 = sheet.createRow(2);
        row3.createCell(0).setCellValue("李明");
        row3.createCell(1).setCellValue("As178");
        row3.createCell(2).setCellValue(87);
        row3.createCell(3).setCellValue(78);

        //输出Excel文件
        /*OutputStream output = response.getOutputStream();
        response.reset();
        response.setHeader("Content-disposition", "attachment; filename=details.xls");
        response.setContentType("application/msexcel");*/

        String filePath = "C:\\Users\\Administrator\\Desktop\\workbook.xls";
        FileOutputStream output = new FileOutputStream(filePath);
        wb.write(output);
        output.close();

        Runtime.getRuntime().exec("cmd /c start " + filePath);
    }


    /**
     * 测试高、宽、合并单元格
     *
     * @throws IOException
     */
    @Test
    public void testExcel2() throws IOException {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();
        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("成绩表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("学员考试成绩一览表");

        //设置缺省列高
        sheet.setDefaultRowHeightInPoints(20);
        //设置缺省列宽
        sheet.setDefaultColumnWidth(20);
        //设置指定列的列宽，256 * 50这种写法是因为width参数单位是单个字符的256分之一
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 5);

        String filePath = "C:\\Users\\Administrator\\Desktop\\workbook.xls";
        FileOutputStream output = new FileOutputStream(filePath);
        wb.write(output);
        output.close();

        Runtime.getRuntime().exec("cmd /c start " + filePath);
    }


    /**
     * 测试单元格样式
     *
     * @throws IOException
     */
    @Test
    public void testExcel3() throws IOException {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();


        HSSFCellStyle cellStyle = wb.createCellStyle();
        // 设置单元格的横向和纵向对齐方式，具体参数就不列了，参考HSSFCellStyle

        cellStyle.setAlignment(HSSFCellStyle.ALIGN_JUSTIFY);

        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);

         /* 设置单元格的填充方式，以及前景颜色和背景颜色

          三点注意：

          1.如果需要前景颜色或背景颜色，一定要指定填充方式，两者顺序无所谓；

          2.如果同时存在前景颜色和背景颜色，前景颜色的设置要写在前面；

          3.前景颜色不是字体颜色。

         */

        //设置填充方式(填充图案)

        cellStyle.setFillPattern(HSSFCellStyle.DIAMONDS);

        //设置前景色

        cellStyle.setFillForegroundColor(HSSFColor.RED.index);

        //设置背景颜色

        cellStyle.setFillBackgroundColor(HSSFColor.LIGHT_YELLOW.index);

        // 设置单元格底部的边框及其样式和颜色

        // 这里仅设置了底边边框，左边框、右边框和顶边框同理可设

        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_SLANTED_DASH_DOT);

        cellStyle.setBottomBorderColor(HSSFColor.DARK_RED.index);

        //设置日期型数据的显示样式

        cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));


        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("成绩表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("学员考试成绩一览表");


        //将样式应用到行，但有些样式只对单元格起作用
        cell.setCellStyle(cellStyle);
        row1.setRowStyle(cellStyle);

        //设置缺省列高
        sheet.setDefaultRowHeightInPoints(20);
        //设置缺省列宽
        sheet.setDefaultColumnWidth(20);
        //设置指定列的列宽，256 * 50这种写法是因为width参数单位是单个字符的256分之一
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 5);

        String filePath = "C:\\Users\\Administrator\\Desktop\\workbook.xls";
        FileOutputStream output = new FileOutputStream(filePath);
        wb.write(output);
        output.close();

        Runtime.getRuntime().exec("cmd /c start " + filePath);
    }


    /**
     * 测试字体
     *
     * @throws IOException
     */
    @Test
    public void testExcel4() throws IOException {
        //创建HSSFWorkbook对象(excel的文档对象)
        HSSFWorkbook wb = new HSSFWorkbook();


        HSSFFont fontStyle = wb.createFont();
        //设置字体样式
        fontStyle.setFontName("宋体");
        //设置字体高度
        fontStyle.setFontHeightInPoints((short) 20);

        //设置字体颜色
        fontStyle.setColor(HSSFColor.BLUE.index);

        //设置粗体
        fontStyle.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        //设置斜体
        fontStyle.setItalic(true);

        //设置下划线
        fontStyle.setUnderline(HSSFFont.U_SINGLE);


        //建立新的sheet对象（excel的表单）
        HSSFSheet sheet = wb.createSheet("成绩表");
        //在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
        HSSFRow row1 = sheet.createRow(0);
        //创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
        HSSFCell cell = row1.createCell(0);
        //设置单元格内容
        cell.setCellValue("学员考试成绩一览表");

        //字体也是单元格格式的一部分，所以从属于HSSFCellStyle
        HSSFCellStyle cellStyle = wb.createCellStyle();
        // 将字体对象赋值给单元格样式对象
        cellStyle.setFont(fontStyle);
        // 将单元格样式应用于单元格
        cell.setCellStyle(cellStyle);


        //设置缺省列高
        sheet.setDefaultRowHeightInPoints(20);
        //设置缺省列宽
        sheet.setDefaultColumnWidth(20);
        //设置指定列的列宽，256 * 50这种写法是因为width参数单位是单个字符的256分之一
        sheet.setColumnWidth(cell.getColumnIndex(), 256 * 5);

        String filePath = "C:\\Users\\Administrator\\Desktop\\workbook.xls";
        FileOutputStream output = new FileOutputStream(filePath);
        wb.write(output);
        output.close();

        Runtime.getRuntime().exec("cmd /c start " + filePath);
    }

}
