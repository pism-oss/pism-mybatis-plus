package cn.com.pism.mybatis.core.service;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Collection;

/**
 * @author perccyking
 * @since 24-08-25 00:33
 */
public interface ComService<T> extends IService<T> {
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

    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param entity 实体对象
     */
    @Override
    boolean save(T entity);

    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     */
    @Override
    boolean saveBatch(Collection<T> entityList);

    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     * @param batchSize  插入批次数量
     */
    @Override
    boolean saveBatch(Collection<T> entityList, int batchSize);

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     */
    @Override
    boolean saveOrUpdateBatch(Collection<T> entityList);

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     * @param batchSize  每次的数量
     */
    @Override
    boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize);

    /**
     * 根据 ID 选择修改
     *
     * @param entity 实体对象
     */
    @Override
    boolean updateById(T entity);

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     */
    @Override
    boolean updateBatchById(Collection<T> entityList);

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     */
    @Override
    boolean updateBatchById(Collection<T> entityList, int batchSize);

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param entity 实体对象
     */
    @Override
    boolean saveOrUpdate(T entity);
}
