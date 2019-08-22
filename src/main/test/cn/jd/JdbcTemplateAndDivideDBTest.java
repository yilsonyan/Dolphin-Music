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
     * 测试结果发现：分片的多个数据库中都创建了此表；插入数据根据 id 的大小区间插入到了不同的数据库
     */
    @Test
    public void testDivideDB() throws Exception{
        String drop = "DROP TABLE IF EXISTS `tb_item`;";
        String create = "CREATE TABLE `tb_item` (`id` bigint(20) , `price` bigint(20), PRIMARY KEY (`id`))";
        String insert1 = "INSERT INTO `tb_item` (id,price)VALUES (1,998)";
        String insert2 = "INSERT INTO `tb_item` (id,price)VALUES (10000000,998)";
        jdbcTemplate.execute(drop);
        jdbcTemplate.execute(create);
        jdbcTemplate.execute(insert1);
        jdbcTemplate.execute(insert2);
    }

}