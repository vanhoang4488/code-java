

public class Solution {

    public static void main (String[] args) {
        long n = 1;
        System.out.println(n);
        System.out.println(Long.toBinaryString(n));
        System.out.println(n + 0x00000000);
        System.out.println(Long.toBinaryString(((n + 0x0000000000000000L) ^ 0x7fffffffffffffffL) & 0x00000000ffffffffL));
        long n2 = ((n + 0x0000000000000000L) ^ 0x7fffffffffffffffL) & 0x00000000ffffffffL;
        System.out.println(n2);
    }
}
