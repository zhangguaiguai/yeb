package com.xxxx.server.utils;

import com.xxxx.server.pojo.Admin;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * 管理跑龙套
 *
 * @author zhangwei
 * @date 2022/06/30
 */
public class AdminUtils {

    /**
     * 获取当前登录操作员
     *
     * @return
     */
    public static Admin getCurrentAdmin() {
        return (Admin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
