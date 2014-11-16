/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.app;
import com.ateam.hibernate.*;
import com.ateam.login.*;
import java.io.Serializable;
import java.util.*;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
/**
 *
 * @author Andrew
 */
@ManagedBean
@SessionScoped
public class QuestionBean implements Serializable {
    String skillId;
    String questionText;
    String difficulty;
    String exTime;
    String exAnswer;
    String questionType;
    String businessUnit;
    String feedback;
    List status2;
    List status3;
    HibernateDAO dao;
    com.ateam.app.Questions q;
				
	public void setSkillId(String skillId){
		this.skillId=skillId;
	}
	public void setQuestionText(String questionText){
		this.questionText=questionText;
	}
	public void setDifficulty(String difficulty){
		this.difficulty=difficulty;
	}
	public void setExTime(String exTime){
		this.exTime=exTime;
	}
	public void setExAnswer(String exAnswer){
		this.exAnswer=exAnswer;
	}
        public void setFeedback(String feedback){
		this.feedback=feedback;
	}
        
	public String getSkillId(){
		return skillId;
	}
	public String getQuestionText(){
		return questionText;
	}
	public String getDifficulty(){
		return difficulty;
	}
	public String getExTime(){
		return exTime;
	}
	public String getExAnswer(){
		return exAnswer;
	}
        public String getquestionType(){
		return questionType;
	}
        public String getbusinessUnit(){
		return businessUnit;
	}
        public String getFeedback(){
		return feedback;
	}
        public void unsetSkillId(){
		this.skillId=null;
	}
        public String generateQuestion() throws Exception {
            String status = "placeholder";
            HibernateDAO dao =(HibernateDAO)ServiceFinder.findBean("SpringHibernateDao");
            com.ateam.app.Questions q = new com.ateam.app.Questions();
            q.setSkillId(getSkillId());
            q.setDifficulty(getDifficulty());
            status2 = dao.generateQuestion(getSkillId(),getDifficulty());
            status = "results";
            return status;
  }
        
        public String adminGenerateQuestion() throws Exception {
            String status = "placeholder";
            dao =(HibernateDAO)ServiceFinder.findBean("SpringHibernateDao");
            q = new com.ateam.app.Questions();
            q.setSkillId(getSkillId());
            q.setDifficulty(getDifficulty());
            status2=dao.generateQuestion(getSkillId(),getDifficulty());
            status = "adminResults";
            return status;
  }
        public List questionList() throws Exception{
            return status2;
        }
        
        public void addQuestion() throws Exception{
            q.setSkillId(getSkillId());
            q.setDifficulty(getDifficulty());
            status2.add(dao.generateQuestion(getSkillId(),getDifficulty()));
        }
        
        public List listSkills() throws Exception {
            HibernateDAO dao =(HibernateDAO)ServiceFinder.findBean("SpringHibernateDao");
            com.ateam.app.Questions r = new com.ateam.app.Questions();
            List skills = dao.listSkills();
            return skills;
  }
        
        public String submitFeedback() throws Exception {
            String status = "placeholder";
            HibernateDAO dao2 =(HibernateDAO)ServiceFinder.findBean("SpringHibernateDao");
            com.ateam.app.Questionnaire s = new com.ateam.app.Questionnaire();
            s.setFeedback(getFeedback());
            dao2.submitFeedback(s);
            status = "results2";
            return status;
  }
}
