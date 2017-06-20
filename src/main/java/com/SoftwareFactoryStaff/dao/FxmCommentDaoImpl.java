package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.FxmComment;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fxmCommentDao")
public class FxmCommentDaoImpl implements FxmCommentDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(FxmComment fxmComment) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(fxmComment);
        return id;
    }

    @Override
    public FxmComment read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        FxmComment fxmComment = (FxmComment) session.get(FxmComment.class, id);
        return fxmComment;
    }

    @Override
    public void update(FxmComment fxmComment) {
        Session session = sessionFactory.getCurrentSession();
        session.update(fxmComment);
    }

    @Override
    public void delete(FxmComment fxmComment) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(fxmComment);
    }

    @Override
    public List<FxmComment> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from FxmComment");
        return query.list();
    }
}
