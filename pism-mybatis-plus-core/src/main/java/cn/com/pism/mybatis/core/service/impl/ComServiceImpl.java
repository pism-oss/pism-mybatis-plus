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
public class ComServiceImpl<M extends ComMapper<E>, E> extends ServiceImpl<M, E> implements ComService<E> {

    @Override
    @EntityFill
    public int batchInsert(Collection<E> list) {
        if (!CollectionUtils.isEmpty(list)) {
            return baseMapper.batchInsert(list);
        }
        return 0;
    }

    @Override
    @EntityFill
    public int batchUpdate(Collection<E> list) {
        if (!CollectionUtils.isEmpty(list)) {
            return baseMapper.batchUpdate(list);
        }
        return 0;
    }

    @Override
    @EntityFill
    public int batchUpdateSelective(Collection<E> list) {
        if (!CollectionUtils.isEmpty(list)) {
            return baseMapper.batchUpdateSelective(list);
        }
        return 0;
    }

    @Override
    @EntityFill
    public boolean insertOrUpdateById(E e) {
        return baseMapper.insertOrUpdateById(e);
    }

    @Override
    @EntityFill
    public boolean insertOrUpdateSelective(E e) {
        return baseMapper.insertOrUpdateSelective(e);
    }

    @Override
    @EntityFill
    public boolean insertSelective(E e) {
        return baseMapper.insertSelective(e);
    }

    @Override
    @EntityFill
    public boolean updateSelectiveByPrimaryKey(E e) {
        return baseMapper.updateSelectiveByPrimaryKey(e);
    }


    /**
     * 插入一条记录（选择字段，策略插入）
     *
     * @param entity 实体对象
     */
    @Override
    @EntityFill
    public boolean save(E entity) {
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
    public boolean saveBatch(Collection<E> entityList) {
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
    public boolean saveBatch(Collection<E> entityList, int batchSize) {
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
    public boolean saveOrUpdateBatch(Collection<E> entityList) {
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
    public boolean saveOrUpdateBatch(Collection<E> entityList, int batchSize) {
        return super.saveOrUpdateBatch(entityList, batchSize);
    }

    /**
     * 根据 ID 选择修改
     *
     * @param entity 实体对象
     */
    @Override
    @EntityFill
    public boolean updateById(E entity) {
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
    public boolean updateBatchById(Collection<E> entityList) {
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
    public boolean updateBatchById(Collection<E> entityList, int batchSize) {
        return super.updateBatchById(entityList, batchSize);
    }

    /**
     * TableId 注解存在更新记录，否插入一条记录
     *
     * @param entity 实体对象
     */
    @Override
    @EntityFill
    public boolean saveOrUpdate(E entity) {
        return super.saveOrUpdate(entity);
    }
}
