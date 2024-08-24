package cn.com.pism.mybatis.core.method;

import org.springframework.stereotype.Component;

import static cn.com.pism.mybatis.core.constant.MybatisConstants.BATCH_INSERT;


/**
 * 批量保存
 *
 * @author perccyking
 * @since 24-08-23 01:00
 */
@Component
public class BatchInsert extends InsertOrUpdateId {

    protected BatchInsert() {
        super(BATCH_INSERT);
    }

}
