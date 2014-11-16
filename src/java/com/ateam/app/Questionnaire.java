/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.app;
import java.io.Serializable;

/**
 *
 * @author Andrew
 */
public class Questionnaire {
    private String questionId;
    private String feedback;
    private String timeSpent;
    private Integer interviewId; 
    
public Questionnaire(String questionId, String feedback, String timeSpent, Integer interviewId) {
        this.feedback = feedback;
        this.questionId = questionId;
        this.timeSpent = timeSpent;
        this.interviewId = interviewId;

    }
    public Questionnaire () {
    }
    
    public Questionnaire(String questionId) {
        this.questionId = questionId;
    }
    
    public String getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }
    
    public String getFeedback() {
        return this.feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    public String getTimeSpent() {
        return this.timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
    }
    
    public Integer getInterviewId() {
        return this.interviewId;
    }

    public void setInterviewId(Integer interviewId) {
        this.interviewId = interviewId;
    }
    
}