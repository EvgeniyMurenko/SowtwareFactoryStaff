package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.EstimateLink;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("estimateLinkDao")
public class EstimateLinkDaoImpl implements EstimateLinkDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Long create(EstimateLink estimateLink) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(estimateLink);
        return id;
    }

    @Override
    public EstimateLink read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        EstimateLink estimateLink = (EstimateLink) session.get(EstimateLink.class, id);
        return estimateLink;
    }

    @Override
    public void update(EstimateLink estimateLink) {
        Session session = sessionFactory.getCurrentSession();
        session.update(estimateLink);
    }

    @Override
    public void delete(EstimateLink estimateLink) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(estimateLink);
    }

    @Override
    public List<EstimateLink> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from EstimateLink");
        return query.list();
    }
}
