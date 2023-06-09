package cn.noobzz.mall.pay.config;

import cn.hutool.core.util.CharsetUtil;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConfig;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: ZZJ
 * @date: 2023/06/09
 * @desc:
 */
@Configuration
@Data
@ConfigurationProperties(prefix = "alipay")
public class AlipayConfiguration {

    private String appId;

    private String appPrivateKey;

    private String publicKey;

    private String gatewayUrl;

    private String notifyUrl;

    private String returnUrl;

    private String charset = "utf-8";

    private String format = "json";

    private String signType = "RSA2";

    @Bean
    public AlipayClient getAlipayClient() throws AlipayApiException {
        AlipayConfig alipayConfig = new AlipayConfig();
        alipayConfig.setAppId(appId);
        alipayConfig.setServerUrl(gatewayUrl);
        alipayConfig.setPrivateKey(appPrivateKey);
        alipayConfig.setFormat(format);
        alipayConfig.setCharset(charset);
        alipayConfig.setAlipayPublicKey(publicKey);
        alipayConfig.setSignType(signType);
        return new DefaultAlipayClient(alipayConfig);
    }
}
