package com.SoftwareFactoryStaff.service;

import com.SoftwareFactoryStaff.model.NoticeLink;

import java.util.List;

public interface NoticeLinkService {

    void addNewNoticeLink(NoticeLink noticeLink);

    void updateNoticeLink(NoticeLink noticeLink);

    void deleteNoticeLink(NoticeLink noticeLink);

    NoticeLink getNoticeLinkById(Long id);

    List<NoticeLink> getAllNoticeLinks();

}
