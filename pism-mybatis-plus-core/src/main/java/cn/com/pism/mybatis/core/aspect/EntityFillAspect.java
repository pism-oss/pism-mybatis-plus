package cn.com.pism.mybatis.core.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.List;

/**
 * @author perccyking
 * @since 24-08-25 00:49
 */
@Slf4j
public abstract class EntityFillAspect {

    @Pointcut("@annotation(cn.com.pism.mybatis.core.annotation.EntityFill)")
    public void pointcut() {
        // pointcut
    }

    @Before("pointcut()")
    public void before(JoinPoint jp) {
        //获取方法的参数
        Object[] args = jp.getArgs();
        //获取当前登录用户信息
        if (args != null) {

            for (Object arg : args) {
                parseObject(arg);
                log.trace("fill after:{}", arg);
            }
        }
    }

    /**
     * <p>
     * 解析参数
     * </p>
     * by perccyking
     *
     * @param arg : 参数
     * @since 24-08-25 00:55
     */
    private void parseObject(Object arg) {
        if (arg != null) {
            //对list进行特殊处理，其他非集合类型以后再适配
            if (arg instanceof List) {
                // 对象为list的时候，遍历处理
                ((List<?>) arg).forEach(this::enhance);
            }
            //非list对象
            enhance(arg);
        }
    }

    private void enhance(Object o) {
        if (o != null && !BeanUtils.isSimpleValueType(o.getClass())) {
            //先解析一次对象中的属性，属性中可能包含ComEntity对象
            parseFields(o);
            if (needEnhance(o)) {
                // 设置基础属性
                doEnhance(o);
            }
        }
    }

    /**
     * <p>
     * 处理对象的属性
     * </p>
     * by perccyking
     *
     * @param o : 对象
     * @since 24-08-25 01:10
     */
    private void parseFields(Object o) {
        //获取对象的全部属性
        Field[] fields = o.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field != null && !BeanUtils.isSimpleProperty(field.getType())) {
                    //属性的类型不是基本数据类型是，递归解析，直到处理完所有层级
                    int modifiers = field.getModifiers();
                    if (!Modifier.isFinal(modifiers)) {
                        Object result = field.get(o);
                        parseObject(result);
                    }
                }

            } catch (IllegalAccessException e) {
                log.error(e.getMessage(), e);
            }
        }
    }

    /**
     * <p>
     * 是否需要对对象进行增强
     * </p>
     * by perccyking
     *
     * @param o : 实体对象
     * @return {@link boolean} true:增强,false:不增强
     * @since 24-08-25 01:06
     */
    protected boolean needEnhance(Object o) {
        return true;
    }

    /**
     * <p>
     * 增强
     * </p>
     * by perccyking
     *
     * @param o : 实体对象
     * @since 24-08-25 01:08
     */
    protected abstract void doEnhance(Object o);
}
