package com.os;

import lombok.Data;

import java.util.Map;

@Data
public class UserAnswer<T> {
    private Map<String, T> answerMap;
    private Map<String, Double> scoreMap;
}
