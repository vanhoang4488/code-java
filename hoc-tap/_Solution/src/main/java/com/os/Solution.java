package com.os;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class Solution {

    public static void main (String[] args) throws ParseException {
        LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Ho_Chi_Minh"));
        Date queryDate = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
        System.out.println(queryDate);
    }

}
