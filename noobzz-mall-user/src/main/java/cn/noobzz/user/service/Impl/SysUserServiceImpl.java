package cn.noobzz.user.service.Impl;

import cn.noobzz.mall.core.domain.SysUser;
import cn.noobzz.user.mapper.SysUserMapper;
import cn.noobzz.user.service.SysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author: ZZJ
 * @date: 2023/04/28
 * @desc:
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
}
