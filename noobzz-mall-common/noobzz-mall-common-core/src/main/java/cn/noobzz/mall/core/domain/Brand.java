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
 * 商品品牌对象 pms_brand
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Data
@ToString
@NoArgsConstructor
@TableName("pms_brand")
public class Brand extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 品牌ID */
    @TableId(value = "brand_id",type = IdType.AUTO)
    private Long brandId;
    /** 品牌名称 */
    private String brandName;
    /** 品牌logo */
    private String brandLogo;
}
