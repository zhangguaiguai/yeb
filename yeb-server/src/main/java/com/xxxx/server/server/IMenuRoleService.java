package com.xxxx.server.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.MenuRole;
import com.xxxx.server.pojo.RespBean;

public interface IMenuRoleService extends IService<MenuRole> {

    /**
     * 更新角色菜单
     *
     * @param rid  掉
     * @param mids mids
     * @return {@link RespBean}
     */
    RespBean updateMenuRole(Integer rid, Integer[] mids);

}
