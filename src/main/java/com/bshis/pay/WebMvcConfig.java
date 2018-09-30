package com.bshis.pay;

import com.bshis.pay.Interceptor.ApiInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: ddliu6
 * @Description:
 * @Date: Created in 23:09 2018/9/27
 * @Modified By:
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ApiInterceptor()).addPathPatterns("/api/**");
        super.addInterceptors(registry);
    }
}
