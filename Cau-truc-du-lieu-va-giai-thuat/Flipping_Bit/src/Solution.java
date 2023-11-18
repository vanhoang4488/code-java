/**
 * Đề bài: cho một số nguyên không âm có độ dài 32 bit
 * Yêu cầu: chuyển số nguyên không âm đó sang hệ cơ số 2 và đảo các bit (0 -> 1, 1->0)
 * sao cho vẫn nhận được một số nguyên không âm và có số nguyên đó có giá trị là 32 bit nhị phân
 * Ví dụ:
 *      0000_0000_0000_0000_0000_0000_0000_1001 = 9
 * ----> convert: 1111_1111_1111_1111_1111_1111_1111_0110 = 42_9496_7286
 * ==> bit dấu là bit thứ 33 và số tính toán thuộc kiểu nguyên thủy long.
 */

public class Solution {
    public static void main(String[] args) {
        long n = 1;
        System.out.println(n);
        System.out.println(Long.toBinaryString(n));
        System.out.println(n + 0x00000000);
        System.out.println(Long.toBinaryString(((n + 0x0000000000000000L) ^ 0x7fffffffffffffffL) & 0x00000000ffffffffL));
        long n2 = ((n + 0x0000000000000000L) ^ 0x7fffffffffffffffL) & 0x00000000ffffffffL;
        System.out.println(n2);
    }
}