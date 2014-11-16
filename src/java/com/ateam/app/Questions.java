/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ateam.app;
import java.io.Serializable;

/**
 *
 * @author agray
 */
public class Questions implements Serializable {
    private String skillId;
    private String questionId;
    private String questionText;
    private String difficulty;
    private String exTime;
    private String exAnswer;
    private String questionType;
    private String businessUnit;

    public Questions(String skillId, String questionID, String questionText, String difficulty, String exTime, String exAnswer,String questionType, String businessUnit) {
        this.skillId = skillId;
        this.questionId = questionID;
        this.questionText = questionText;
        this.difficulty = difficulty;
        this.exTime = exTime;
        this.exAnswer = exAnswer;
        this.questionType = questionType;
        this.businessUnit = businessUnit;
    }

    public Questions () {
    }

    public Questions(String skillId) {
        this.skillId = skillId;
    }

    public String getSkillId() {
        return this.skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }
    public String getQuestionId() {
        return this.questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getquestionText() {
        return this.questionText;
    }

    public void setquestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getDifficulty() {
        return this.difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getexTime() {
        return this.exTime;
    }

    public void setexTime(String exTime) {
        this.exTime = exTime;
    }

    public String getexAnswer() {
        return this.exAnswer;
    }

    public void setexAnswer(String exAnswer) {
        this.exAnswer = exAnswer;
    }
    public String getquestionType() {
        return this.questionType;
    }

    public void setquestionType(String questionType) {
        this.questionType = questionType;
    }
    public String getbusinessUnit() {
        return this.businessUnit;
    }

    public void setbusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }
    
}