package com.xxxx.server.controller;


import com.xxxx.server.pojo.Menu;
import com.xxxx.server.server.IMenuService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


/**
 * 菜单控制器
 *
 * @author zhangwei
 * @date 2022/06/14
 */
@RestController
@RequestMapping("/system/config")
public class MenuController {

    @Resource
    IMenuService menuService;

    @ApiOperation(value = "通过用户id查询菜单列表")
    @GetMapping("/menu")
    public List<Menu> getMenusByAdminId(){
        return menuService.getMenusByAdminId();
    }

}
