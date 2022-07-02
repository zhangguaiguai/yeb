package com.xxxx.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxxx.server.pojo.AdminRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2022-06-04
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole> {

    /**
     * 添加管理角色
     *
     * @param adminId 管理员id
     * @param rids    rid
     * @return {@link Integer}
     */
    Integer addAdminRole(@Param("adminId") Integer adminId, @Param("rids") Integer[] rids);

}
