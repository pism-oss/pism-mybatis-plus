package cn.com.pism.mybatis.core.method;

import org.springframework.stereotype.Component;

import static cn.com.pism.mybatis.core.constant.MybatisConstants.INSERT_SELECTIVE;

/**
 * @author perccyking
 * @since 24-08-24 22:38
 */
@Component
public class InsertSelective extends InsertOrUpdateId {

    public InsertSelective() {
        super(INSERT_SELECTIVE);
    }

}
