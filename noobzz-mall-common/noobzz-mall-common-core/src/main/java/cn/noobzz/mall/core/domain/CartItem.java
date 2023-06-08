package cn.noobzz.mall.core.domain;

import cn.noobzz.mall.core.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("cms_cart_item")
public class CartItem extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 购物车ID */
    @TableId(type = IdType.AUTO)
    private Long itemId;

    private Long cartId;
    /** 规格ID */
    private Long skuId;
    /** 数量 */
    private Long count;
    /** 购选状态 */
    private Integer selectd;
}
