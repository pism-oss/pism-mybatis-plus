package cn.com.pism.mybatis.starter.annotation;

import cn.com.pism.mybatis.core.PismMybatisPlusConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author perccyking
 * @since 24-08-24 18:50
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(PismMybatisPlusConfiguration.class)
public @interface EnablePismMybatisPlus {
}
