package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.ManagerInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("managerInfoDao")
public class ManagerInfoDaoImpl implements ManagerInfoDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public Long create(ManagerInfo managerInfo) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(managerInfo);
        return id;
    }

    @Override
    public ManagerInfo read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        ManagerInfo managerInfo = (ManagerInfo) session.get(ManagerInfo.class, id);
        return managerInfo;
    }

    @Override
    public void update(ManagerInfo managerInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.update(managerInfo);
    }

    @Override
    public void delete(ManagerInfo managerInfo) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(managerInfo);
    }

    @Override
    public List<ManagerInfo> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from ManagerInfo");
        return query.list();
    }
}

