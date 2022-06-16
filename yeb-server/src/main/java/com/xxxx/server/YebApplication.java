package com.xxxx.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.lang.reflect.Field;

/**
 * yeb应用程序
 *
 * @author zhangwei
 * @date 2022/03/23
 */
@SpringBootApplication
@MapperScan("com.xxxx.server.mapper")
public class YebApplication {
    public static void main(String[] args) throws NoSuchFieldException {
        ConfigurableApplicationContext context =
        SpringApplication.run(YebApplication.class,args);
        System.out.println(context);

        //beanFactory
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");
    }
}
