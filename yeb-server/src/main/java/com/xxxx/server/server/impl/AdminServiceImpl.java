package com.xxxx.server.server.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xxxx.server.config.security.JwtTokenUtil;
import com.xxxx.server.mapper.AdminMapper;
import com.xxxx.server.pojo.Admin;
import com.xxxx.server.pojo.RespBean;
import com.xxxx.server.server.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 管理服务impl
 *
 * @author zhangwei
 * @date 2022/06/06
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private AdminMapper adminMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public RespBean login(String username, String password, HttpServletRequest request) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        if (null==userDetails || !passwordEncoder.matches(password,userDetails.getPassword())){
            return RespBean.error("用户名密码不正确");
        }
        if (!userDetails.isEnabled()){
            return RespBean.error("账号被禁用，请联系管理员");
        }
        // 更新security登录用户对象
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(userDetails,null, userDetails.getAuthorities());

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);

        String token = jwtTokenUtil.generateToken(userDetails);
        Map<String,String> mapToken = new HashMap<>();
        mapToken.put("token",token);
        mapToken.put("tokenHead",tokenHead);
        return RespBean.success("success!",mapToken);
    }

    @Override
    public Admin getAdminByUserName(String username) {
        //adminMap.selectOne(Wrappers.lambdaQuery(Admin.class).eq(Admin::getUsername,username));
        return adminMapper.selectOne(new QueryWrapper<Admin>().eq("username",username)
                .eq("enabled",true));
    }
}
