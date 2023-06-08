package cn.noobzz.common.security.config.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: ZZJ
 * @date: 2022/08/07
 * @desc:
 */
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        boolean createTime = metaObject.hasSetter("createTime");
        if (createTime){
            this.strictInsertFill(metaObject,"createTime", Date.class,new Date());
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {

        boolean updateTime = metaObject.hasSetter("updateTime");
        if (updateTime){
            this.strictInsertFill(metaObject,"updateTime", Date.class,new Date());
        }
    }
}
