package cn.noobzz.mall.core.domain;

import cn.noobzz.mall.core.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 购物车对象 cms_cart
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Data
@ToString
@NoArgsConstructor
@TableName("cms_cart")
public class Cart extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 购物车ID */
    private Long cartId;
    /** 用户ID */
    private Long userId;
    /** 规格ID */
    private Long skuId;
    /** 数量 */
    private Long count;
    /** 购选状态 */
    private Integer selectd;
}
