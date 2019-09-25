package cn.yan.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.apache.ibatis.reflection.MetaObject;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@MapperScan("cn.yan.mapper")
public class MybatisPlusConfig {

    /**
     * 分页插件（必需配置才能分页）
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 开启 count 的 join 优化,只针对 left join !!!
        //paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true))
        return paginationInterceptor;
    }


    /**
     * 自定义填充处理类
     */
    @Bean
    public MetaObjectHandler metaObjectHandler() {
        MetaObjectHandler metaObjectHandler = new MetaObjectHandler() {
            /**
             * 新增时填充的字段
             * @param metaObject
             */
            @Override
            public void insertFill(MetaObject metaObject) {
                //gmt格林尼治标准时间
                setFieldValByName("gmtCreate", new Date(), metaObject);
                setFieldValByName("gmtModified", new Date(), metaObject);
            }
            /**
             * 更新时 需要填充字段
             * @param metaObject
             */
            @Override
            public void updateFill(MetaObject metaObject) {
                setFieldValByName("gmtModified", new Date(), metaObject);
            }
        };
        return metaObjectHandler;
    }



}