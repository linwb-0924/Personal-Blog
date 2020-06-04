package org.fjnu.service.impl;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.fjnu.Exception.NotfoundException;
import org.fjnu.dao.TypeRespositroy;
import org.fjnu.entity.Type;
import org.fjnu.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

/**
 * @author wb_Lin
 * @create 2020-05-30 20:53
 */
@Service
public class TypeServiceimpl implements TypeService{
    @Resource
    TypeRespositroy typeRespositroy;

    @Transactional
    @Override
    public Type saveType(Type type) {

        return typeRespositroy.save(type);
    }
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRespositroy.getOne(id);
    }
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
        return typeRespositroy.findAll(pageable);
    }

    @Override
    public List<Type> listType() {
        return typeRespositroy.findAll();
    }


    @Transactional
    @Override
    public Type updateType(Long id, Type type) throws NotfoundException {
        Type one = typeRespositroy.getOne(id);
        if(one == null){
            throw new NotfoundException("该分类未找到");
        }
        BeanUtils.copyProperties(type,one);
        return typeRespositroy.save(one);
    }
    @Transactional
    @Override
    public void deleteType(Long id) {
        typeRespositroy.deleteById(id);
    }

    @Override
    public Type getByName(String name) {
        return typeRespositroy.findByName(name);
    }
}
