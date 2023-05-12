package cn.noobzz.user.service.Impl;

import cn.noobzz.mall.core.domain.ReceiveAddress;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.user.mapper.ReceiveAddressMapper;
import cn.noobzz.user.service.IReceiveAddressService;

/**
 * 收货地址Service业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-12 17:47:36
 */
@Service
public class ReceiveAddressServiceImpl extends ServiceImpl<ReceiveAddressMapper, ReceiveAddress> implements IReceiveAddressService {

}