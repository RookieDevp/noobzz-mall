package cn.noobzz.mall.core.domain;

import cn.noobzz.mall.core.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 商品库存对象 pms_stock
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:55
 */
@Data
@ToString
@NoArgsConstructor
@TableName("pms_stock")
public class Stock extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 库存ID */
    @TableId(type = IdType.AUTO)
    private Long stockId;
    /** 商品SKU */
    private Long skuId;
    /** 仓库ID */
    private Long wareId;
    /** 库存 */
    private Long stock;
}
