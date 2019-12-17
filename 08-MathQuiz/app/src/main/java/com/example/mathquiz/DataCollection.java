package com.example.mathquiz;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataCollection implements Serializable {

    protected List<Quiz> quizArray = new ArrayList<>();

    public List<Quiz> getQuizArray() {
        return quizArray;
    }
}