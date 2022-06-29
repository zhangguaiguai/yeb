package com.xxxx.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 我的测试
 *
 * @author 爪哇小白2021
 * @date 2022/06/25
 */
public class MyTest {
    @Test
    void test1(){
        //创建解析器
        BCryptPasswordEncoder pw = new BCryptPasswordEncoder();
        //对密码加密
        String encode = pw.encode("123");
        System.out.println("encode = " + encode);
        /**
         * 判断原字符和加密后内容是否匹配
         */
        boolean matches = pw.matches("1234", encode);
        System.out.println("matches = " + matches);
    }
}
