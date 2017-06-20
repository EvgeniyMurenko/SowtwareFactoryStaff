package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.Notice;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("noticeDao")
public class NoticeDaoImpl implements NoticeDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Long create(Notice notice) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(notice);
        return id;
    }

    @Override
    public Notice read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Notice notice = (Notice) session.get(Notice.class, id);
        return notice;
    }

    @Override
    public void update(Notice notice) {
        Session session = sessionFactory.getCurrentSession();
        session.update(notice);
    }

    @Override
    public void delete(Notice notice) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(notice);
    }

    @Override
    public List<Notice> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Notice");
        return query.list();
    }
}
