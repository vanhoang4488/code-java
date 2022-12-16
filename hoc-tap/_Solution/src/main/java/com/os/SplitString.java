package com.os;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SplitString {

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] strs = line.split("\\\\n|<br\\/>|<br>");
        Arrays.stream(strs).forEach(System.out::println);
    }
}
