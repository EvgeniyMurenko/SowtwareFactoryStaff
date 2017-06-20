package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.GoogleCloudKey;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("googleCloudKeyDao")
public class GoogleCloudKeyDaoImpl implements GoogleCloudKeyDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Long create(GoogleCloudKey googleCloudKey) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(googleCloudKey);
        return id;
    }

    @Override
    public GoogleCloudKey read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        GoogleCloudKey googleCloudKey = (GoogleCloudKey) session.get(GoogleCloudKey.class, id);
        return googleCloudKey;
    }

    @Override
    public void update(GoogleCloudKey googleCloudKey) {
        Session session = sessionFactory.getCurrentSession();
        session.update(googleCloudKey);
    }

    @Override
    public void delete(GoogleCloudKey googleCloudKey) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(googleCloudKey);
    }

    @Override
    public List<GoogleCloudKey> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from GoogleCloudKey");
        return query.list();
    }

    @Override
    public List<String> getAllStringKeys() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct googleCloudKeys.key from GoogleCloudKey googleCloudKeys");
        return query.list();
    }

    @Override
    public List<String> findAllKeysByStaff(Long staffInfo) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct googleCloudKeys.key from GoogleCloudKey googleCloudKeys where googleCloudKeys.staffInfo.id = :staffInfo");
        query.setParameter("staffInfo", staffInfo);
        return query.list();
    }

}
