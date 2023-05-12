package cn.noobzz.mall.core.domain;

import cn.noobzz.mall.core.base.BaseDomain;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单信息对象 pms_order
 * 
 * @author ZZJ
 * @date 2023-05-13 01:03:54
 */
@Data
@ToString
@NoArgsConstructor
@TableName("pms_order")
public class Order extends BaseDomain
{
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private Long orderId;
    /** 订单编号 */
    private String orderSn;
    /** 用户ID */
    private Long userId;
    /** 订单总额 */
    private BigDecimal totalAmount;
    /** 支付方式 */
    private String payType;
    /** 订单状态 */
    private String orderStatus;
    /** 支付时间 */
    private Date paymentTime;
    /** 发货时间 */
    private Date deliveryTime;
    /** 收货时间 */
    private Date receivedTime;
    /** 收货人姓名 */
    private String receiverName;
    /** 收货人电话 */
    private String receiverPhone;
    /** 收货地址 */
    private String receiverAddress;
    /** 备注 */
    private String note;
    /** 应付总额 */
    private BigDecimal payAmount;
}
