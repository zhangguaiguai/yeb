package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.Menu;

import java.util.List;


/**
 * 菜单映射器
 *
 * @author zhangwei
 * @date 2022/06/16
 */
public interface MenuMapper extends BaseMapper<Menu> {


    /**
     * 被管理员菜单id
     *
     * @param id id
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> getMenusByAdminId(Integer id);

    /**
     * 开始菜单的作用
     *
     * @return {@link List}<{@link Menu}>
     */
    List<Menu> getMenusWithRole();
}
