package org.fjnu.service;

import org.fjnu.Exception.NotfoundException;
import org.fjnu.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-05-30 20:51
 */
@Service
public interface TypeService {
    Type saveType(Type type);

    Type getType(Long id);

    Page<Type> listType(Pageable pageable);

    List<Type> listType();


    Type updateType(Long id,Type type) throws NotfoundException;

    void deleteType(Long id);

    Type getByName(String name);

}
