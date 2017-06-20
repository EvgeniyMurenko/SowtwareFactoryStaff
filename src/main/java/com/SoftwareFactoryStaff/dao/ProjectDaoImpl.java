package com.SoftwareFactoryStaff.dao;


import com.SoftwareFactoryStaff.model.Project;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("projectDao")
public class ProjectDaoImpl implements ProjectDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }


    @Override
    public Long create(Project project) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(project);
        return id;
    }

    @Override
    public Project read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Project project = (Project) session.get(Project.class, id);
        return project;
    }

    @Override
    public void update(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.update(project);
    }

    @Override
    public void delete(Project project) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(project);
    }

    @Override
    public List<Project> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Project");
        return query.list();
    }
}
