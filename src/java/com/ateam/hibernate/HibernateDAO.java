/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.hibernate;
import com.ateam.login.*;
import com.ateam.app.*;
import java.util.*;
import org.springframework.dao.DataAccessException;
/**
 *
 * @author agray
 */
public interface HibernateDAO {
   	public UserAttr checkUser(String strUserName) throws DataAccessException,java.sql.SQLException;
	public UserAttr validateUser(String strUserName,String password) throws DataAccessException,java.sql.SQLException;
        public String checkRole(String strUserName,String password) throws DataAccessException, java.sql.SQLException;
        public String checkFullName(String strUserName,String password) throws DataAccessException, java.sql.SQLException;
        public List <Questions> generateQuestion(String skillId,String difficulty) throws DataAccessException,java.sql.SQLException;
        public List<UserAttr> listUsers() throws DataAccessException, java.sql.SQLException;
        public List<Questions> listSkills() throws DataAccessException, java.sql.SQLException;
	public void addUser(com.ateam.hibernate.UserAttr obj) throws DataAccessException; 
        public void deleteUser(String userName) throws DataAccessException;
        public void submitFeedback(com.ateam.app.Questionnaire s)throws DataAccessException;
}
