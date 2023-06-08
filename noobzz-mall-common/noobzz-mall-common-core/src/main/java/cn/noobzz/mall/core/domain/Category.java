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
 * 商品分类对象 pms_category
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Data
@ToString
@NoArgsConstructor
@TableName("pms_category")
public class Category extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 商品分类ID */
    @TableId(type = IdType.AUTO)
    private Long categoryId;
    /** 分类名称 */
    private String categoryName;
}
