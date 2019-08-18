package cn.jd;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class HandleTextTest {


    /**
     * 去掉日志记录
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\Desktop\\alpos1.cn.jd.sql")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\alpos2.cn.jd.sql")));

        List<String> newList = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.startsWith("INSERT INTO `cpos_logger_record`")) {
                newList.add(line);
            }
        }
        bufferedReader.close();

        for (String newLine : newList) {
            bufferedWriter.write(newLine + "\r\n");
        }

        bufferedWriter.flush();
        bufferedWriter.close();
    }


    /**
     * 去掉博客园网站拷贝的代码每一行空出一行数字行号
     */
    @Test
    public void testExcludeNumber() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\Desktop\\1.txt")));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\2.txt")));
            List<String> newList = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String pattern = "^[0-9]*$";

                boolean isMatch = Pattern.matches(pattern, line.trim());

                if (!isMatch) {
                    newList.add(line);
                }
            }
            bufferedReader.close();
            for (String newLine : newList) {
                bufferedWriter.write(newLine + "\r\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 转换流处理 redis 配置文件编码问题
     */
    @Test
    public void testPropertiesCharset() {
        try {
            BufferedReader bufferedReader =
                    new BufferedReader(
                            new InputStreamReader(
                                    new FileInputStream("/Users/beyond/IdeaProjects/Resume_Point/src/main/resources/redis-sentinel/redis.properties")
                                    , "GBK"
                            )
                    );

            BufferedWriter bufferedWriter =
                    new BufferedWriter(
                            new OutputStreamWriter(
                                    new FileOutputStream("/Users/beyond/IdeaProjects/Resume_Point/src/main/resources/redis-sentinel/redis_utf8.properties")
                                    , "utf-8"
                            )
                    );

            List<String> newList = new ArrayList<>();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                newList.add(line);
            }
            bufferedReader.close();
            for (String newLine : newList) {
                bufferedWriter.write(newLine + "\r\n");
            }

            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
