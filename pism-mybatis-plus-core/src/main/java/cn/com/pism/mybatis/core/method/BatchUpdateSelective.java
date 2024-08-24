package cn.com.pism.mybatis.core.method;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.springframework.stereotype.Component;

import java.util.List;

import static cn.com.pism.mybatis.core.constant.MybatisConstants.BATCH_UPDATE_SELECTIVE;

/**
 * @author perccyking
 * @since 24-08-24 22:36
 */
@Component
public class BatchUpdateSelective extends MybatisMethod{

    public BatchUpdateSelective() {
        super(BATCH_UPDATE_SELECTIVE);
    }

    @Override
    protected MappedStatement addMappedStatement(SqlSource sqlSource) {
        return this.addUpdateMappedStatement(getMapperClass(), List.class, methodName, sqlSource);
    }
}
