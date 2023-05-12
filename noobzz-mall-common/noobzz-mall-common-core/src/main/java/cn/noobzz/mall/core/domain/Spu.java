package cn.noobzz.mall.core.domain;

import cn.noobzz.mall.core.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 商品SPU对象 pms_spu
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:55
 */
@Data
@ToString
@NoArgsConstructor
@TableName("pms_spu")
public class Spu extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 商品ID */
    private Long spuId;
    /** 商品分类ID */
    private Long categoryId;
    /** 商品名称 */
    private String spuName;
    /** 商品描述 */
    private String spuDescribe;
    /** 商品图片 */
    private String spuPic;
    /** 商品标题 */
    private String spuTitle;
    /** 商品品牌 */
    private String spuBrand;
}
