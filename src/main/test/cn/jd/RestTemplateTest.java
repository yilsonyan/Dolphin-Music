package cn.jd;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class RestTemplateTest {

    @Autowired
    RestTemplate restTemplate;

    @Test
    public void test1() throws Exception {

        String url = "http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=%E9%93%B6%E9%AD%82&bk_length=600";
        ResponseEntity<Map> forEntity = null;

	    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
	    String endTimeStr = "2019-09-02 00:30:00";
	    Date endTime = simpleDateFormat.parse(endTimeStr);

        do {
        	try {
		        forEntity = restTemplate.getForEntity(url, Map.class);
	        }catch (Exception e){

	        }

	        //until the deadline witch is specified
	        Date now = new Date();
	        if (now.compareTo(endTime) < 0){
		        break;
	        }

	        Thread.sleep(30 * 1000);

        }while (forEntity == null );

        //get some response,then play sound
	    if (forEntity != null){
		    Runtime.getRuntime().exec("open /Users/beyond/Downloads/YouNeedToCalmDown.mp3");
	    }
    }






}