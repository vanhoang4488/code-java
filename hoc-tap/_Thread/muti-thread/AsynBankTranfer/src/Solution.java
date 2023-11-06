/**
 * Xây dựng hệ thống ngân hàng gồm 10 tài khoản,
 * trong đó các giao dịch chuyển tiền giữa các tài khoản với nhau là ngẫu nhiên.
 * Thiết kế ngân hàng có thể phục vụ một lúc tối đa 10 giao dịch và cứ sau 1000 giao dịch ngân hàng sẽ
 * thống kê tổng số tiền các giao dịch đã giao.
 * ==> Trong ví dụ dưới ta sẽ thấy giá trị của numTransacts trong Bank lúc in ra màn hình thường xuyên có giá trị
 * khác chia hết cho 1000 ---> đây chính là lỗi do không đồng bộ.
 */
public class Solution {
    private final static  int INIT_BALANCE = 10000;
    private final static int MAX_ACCOUNT = 10;
    public static void main(String[] args) {
        Bank bank = new Bank(MAX_ACCOUNT, INIT_BALANCE);
        for (int i = 0; i < MAX_ACCOUNT; i++) {
            Thread thread = new TransferThread(bank, i, INIT_BALANCE);
            thread.setPriority(Thread.NORM_PRIORITY + i % 2);
            thread.start();
        }
    }
}