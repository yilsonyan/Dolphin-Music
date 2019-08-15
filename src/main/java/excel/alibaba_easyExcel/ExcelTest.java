package excel.alibaba_easyExcel;

import excel.apache_poi.ScoreInfo;

import java.util.List;

public class ExcelTest {

    /**
     * 单个Sheet导出、无模型映射导出
     * @param args
     */
    public static void main(String[] args) throws Exception {

        String filePath = "C:\\Users\\Administrator\\Desktop\\workbook.xls";
        String[] attrArr = {"stuName","className","rscore","lscore"};
        String[] headAttrArr = {"学员考试成绩一览表"};
        List<ScoreInfo> scoreInfos = ExcelUtil.importExcel(ScoreInfo.class, attrArr, headAttrArr, filePath);

        System.out.println(scoreInfos);
    }
}
