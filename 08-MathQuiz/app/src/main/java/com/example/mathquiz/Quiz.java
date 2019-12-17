package com.example.mathquiz;

import java.io.Serializable;

public class Quiz implements Comparable, Serializable {

    private String question;
    private String answer;
    private String message;
    private float result;


    public Quiz(String question, String answer, String message, float result) {
        this.question = question;
        this.answer = answer;
        this.message = message;
        this.result = result;
    }


    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return
                "Question: " + question + '\n' +
                "Your answer: " + answer + '\n' +
                "Message: " + message + '\n' +
                "Result: " + result ;
    }

    @Override
    public int compareTo(Object o) {
        Quiz otherObject = (Quiz) o;
        return message.compareTo(otherObject.getMessage());
    }
}
