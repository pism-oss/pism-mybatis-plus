package cn.com.pism.mybatis.core.method;

import org.springframework.stereotype.Component;

import static cn.com.pism.mybatis.core.constant.MybatisConstants.INSERT_OR_UPDATE_SELECTIVE;

/**
 * @author perccyking
 * @since 24-08-23 17:41
 */
@Component
public class InsertOrUpdateSelective extends InsertOrUpdateId {
    public InsertOrUpdateSelective() {
        super(INSERT_OR_UPDATE_SELECTIVE);
    }
}
