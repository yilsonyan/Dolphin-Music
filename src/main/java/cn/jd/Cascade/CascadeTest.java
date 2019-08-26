package cn.jd.Cascade;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CascadeTest {

    @Test
    public void CascadeTest() throws Exception{

        //获取文件创建流
        String path = CascadeTest.class.getClassLoader().getResource("address.json").getPath();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path)));

        //读取文件
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            sb.append(line);
        }
        bufferedReader.close();

        //文件转换成对象列表
        List<Area> areas = JSON.parseArray(sb.toString(), Area.class);

        ArrayList<Object> provinceList = new ArrayList<>();

        for (Area area : areas) {
            int topID = area.getTopID();
            //如果顶级id为0，即为省级单位
            if (topID == 0){
                //获取下属单位
                getDown(areas);


                //添加到省列表
                provinceList.add(area);
            }
        }
    }

    /**
     * 获取下属单位
     */
    private List getDown(List areas){
        ArrayList<Object> list = new ArrayList<>();


        return list;
    }


}
