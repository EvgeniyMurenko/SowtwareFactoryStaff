package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.Estimate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("estimateDao")
public class EstimateDaoImpl implements EstimateDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    @Override
    public Long create(Estimate estimate) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(estimate);
        return id;
    }

    @Override
    public Estimate read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select distinct estimate from Estimate estimate left join fetch estimate.estimateLinks where estimate.id = :id");
        query.setParameter("id", id);
        return (Estimate) query.uniqueResult();
    }

    @Override
    public void update(Estimate estimate) {
        Session session = sessionFactory.getCurrentSession();
        session.update(estimate);
    }

    @Override
    public void delete(Estimate estimate) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(estimate);
    }

    @Override
    public List<Estimate> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Estimate");
        return query.list();
    }

    @Override
    public Estimate findEstimateByCustomerInfoId(Long id){
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select estimate from Estimate estimate where estimate.customerInfo.id =:id");
        query.setParameter("id", id);
        return (Estimate) query.uniqueResult();

    }
}
