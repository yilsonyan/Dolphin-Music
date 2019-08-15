package jdk8_features;

import org.junit.Test;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;

public class Test_try_with_resource {

    /**
     * try-with-resource自动关闭资源，并不是JVM虚拟机的新增功能，只是JDK实现了一个语法糖，
     * 当你将上面代码反编译后会发现，其实对JVM虚拟机而言，它看到的依然是之前的写法
     */
    @Test
    public void test1(){
        try (FileInputStream inputStream = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\新版本、ribao.txt"))) {
            System.out.println(inputStream.read());

            FileDescriptor fd = inputStream.getFD();
            String s = fd.toString();


            System.out.println(s);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }



}
