package cn.com.pism.mybatis.core;

import cn.com.pism.mybatis.core.method.MybatisMethod;
import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;
import com.baomidou.mybatisplus.core.metadata.TableInfo;
import jakarta.annotation.Nonnull;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.Configuration;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * 为mybatis 注入方法
 *
 * @author perccyking
 * @since 24-08-22 21:09
 */
@Component
@Slf4j
public class MybatisSqlInjector extends DefaultSqlInjector implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @Override
    public List<AbstractMethod> getMethodList(Configuration configuration, Class<?> mapperClass, TableInfo tableInfo) {
        //mybatis plus 的方法列表
        List<AbstractMethod> methodList = super.getMethodList(configuration, mapperClass, tableInfo);
        try {
            //自定义注册的方法列表
            Map<String, MybatisMethod> beans = applicationContext.getBeansOfType(MybatisMethod.class);
            if (!CollectionUtils.isEmpty(beans)) {
                //将自定义方法与mybatis plus 方法列表合并
                methodList.addAll(beans.values());
            }
        } catch (BeansException e) {
            log.error(e.getMessage(), e);
        }
        return methodList;
    }

    @Override
    public void setApplicationContext(@Nonnull ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
