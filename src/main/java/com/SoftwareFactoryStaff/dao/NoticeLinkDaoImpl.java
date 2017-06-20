package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.NoticeLink;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository("noticeLinkDao")
public class NoticeLinkDaoImpl implements NoticeLinkDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(NoticeLink noticeLink) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(noticeLink);
        return id;
    }

    @Override
    public NoticeLink read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        NoticeLink noticeLink = (NoticeLink) session.get(NoticeLink.class, id);
        return noticeLink;
    }

    @Override
    public void update(NoticeLink noticeLink) {
        Session session = sessionFactory.getCurrentSession();
        session.update(noticeLink);
    }

    @Override
    public void delete(NoticeLink noticeLink) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(noticeLink);
    }

    @Override
    public List<NoticeLink> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from NoticeLink");
        return query.list();
    }

}
