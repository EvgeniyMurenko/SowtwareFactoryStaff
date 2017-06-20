package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.NoticeLink;

import java.util.List;

public interface NoticeLinkDao {

     Long create(NoticeLink noticeLink);

     NoticeLink read(Long id);

     void update(NoticeLink noticeLink);

     void delete(NoticeLink noticeLink);

     List<NoticeLink> findAll();

}
