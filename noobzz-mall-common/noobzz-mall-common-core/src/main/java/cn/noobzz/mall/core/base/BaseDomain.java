package cn.noobzz.mall.core.base;

import lombok.Data;

import java.util.Date;

/**
 * @author: ZZJ
 * @date: 2023/04/28
 * @desc:
 */
@Data
public class BaseDomain {

    private String status;

    private Date createTime;

    private Date updateTime;
}
