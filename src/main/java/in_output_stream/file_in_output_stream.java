package in_output_stream;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class file_in_output_stream {



    @Test
    public void read() throws IOException, ClassNotFoundException {
        File file = new File("/Users/yilson/Desktop");

        File[] files = file.listFiles();
        for (File f : files) {
            String absolutePath = f.getAbsolutePath();
            System.out.println(absolutePath);
        }
    }



    @Test
    public void read2() throws IOException, ClassNotFoundException {
        //FileInputStream in = new FileInputStream("/Users/yilson/Desktop/01准备工具.xmind");
        //File file = new File("/Users/yilson/Desktop/01准备工具.xmind");
        File file = new File("/Users/yilson/Desktop");

        File[] files = file.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                if (pathname.isHidden()){
                    return false;
                }else {
                    return true;
                }
            }
        });
        for (File f : files) {
            String absolutePath = f.getAbsolutePath();
            System.out.println(absolutePath);
        }
    }



    @Test
    public void read3() throws IOException, ClassNotFoundException {
        FileWriter fw = new FileWriter("/Users/yilson/Desktop/test.txt",true);
        fw.write("第一行");
        fw.flush();
    }

    @Test
    public void read4() throws IOException, ClassNotFoundException {
        Properties properties = System.getProperties();
        BufferedInputStream bin = new BufferedInputStream(new FileInputStream(""));
    }




}
