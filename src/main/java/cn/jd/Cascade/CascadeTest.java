package cn.jd.Cascade;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CascadeTest {

    @Test
    @RequestMapping("/cascade")   // http://localhost:8080/cascade
    @ResponseBody
    public Object CascadeTest() throws Exception{

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
	        int id = area.getID();
	        int topID = area.getTopID();
            //如果顶级id为0，即为省级单位
            if (topID == 0){
                //获取下属单位
	            List<Area> downList = getDownList(areas, id);
	            area.setDownList(downList);

	            //添加到省列表
                provinceList.add(area);
            }
        }

        //最终的省份列表
	    System.out.println(provinceList);
        return provinceList;
    }



    /**
     * 获取下属单位
     */
    private List<Area> getDownList(List<Area> areas,int id){
        ArrayList<Area> cityList = new ArrayList<>();

	    for (Area area : areas) {

	    	//市级单位
	    	if (area.getTopID() == id){
	    		//TODO 【重点】递归获取县级列表
			    List<Area> downList = getDownList(areas, area.getID());
			    area.setDownList(downList);

			    cityList.add(area);
		    }
	    }

        return cityList;
    }


}
