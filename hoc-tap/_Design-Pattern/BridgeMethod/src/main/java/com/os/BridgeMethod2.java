package com.os;


interface Comparable<A>{
    int compareTo(A that);
}

class NumericValue implements Comparable<NumericValue>{

    private byte value;
    public NumericValue(byte value) { this.value = value;}
    public int compareTo(NumericValue that) { return this.value - that.value;}

    /**
     * Nguyên nhân:
     * do Comparabale value = new NumericValue((byte) 0), mà:
     * + NumbericValue == Comparable<NumericValue>
     * + Kiểu tham số Comparabale<Object>
     * => phương thức cầu nối:
     * public int compareTo(Object that) { return compareTo((NumericValue) that);}
     */
}

public class BridgeMethod2 {

    public static void main(String[] args){
        Comparable value = new NumericValue((byte) 0);
        value.compareTo(value); // fine
        value.compareTo("123"); // error
    }
}
