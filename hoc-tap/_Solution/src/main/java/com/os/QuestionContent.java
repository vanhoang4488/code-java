package com.os;

import lombok.Setter;

@Setter
public class QuestionContent <T>{

    private UserAnswer<T> userAnswer;

    public T getAnswer (String onlyKey) {
        return userAnswer.getAnswerMap().get(onlyKey);
    }

    public UserAnswer<T> getUserAnswer (UserAnswer userAnswer) {return userAnswer;}
}
