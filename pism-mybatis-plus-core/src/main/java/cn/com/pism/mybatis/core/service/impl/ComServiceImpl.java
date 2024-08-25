package cn.com.pism.mybatis.core.service.impl;

import cn.com.pism.mybatis.core.annotation.EntityFill;
import cn.com.pism.mybatis.core.mapper.ComMapper;
import cn.com.pism.mybatis.core.service.ComService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Collection;

/**
 * @author perccyking
 * @since 24-08-25 00:34
 */
public class ComServiceImpl<M extends ComMapper<T>, T> extends ServiceImpl<M, T> implements ComService<T> {

    @Override
    @EntityFill
    public int batchInsert(Collection<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            return baseMapper.batchInsert(list);
        }
        return 0;
    }

    @Override
    @EntityFill
    public int batchUpdate(Collection<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            return baseMapper.batchUpdate(list);
        }
        return 0;
    }

    @Override
    @EntityFill
    public int batchUpdateSelective(Collection<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            return baseMapper.batchUpdateSelective(list);
        }
        return 0;
    }

    @Override
    @EntityFill
    public boolean insertOrUpdateById(T t) {
        return baseMapper.insertOrUpdateById(t);
    }

    @Override
    @EntityFill
    public boolean insertOrUpdateSelective(T t) {
        return baseMapper.insertOrUpdateSelective(t);
    }

    @Override
    @EntityFill
    public boolean insertSelective(T entity) {
        return baseMapper.insertSelective(entity);
    }

    @Override
    @EntityFill
    public boolean updateSelectiveByPrimaryKey(T entity) {
        return baseMapper.updateSelectiveByPrimaryKey(entity);
    }


    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param entity 实体对象
     */
    @Override
    @EntityFill
    public boolean save(T entity) {
        return super.save(entity);
    }

    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    @EntityFill
    public boolean saveBatch(Collection<T> entityList) {
        return saveBatch(entityList, DEFAULT_BATCH_SIZE);
    }

    /**
     * 插入（批量）
     *
     * @param entityList 实体对象集合
     * @param batchSize  插入批次数量
     */
    @EntityFill
    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        return super.saveBatch(entityList, batchSize);
    }

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     */
    @Transactional(rollbackFor = Exception.class)
    @EntityFill
    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList) {
        return super.saveOrUpdateBatch(entityList);
    }

    /**
     * 批量修改插入
     *
     * @param entityList 实体对象集合
     * @param batchSize  每次的数量
     */
    @Override
    @EntityFill
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    /**
     * 根据 ID 选择修改
     *
     * @param entity 实体对象
     */
    @Override
    @EntityFill
    public boolean updateById(T entity) {
        return super.updateById(entity);
    }

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    @EntityFill
    public boolean updateBatchById(Collection<T> entityList) {
        return super.updateBatchById(entityList);
    }

    /**
     * 根据ID 批量更新
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     */
    @Override
    @EntityFill
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        return super.updateBatchById(entityList, batchSize);
    }

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param entity 实体对象
     */
    @Override
    @EntityFill
    public boolean saveOrUpdate(T entity) {
        return super.saveOrUpdate(entity);
    }
}
