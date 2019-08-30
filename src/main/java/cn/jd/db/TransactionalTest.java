package cn.jd.db;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TransactionalTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 主方法里面顺序调用AB两个方法，A方法不加事务注解，B方法加了事务注解。
     * 如果不了解@Transactional 事务的传播性，可能会回答：A成功插入，B插入失败,但是实际情况却是A,B均插入成功了。
     * PROPAGATION_REQUIRED ： 支持当前事务，如果当前没有事务，就新建一个事务，这也是最常见的
     * PROPAGATION_SUPPORTS ： 支持当前事务，如果当前没有事务，就以非事务的方式执行
     * PROPAGATION_MANDATORY： 支持当前事务，如果当前没有事务，就抛异常
     * PROPAGATION_REQUIRES_NEW：新建事务，如果当前事务存在，就把当前事务挂起
     * PROPAGATION_NOT_SUPPORTED：以非事务的方式执行，如果存在当前事务，就把当前事务挂起
     * PROPAGATION_NEVER： 以非事务的方式执行，如果当前存在事务，就抛异常
     * PROPAGATION_NESTED：如果存在当前事务，则在嵌套事务内执行，如果当前没有事务，则新建一个事务
     *
     * TODO 重点
     * spring默认事务隔离级别为：PROPAGATION_REQUIRED ： 支持当前事务，没有就新建一个事务
     * A没有事务管理，则线程内的connection 有个autoCommit = true
     * B得到事务的时候，由于事务的传播性依然生效, 得到的还是A方法的commit,其autoCommit = true,故而逐条sql进行提交，即A,B都会插入
     */
    @RequestMapping("testTransactionAB") //http://localhost:8080/testTransactionAB
    public void testTransactionAB() throws Exception{
        methodA();
        methodB();
    }
    //方法A
    void methodA(){
        String insert1 = "INSERT INTO `gdws_cpos_server_3.2`.`base_system_config`(`id`, `key`, `value`, `update_time`) VALUES (1, 'string', 'string', '2019-06-20 11:25:16')";
        jdbcTemplate.execute(insert1);
    }
    //方法B
    @Transactional
    void methodB(){
        String insert2 = "INSERT INTO `gdws_cpos_server_3.2`.`base_system_config`(`id`, `key`, `value`, `update_time`) VALUES (2, 'string', 'string', '2019-06-20 11:25:16')";
        jdbcTemplate.execute(insert2);
        throw new RuntimeException("强制抛一个异常");
    }






    @Transactional
    //@Rollback(false)//JunitTest时事务自动回滚
    @RequestMapping("testTransactionAB2") // http://localhost:8080/testTransactionAB2
    public void testTransactionAB2() throws Exception{
        methodA2();
        methodB2();
    }
    //方法A
    void methodA2(){
        String insert1 = "INSERT INTO `gdws_cpos_server_3.2`.`base_system_config`(`id`, `key`, `value`, `update_time`) VALUES (1, 'string', 'string', '2019-06-20 11:25:16')";
        jdbcTemplate.execute(insert1);
    }
    //方法B
    void methodB2() throws InterruptedException {
        String insert2 = "INSERT INTO `gdws_cpos_server_3.2`.`base_system_config`(`id`, `key`, `value`, `update_time`) VALUES (2, 'string', 'string', '2019-06-20 11:25:16')";
        jdbcTemplate.execute(insert2);
        Thread.sleep(1000 * 10);//观察数据库发现，事务完全结束才会提交，第一条数据并没有先插入进来
        throw new RuntimeException("强制抛一个异常");
    }





}