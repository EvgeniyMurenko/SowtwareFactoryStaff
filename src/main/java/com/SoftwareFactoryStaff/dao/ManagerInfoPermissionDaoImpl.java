package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.ManagerInfoPermission;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("managerInfoPermissionDao")
public class ManagerInfoPermissionDaoImpl implements ManagerInfoPermissionDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public ManagerInfoPermission findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        ManagerInfoPermission managerInfoPermission = (ManagerInfoPermission) session.get(ManagerInfoPermission.class, id);
        return managerInfoPermission;
    }

    @Override
    public List<ManagerInfoPermission> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query =  session.createQuery("from ManagerInfoPermission");
        return query.list();
    }

    @Override
    public ManagerInfoPermission findByPermission(String permission) {
   /*     Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("permission", permission));*/
        return null;
    }


}
