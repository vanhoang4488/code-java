package com.os;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class RandomIntGenerator {

    private Random random = new Random();
    private final DataCache dataCache;

    public int generator(int min, int max){
        return random.nextInt(max-min)+max;
    }
}
