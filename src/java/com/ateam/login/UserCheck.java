/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.login;

/**
 *
 * @author agray
 */
import com.ateam.hibernate.*;
import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
public class UserCheck implements Serializable{
	String userName;
	String pwd;
        String role;
	boolean exist;
        String role2;
        String fullName;
			
	public void setUserName(String userName){
		this.userName=userName;
	}
	public void setPwd(String pwd){
		this.pwd=pwd;
	}
	public void setExist(boolean exist){
		this.exist=exist;
	}

	public String getUserName(){
		return userName;
	}
	public String getPwd(){
		return pwd;
	}
	public boolean getExist(){
		return exist;
	}
        public String getRole(){
		return role;
	}
        public String getFullName(){
		return fullName;
	}
public String checkUser() throws Exception {
    String status = "unauthorized";
    
		HibernateDAO dao =(HibernateDAO)ServiceFinder.findBean("SpringHibernateDao");

		if(dao.validateUser(getUserName(),getPwd())!=null){
			exist=true;
                        fullName = dao.checkFullName(getUserName(),getPwd());
                        role = dao.checkRole(getUserName(),getPwd());
                            if(role.equals("Admin")){
                                status = "Adminindex";
		}else {
                                status = "index";
        }
		exist=false;
    
  		
} 
                return status;
}
}
