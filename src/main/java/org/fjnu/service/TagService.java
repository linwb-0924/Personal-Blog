package org.fjnu.service;

import org.fjnu.Exception.NotfoundException;
import org.fjnu.entity.Tag;
import org.fjnu.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author wb_Lin
 * @create 2020-05-31 15:06
 */

public interface TagService {
    Tag saveTag(Tag tag);

    Tag getTag(Long id);

    Page<Tag> listTag(Pageable pageable);

    List<Tag> listTag();

    List<Tag> listTag(String ids);

    Tag updateTag(Long id,Tag tag) throws NotfoundException;

    void deleteTag(Long id);

    Tag getByName(String name);



}
