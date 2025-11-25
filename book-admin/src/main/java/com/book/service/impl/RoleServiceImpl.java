package com.book.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.dao.RoleDao;
import com.book.entity.Role;
import com.book.service.RoleService;
import org.springframework.stereotype.Service;

/**
 * 角色表，存放角色名称(Role)表服务实现类
 *
 * @author jojo思密达
 * @since 2025-11-24 15:31:27
 */
@Service("roleService")
public class RoleServiceImpl extends ServiceImpl<RoleDao, Role> implements RoleService {

}

