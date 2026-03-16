package cn.com.pism.mybatis.core.service.impl;

import cn.com.pism.mybatis.core.annotation.EntityFill;
import cn.com.pism.mybatis.core.mapper.ComMapper;
import cn.com.pism.mybatis.core.service.ComService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
