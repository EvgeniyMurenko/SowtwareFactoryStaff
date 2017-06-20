package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.FxmPost;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("fxmPostDao")
public class FxmPostDaoImpl implements FxmPostDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(FxmPost fxmPost) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(fxmPost);
        return id;
    }

    @Override
    public FxmPost read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        FxmPost fxmPost = (FxmPost) session.get(FxmPost.class, id);
        return fxmPost;
    }

    @Override
    public void update(FxmPost fxmPost) {
        Session session = sessionFactory.getCurrentSession();
        session.update(fxmPost);
    }

    @Override
    public void delete(FxmPost fxmPost) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(fxmPost);
    }

    @Override
    public List<FxmPost> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from FxmPost");
        return query.list();
    }
}
