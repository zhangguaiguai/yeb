package com.xxxx.server.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.Role;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


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
     * @param code 验证码
     * @param request  请求
     * @return {@link RespBean}
     */
    RespBean login(String username, String password,String code,HttpServletRequest request);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return {@link Admin}
     */
    Admin getAdminByUserName(String username);

    /**
     * 根据用户名获取用户角色
     *
     * @param adminId 管理员id
     * @return {@link List}<{@link Role}>
     */
    List<Role> getRoles(Integer adminId);

    /**
     * 获取所有管理员
     *
     * @param keywords 关键字
     * @return {@link List}<{@link Admin}>
     */
    List<Admin> getAllAdmins(String keywords);

    RespBean updateAdminRole(Integer adminId, Integer[] rids);
}
