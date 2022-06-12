package com.xxxx.server.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;

import javax.servlet.http.HttpServletRequest;


/**
 * iadmin服务
 *
 * @author zhangwei
 * @date 2022/06/11
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param request  请求
     * @return {@link RespBean}
     */
    RespBean login(String username, String password, HttpServletRequest request);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return {@link Admin}
     */
    Admin getAdminByUserName(String username);
}
