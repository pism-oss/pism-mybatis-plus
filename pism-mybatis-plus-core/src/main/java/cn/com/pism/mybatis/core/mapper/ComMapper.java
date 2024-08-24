package cn.com.pism.mybatis.core.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.Collection;

/**
 * @author perccyking
 * @since 24-08-22 21:07
 */
public interface ComMapper<T> extends BaseMapper<T> {

    /**
     * <p>
     * 批量保存
     * </p>
     * by perccyking
     *
     * @param list : 实体集合
     * @return {@link int} 批量插入数量
     * @since 24-08-24 23:14
     */
    int batchInsert(Collection<T> list);

    /**
     * <p>
     * 批量按主键更新
     * </p>
     * by perccyking
     *
     * @param list : 实体集合
     * @return {@link int} 批量更新数量
     * @since 24-08-24 23:16
     */
    int batchUpdate(Collection<T> list);

    /**
     * <p>
     * 批量按主键更新非空字段
     * </p>
     * by perccyking
     *
     * @param list : 实体集合
     * @return {@link int} 更新数量
     * @since 24-08-24 23:18
     */
    int batchUpdateSelective(Collection<T> list);

    /**
     * <p>
     * 新增或更新
     * </p>
     * by perccyking
     *
     * @param t : 实体
     * @return {@link boolean} 是否成功
     * @since 24-08-25 00:14
     */
    boolean insertOrUpdateById(T t);


    /**
     * <p>
     * 新增或更新非空字段
     * </p>
     * by perccyking
     *
     * @param t : 实体
     * @return {@link boolean} 是否成功
     * @since 24-08-25 00:19
     */
    boolean insertOrUpdateSelective(T t);

    /**
     * <p>
     * 新增非空字段
     * </p>
     * by perccyking
     *
     * @param t : 实体
     * @return {@link boolean} 是否成功
     * @since 24-08-25 00:20
     */
    boolean insertSelective(T t);

    /**
     * <p>
     * 按主键更新非空值字段
     * </p>
     * by perccyking
     *
     * @param t : 实体
     * @return {@link boolean} 是否成功
     * @since 24-08-25 00:31
     */
    boolean updateSelectiveByPrimaryKey(T t);
}
