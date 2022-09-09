package com.os;

import java.lang.reflect.Method;

public class GFG {

    // create class
    protected class Shape {
        public void draw() {}
    }

    // create a class which extends Shape class
    public class Rectangle extends Shape {
        /**
         * ghi rõ cài đè thì kết quả là false
         */
//        @Override
//        public void draw() {}
    }

    // create main method
    public static void main(String args[])
    {

        try {

            // create class object for class
            // Rectangle and get method object
            Method m = Rectangle.class.getMethod("draw");

            // check method is bridge or not
            boolean isBridge = m.isBridge();

            // print result
            System.out.println(m + " method is Bridge Method :"
                    + isBridge);
        }
        catch (NoSuchMethodException | SecurityException e) {

            // Print Exception if any Exception occurs
            e.printStackTrace();
        }
    }
}
