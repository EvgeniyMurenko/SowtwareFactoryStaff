package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.FxmComment;

import java.util.List;


public interface FxmCommentDao {

    Long create(FxmComment fxmComment);

    FxmComment read(Long id);

    void update(FxmComment fxmComment);

    void delete(FxmComment fxmComment);

    List<FxmComment> findAll();

}
