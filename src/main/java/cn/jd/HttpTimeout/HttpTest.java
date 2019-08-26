package cn.jd.HttpTimeout;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;


@Controller
public class HttpTest {

    final String HOST = "http://localhost:8080/";
    final String REQUEST_RUL = "url";

    @RequestMapping("/"+REQUEST_RUL)
    @ResponseBody
    public Object url() throws Exception {
        System.out.println("into-------------------------");
        Thread.sleep(2000);
        System.out.println("end--------------------------");
        return "this is a response";
    }


    @RequestMapping("/testTimeout")
    public void testTimeout() throws IOException {

        HttpPost httpPost = new HttpPost(HOST + REQUEST_RUL);
        StringEntity entityParams = new StringEntity("", "utf-8");
        httpPost.setEntity(entityParams);
        httpPost.setHeader("Content-Type", "text/xml;charset=ISO-8859-1");

        //设置超时时间为60秒
        CloseableHttpClient client = HttpClients.createDefault();
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1 * 1000)
                .setConnectionRequestTimeout(1 * 1000)
                //.setSocketTimeout(60 * 1000)
                .setSocketTimeout(10) //如果设置过短，请求还未返回直接报错
                .build();
        httpPost.setConfig(requestConfig);

        CloseableHttpResponse response = client.execute(httpPost);
        System.out.println(response);
    }



}
