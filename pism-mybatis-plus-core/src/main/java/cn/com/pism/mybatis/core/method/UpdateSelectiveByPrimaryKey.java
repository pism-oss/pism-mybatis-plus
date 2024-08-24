package cn.com.pism.mybatis.core.method;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.springframework.stereotype.Component;

import static cn.com.pism.mybatis.core.constant.MybatisConstants.UPDATE_SELECTIVE_BY_PRIMARY_KEY;

/**
 * @author perccyking
 * @since 24-08-24 22:40
 */
@Component
public class UpdateSelectiveByPrimaryKey extends MybatisMethod {

    public UpdateSelectiveByPrimaryKey() {
        super(UPDATE_SELECTIVE_BY_PRIMARY_KEY);
    }

    @Override
    protected MappedStatement addMappedStatement(SqlSource sqlSource) {
        return this.addUpdateMappedStatement(getMapperClass(), getModelClass(), methodName, sqlSource);
    }
}
