package cn.noobzz.product.service.impl;

import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.noobzz.product.mapper.CartMapper;
import cn.noobzz.mall.core.domain.Cart;
import cn.noobzz.product.service.ICartService;

/**
 * 购物车Service业务层处理
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

}