package cn.com.pism.mybatis.core.method;

import cn.com.pism.exception.PismException;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.annotation.Resource;
import lombok.Getter;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;

import static cn.com.pism.mybatis.core.constant.MybatisConstants.SQL_SCRIPT;
import static org.springframework.boot.autoconfigure.freemarker.FreeMarkerProperties.DEFAULT_SUFFIX;

/**
 * @author perccyking
 * @since 24-08-22 21:14
 */
@Getter
public abstract class MybatisMethod extends AbstractMethod {

    private Class<?> mapperClass;

    private Class<?> modelClass;

    private TableInfo tableInfo;


    @Resource
    private Configuration freeMarkerConfiguration;

    /**
     * @param methodName 方法名
     * @since 3.5.0
     */
    protected MybatisMethod(String methodName) {
        super(methodName);
    }

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        this.modelClass = modelClass;
        this.mapperClass = mapperClass;
        this.tableInfo = tableInfo;
        String sql;
        try {
            Template template = freeMarkerConfiguration.getTemplate(methodName + DEFAULT_SUFFIX);
            if (tableInfo.getKeyProperty() == null || tableInfo.getKeyProperty().isEmpty()) {
                sql = "暂不支持无主键实体";
            } else {
                sql = FreeMarkerTemplateUtils.processTemplateIntoString(template, tableInfoPreProcess(tableInfo));
            }
        } catch (IOException | TemplateException e) {
            throw new PismException(this.methodName + " sql模版未定义");
        }

        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(SQL_SCRIPT, sql), modelClass);
        return addMappedStatement(sqlSource);
    }

    /**
     * <p>
     * tableInfo 前置处理，可以添加一些附加信息辅助sql脚本生成
     * </p>
     * by perccyking
     *
     * @param tableInfo : mybatis 表的定义信息
     * @return {@link TableInfo}
     * @since 24-08-23 16:40
     */
    protected TableInfo tableInfoPreProcess(TableInfo tableInfo) {
        return tableInfo;
    }

    /**
     * <p>
     * 添加mapper声明
     * </p>
     * by perccyking
     *
     * @param sqlSource : sqlSource
     * @return {@link MappedStatement}
     * @since 24-08-23 16:36
     */
    protected abstract MappedStatement addMappedStatement(SqlSource sqlSource);
}
