package cn.noobzz.mall.core.domain;

import cn.noobzz.mall.core.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 收货地址对象 ums_receive_address
 * 
 * @author ZZJ
 * @date 2023-05-12 17:47:36
 */
@Data
@ToString
@NoArgsConstructor
@TableName("ums_receive_address")
public class ReceiveAddress extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 地址ID */
    private Long addressId;
    /** 用户ID */
    private Long userId;
    /** 省份/直辖市 */
    private String province;
    /** 市 */
    private String city;
    /** 区 */
    private String region;
    /** 详细地址 */
    private String detailAddress;
    /** 收货人电话 */
    private String receiverPhone;
    /** 收货人姓名 */
    private String receiverName;
}
