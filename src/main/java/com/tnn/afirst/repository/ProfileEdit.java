package com.tnn.afirst.repository;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.tnn.afirst.domain.Users;

import java.util.List;

@Repository
@Transactional


public class ProfileEdit {

    @Autowired
    private SessionFactory sessionFactory;

    public void addUsers(Users users){
        this.sessionFactory.getCurrentSession().save(users);
    }

    public List<Users> listAll(){
        return this.sessionFactory.getCurrentSession().createQuery("from Users")
                .list();
    }

    public void removeUsers(Integer id){
        Users contact = (Users) this.sessionFactory.getCurrentSession().load(
                Users.class, id);
        if(null != contact){
            this.sessionFactory.getCurrentSession().delete(contact);
        }
    }
}