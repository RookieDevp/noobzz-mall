package cn.noobzz.mall.core.domain;

import cn.noobzz.mall.core.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

/**
 * 商品SKU对象 pms_sku
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:55
 */
@Data
@ToString
@NoArgsConstructor
@TableName("pms_sku")
public class Sku extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 规格ID */
    @TableId(type = IdType.AUTO)
    private Long skuId;
    /** 商品SPU */
    private Long spuId;
    /** 品牌ID */
    private Long brandId;
    /** 分类ID */
    private Long categoryId;
    /** 规格名称 */
    private String skuName;
    /** 规格描述 */
    private String skuDescribe;
    /** 价格 */
    private BigDecimal price;
    /** 销量 */
    private String saleCount;
    /** 规格图片 */
    private String skuImg;
}
