package cn.noobzz.auth.component;

import cn.dev33.satoken.oauth2.logic.SaOAuth2Template;
import cn.dev33.satoken.oauth2.model.SaClientModel;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Component;

/**
 * @author: ZZJ
 * @date: 2023/04/22
 * @desc:
 */
@Component
public class SaOAuth2TemplateImpl extends SaOAuth2Template {


    @Override
    public SaClientModel getClientModel(String clientId) {
        // 此为模拟数据，真实环境需要从数据库查询 TODO
        if("1001".equals(clientId)) {
            return new SaClientModel()
                    .setClientId("1001")
                    .setClientSecret("aaaa-bbbb-cccc-dddd-eeee")
                    .setAllowUrl("*")
                    .setContractScope("userinfo")
                    .setIsAutoMode(true);
        }
        return null;
    }

    // 根据ClientId 和 LoginId 获取openid
    @Override
    public String getOpenid(String clientId, Object loginId) {
        // 此为模拟数据，真实环境需要从数据库查询
        return "gr_SwoIN0MC1ewxHX_vfCW3BothWDZMMtx__";
    }

    @Override
    public String randomAccessToken(String clientId, Object loginId, String scope) {
        String tokenValue = StpUtil.createLoginSession(loginId);
        return tokenValue;
    }
}
