package cn.noobzz.mall.core.domain;

import cn.noobzz.mall.core.base.BaseDomain;
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
public class SysUser extends BaseDomain {

    private Long userId;

    private String username;

    private String password;

}
