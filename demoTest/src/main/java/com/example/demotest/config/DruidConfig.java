package com.example.demotest.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {


    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean();
        servletRegistrationBean.setServlet(new StatViewServlet());
        servletRegistrationBean.addUrlMappings("/druid/*");
        Map<String, String> initParameters = new HashMap<>();
        initParameters.put("resetEnable", "false"); //禁用HTML页面上的“Rest All”功能
        initParameters.put("allow", "127.0.0.1");  //ip白名单（没有配置或者为空，则允许所有访问）
        initParameters.put("loginUsername", "admin");  //++监控页面登录用户名
        initParameters.put("loginPassword", "123.admin");  //++监控页面登录用户密码
        initParameters.put("deny", ""); //ip黑名单
        //如果某个ip同时存在，deny优先于allow
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;

    }


    //WebStatFilter：用于配置Web和Druid数据源之间的管理关联监控统计
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
//exclusions：设置哪些请求进行过滤排除掉，从而不进行统计

        bean.addInitParameter("exclusions", "*.js,*.css,/druid/*,/jdbc/*");

//"/*" 表示过滤所有请求
        bean.addUrlPatterns("/**");
        return bean;
    }

}