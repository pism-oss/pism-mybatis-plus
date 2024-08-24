package cn.com.pism.mybatis.core.method;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import com.baomidou.mybatisplus.core.metadata.TableInfoHelper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.apache.ibatis.executor.keygen.Jdbc3KeyGenerator;
import org.apache.ibatis.executor.keygen.KeyGenerator;
import org.apache.ibatis.executor.keygen.NoKeyGenerator;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

import static cn.com.pism.mybatis.core.constant.MybatisConstants.INSERT_OR_UPDATE_BY_ID;

/**
 * @author perccyking
 * @since 24-08-23 17:33
 */
@Component
public class InsertOrUpdateId extends MybatisMethod {

    @Autowired
    public InsertOrUpdateId() {
        super(INSERT_OR_UPDATE_BY_ID);
    }

    public InsertOrUpdateId(String methodName) {
        super(methodName);
    }

    @Override
    protected MappedStatement addMappedStatement(SqlSource sqlSource) {
        KeyGenerator keyGenerator = NoKeyGenerator.INSTANCE;
        TableInfo tableInfo = getTableInfo();
        // 表包含主键处理逻辑,如果不包含主键当普通字段处理
        if (StringUtils.isNotBlank(tableInfo.getKeyProperty())) {
            if (tableInfo.getIdType() == IdType.AUTO) {
                /* 自增主键 */
                keyGenerator = Jdbc3KeyGenerator.INSTANCE;
            } else if (null != tableInfo.getKeySequence()) {
                keyGenerator = TableInfoHelper.genKeyGenerator(methodName, tableInfo, builderAssistant);
            }
        }
        return this.addInsertMappedStatement(getMapperClass(),
                getModelClass() == null ? Map.class : getModelClass(),
                methodName,
                sqlSource,
                keyGenerator,
                tableInfo.getKeyProperty(),
                tableInfo.getKeyColumn());
    }

}
