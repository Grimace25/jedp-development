/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.hibernate;
import com.ateam.app.*;
import java.util.*;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateOperations;
import javax.persistence.EntityManager;
import org.hibernate.criterion.*;
import org.hibernate.*;
import java.sql.*;

import javax.servlet.http.HttpSession;

/**
 *
 * @author agray
 */
public class HibernateDAOImpl extends HibernateDaoSupport implements HibernateDAO {
            Questions obj2 = null;
	public UserAttr checkUser(String strUserName)
			throws DataAccessException, java.sql.SQLException {
		UserAttr obj = null;
		DetachedCriteria critone = DetachedCriteria.forClass(UserAttr.class);
		critone.add(Restrictions.eq("userName", strUserName));

		List objs = getHibernateTemplate().findByCriteria(critone);
		if ((objs != null) && (objs.size() > 0)) {
			obj = (UserAttr) objs.get(0);
		}
		return obj;
	}	

	public UserAttr validateUser(String strUserName,String password) throws DataAccessException, java.sql.SQLException {
		UserAttr obj = null;
		DetachedCriteria crittwo = DetachedCriteria.forClass(UserAttr.class);
		crittwo.add(Restrictions.eq("userName", strUserName));
		crittwo.add(Restrictions.eq("userPassword", password));
		List objs = getHibernateTemplate().findByCriteria(crittwo);
		if ((objs != null) && (objs.size() > 0)) {
			obj = (UserAttr) objs.get(0);
		}
		return obj;
	}

        public String checkRole(String strUserName,String password) throws DataAccessException, java.sql.SQLException {
		String obj = null;
		DetachedCriteria critthree = DetachedCriteria.forClass(UserAttr.class);
                ProjectionList pl = Projections.projectionList();
                pl.add(Projections.groupProperty("userRole"));
		critthree.add(Restrictions.eq("userName", strUserName));
		critthree.add(Restrictions.eq("userPassword", password));
                critthree.setProjection(pl);
		List objs = getHibernateTemplate().findByCriteria(critthree);
		if ((objs != null) && (objs.size() > 0)) {
			obj = (String) objs.get(0);
		}
		return obj;
	}
        
        public String checkFullName(String strUserName,String password) throws DataAccessException, java.sql.SQLException {
		String obj = null;
		DetachedCriteria critname = DetachedCriteria.forClass(UserAttr.class);
                ProjectionList pl = Projections.projectionList();
                pl.add(Projections.groupProperty("userFullName"));
		critname.add(Restrictions.eq("userName", strUserName));
		critname.add(Restrictions.eq("userPassword", password));
                critname.setProjection(pl);
		List objs = getHibernateTemplate().findByCriteria(critname);
		if ((objs != null) && (objs.size() > 0)) {
			obj = (String) objs.get(0);
		}
		return obj;
	}

        public List<Questions> generateQuestion(String skillId,String difficulty)throws DataAccessException, java.sql.SQLException {
            Questions obj = null;
            DetachedCriteria criteria = DetachedCriteria.forClass(Questions.class);
            criteria.add(Restrictions.eq("skillId", skillId));
            criteria.add(Restrictions.eq("difficulty", difficulty));
            criteria.add(Restrictions.sqlRestriction("1=1 order by rand() LIMIT 1"));
            List objs = getHibernateTemplate().findByCriteria(criteria);
		if ((objs != null) && (objs.size() > 0)) {
			obj = (Questions) objs.get(0);
		}
		return objs;
        }
	public void addUser(com.ateam.hibernate.UserAttr obj)throws DataAccessException {
		getHibernateTemplate().save(obj);
	}
        public void deleteUser(String userName) throws DataAccessException {
            UserAttr obj4 = null;
            DetachedCriteria criteria4 = DetachedCriteria.forClass(UserAttr.class);
                criteria4.add(Restrictions.eq("userName", userName));
                List objs = getHibernateTemplate().findByCriteria(criteria4);
		if ((objs != null) && (objs.size() > 0)) {
			obj4 = (UserAttr) objs.get(0);
                        getHibernateTemplate().delete(obj4);
		}
                
	}
        public List<UserAttr> listUsers() throws DataAccessException, java.sql.SQLException {
            UserAttr obj = null;
            DetachedCriteria critfour = DetachedCriteria.forClass(UserAttr.class);
            critfour.setProjection(Projections.property("userName"));
            List objs = getHibernateTemplate().findByCriteria(critfour);

		return objs;
	}
        
        public List<Questions> listSkills() throws DataAccessException, java.sql.SQLException {
            Questions obj = null;
            DetachedCriteria critfive = DetachedCriteria.forClass(Questions.class);
            critfive.setProjection(Projections.distinct(Projections.property("skillId")));
            List objs = getHibernateTemplate().findByCriteria(critfive);

		return objs;
	}
        public void submitFeedback(com.ateam.app.Questionnaire s)throws DataAccessException {
            getHibernateTemplate().save(s);
	}
}
