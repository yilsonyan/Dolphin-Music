package cn.jd;


import cn.jd.entity.Mall;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class JdbcTemplateAndDivideDBTest {

    /**
     * 只需配置 datasource 就可在程序中注入 JdbcTemplate
     */
    @Autowired
    JdbcTemplate jdbcTemplate;

    /**
     * 测试 jdbcTemplate操作
     */
    @Test
    public void testJdbcTemplate() throws Exception{
        String sql = "select * from mall where 1 = ?";
        List<Mall> malls = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Mall.class),1);
        System.out.println(malls);
    }

    /**
     * 测试 jdbcTemplate操作数据库分片
     * 测试结果发现：分片的多个数据库中都创建了此表
     */
    @Test
    public void testDivideDB() throws Exception{
        String sql = "CREATE TABLE `tb_item` (`id` bigint(20) , `price` bigint(20), PRIMARY KEY (`id`))";
        jdbcTemplate.execute(sql);
    }

}