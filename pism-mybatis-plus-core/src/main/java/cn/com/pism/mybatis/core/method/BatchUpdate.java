package cn.com.pism.mybatis.core.method;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.springframework.stereotype.Component;

import java.util.List;

import static cn.com.pism.mybatis.core.constant.MybatisConstants.BATCH_UPDATE;

/**
 * @author perccyking
 * @since 24-08-24 22:34
 */
@Component
public class BatchUpdate extends MybatisMethod {

    protected BatchUpdate() {
        super(BATCH_UPDATE);
    }

    @Override
    protected MappedStatement addMappedStatement(SqlSource sqlSource) {
        return this.addUpdateMappedStatement(getMapperClass(), List.class, methodName, sqlSource);

    }
}
