package com.sso.service;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.sso.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public interface SysUserService {
    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    SysUser selectByName(String userName);

    void update(SysUser sysUser);
}