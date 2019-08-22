package cn.jd.restfull;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * 自定义资源映射：设置虚拟路径，访问绝对路径下资源
 */
@SuppressWarnings("all")
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {


    /**
     * 路径结尾写成 /** 可以访问子目录的资源，如：http://localhost:8080/2/2.jpg 访问 D:/picture/2/2.jpg
     * 【注意】：这这写法要注意和 restful 风格的 Controller 冲突
     */
    String[] requestPattern = new String[]{"/**"};
    String[] locations = {"classpath:/static/","file:D:/picture/**"};

    /**
     * SpringBoot 默认静态资源的映射路径文件夹有：
     * classpath:/META-INF/resources
     * classpath:/resources
     * classpath:/static
     * classpath:/public
     * 优先级顺序为：META-INF/resources > resources > static > public
     *
     * 我们可以通过修改 application.yml 的 spring.mvc.static-path-pattern 来修改默认的映射
     * 或者写一个本配置类 继承 WebMvcConfigurerAdapter 并加上注解 @Configuration
     *
     * addResoureHandler 指的是对外暴露的访问路径
     * addResourceLocations 指的是文件放置的目录
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(requestPattern).addResourceLocations(locations);
        super.addResourceHandlers(registry);
    }

    /**
     * 配置视图
     */
    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix(".html");
        //resolver.setSuffix(".jsp");
        return resolver;
    }

    /**
     * 添加默认主页，访问域名或者端口跳转
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        //registry.addViewController("/").setViewName("index");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }




}
