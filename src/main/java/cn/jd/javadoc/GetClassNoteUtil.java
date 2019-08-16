package cn.jd.javadoc;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GetClassNoteUtil {


    @Test
    public void test1(){
        String note = getNote(this.getClass());
    }


    /**
     * 获取注释的内容
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> String getNote(Class<T> clazz){
        StringBuilder note = new StringBuilder();
        try {
            //获取字节码的文件路径，创建流
            //只能获取编译后的class文件
            /*String path = clazz.getClassLoader().getResource("").getPath();
            String className = clazz.getName();
            String file = path + className + ".class";*/


            String file = "C:\\Users\\Administrator\\Desktop\\Resume_Point\\src\\main\\java\\cn.jd.javadoc\\JavaDoc.java";

            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(file)));

            String readLine;


            //每次读取一行
            while ((readLine = bufferedReader.readLine()) != null){
                //读取到了注释内部
                boolean innerNote = false;

                //如果以 "/**" 开始，开始记录注释内容
                if (readLine.contains("/**")){
                    innerNote = true;
                    note.append(readLine);note.append(readLine);
                }else {
                    //如果以 "*/" 结束，说明到了注释末尾
                    if (readLine.contains("*/")){
                        innerNote = false;
                    }else {
                        //不以 "/**" 开始，也不以 "*/" 结束
                        //如果之前已经在注释内部，没读取完毕，否则不是注释内容
                        if (readLine.contains("*") && innerNote){
                            note.append(readLine);
                        }
                    }
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return note.toString();
    }


}
