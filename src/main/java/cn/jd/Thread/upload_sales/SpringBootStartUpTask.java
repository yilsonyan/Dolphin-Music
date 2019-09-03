package cn.jd.Thread.upload_sales;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
/**
 * spring boot 容器加载后自动监听
 * @author  yanbinyuan
 * @date    2019年7月1日
 * @version jdk1.8
 */
@Component
public class SpringBootStartUpTask implements CommandLineRunner {

    //日志
    private final Logger logger = LoggerFactory.getLogger(SpringBootStartUpTask.class);

    @Autowired
    UploadSalesTaskService uploadSalesTaskService;

    /**
     * run方法指定项目启动后指定执行的任务
     * @param args
     */
    @Override
    public void run(String... args) {
        try {
            //Runtime.getRuntime().exec("cmd   /c   start   http://localhost:8080");


            //开启销售记录上传线程
            uploadSalesTaskService.start();

        } catch (Exception ex) {
            ex.printStackTrace();
            logger.error("系统初始化异常！{}",ex.getMessage());
        }
    }

}