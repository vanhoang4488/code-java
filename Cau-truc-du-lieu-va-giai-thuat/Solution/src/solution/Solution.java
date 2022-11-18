package solution;

import java.io.*;
import java.math.*;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {
    
    public static void main(String[] args) throws UnknownHostException {
       List<Integer> as = new ArrayList<>();
       as.add(1);
       as.add(2);
       as.add(3);
       Iterator<Integer> t = as.iterator();
       while(t.hasNext()) {
           Integer a = t.next();
           if(a == 2) continue;
           System.out.println(a);
       }
    }
}
