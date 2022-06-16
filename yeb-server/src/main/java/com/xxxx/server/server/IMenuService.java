package com.xxxx.server.server;

import com.baomidou.mybatisplus.extension.service.IService;
import com.xxxx.server.pojo.Menu;

import java.util.List;

public interface IMenuService extends IService<Menu> {

    /**
     * 被管理员菜单id
     *
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> getMenusByAdminId();

}
