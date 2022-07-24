package com.xxxx.server.controller;


import com.xxxx.server.pojo.Employee;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.pojo.RespPageBean;
import com.xxxx.server.server.IEmployeeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDate;


/**
 * 员工控制器
 *
 * @author zhangwei
 * @date 2022/07/02
 */
@RestController
@RequestMapping("/employee/basic")
public class EmployeeController {
    @Resource
    IEmployeeService employeeService;

    @ApiOperation(value = "获取所有的员工[分页]")
    @GetMapping("/")
    public RespPageBean getEmployee(@RequestParam(defaultValue = "1") Integer currentPage,
                                    @RequestParam(defaultValue = "10") Integer size,
                                    Employee employee, LocalDate[] beginDateScope) {
        return employeeService.getEmployeeByPage(currentPage,size,employee,beginDateScope);
    }


}
