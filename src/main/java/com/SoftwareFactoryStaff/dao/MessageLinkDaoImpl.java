package com.SoftwareFactoryStaff.dao;

import com.SoftwareFactoryStaff.model.MessageLink;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("messageLinkDao")
public class MessageLinkDaoImpl implements MessageLinkDao {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public Long create(MessageLink messageLink) {
        Session session = sessionFactory.getCurrentSession();
        Long id = (Long) session.save(messageLink);
        return id;
    }


    @Override
    public MessageLink read(Long id) {
        Session session = sessionFactory.getCurrentSession();
        MessageLink messageLink = (MessageLink) session.get(MessageLink.class, id);
        return messageLink;
    }

    @Override
    public void update(MessageLink messageLink) {
        Session session = sessionFactory.getCurrentSession();
        session.update(messageLink);
    }

    @Override
    public void delete(MessageLink messageLink) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(messageLink);
    }

    @Override
    public List<MessageLink> findAll() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from MessageLink");
        return query.list();
    }
}
