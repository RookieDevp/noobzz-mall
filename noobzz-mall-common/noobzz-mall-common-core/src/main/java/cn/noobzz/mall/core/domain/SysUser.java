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
 * @author: ZZJ
 * @date: 2023/04/28
 * @desc:
 */
@Data
@ToString
@NoArgsConstructor
@TableName("sys_user")
public class SysUser extends BaseDomain {

    @TableId(type = IdType.AUTO)
    private Long userId;

    private String username;

    private String password;

}
