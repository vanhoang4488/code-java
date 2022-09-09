package com.os;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class DataCache {

    @RandomInt(min = 1, max =10)
    private int group;
    private String name;
}
