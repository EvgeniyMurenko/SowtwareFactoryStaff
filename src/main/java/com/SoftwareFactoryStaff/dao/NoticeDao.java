package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.Notice;
import java.util.List;


public interface NoticeDao {
    Long create(Notice notice);
    Notice read(Long id);
    void update(Notice notice);
    void delete(Notice notice);
    List<Notice> findAll();
}
