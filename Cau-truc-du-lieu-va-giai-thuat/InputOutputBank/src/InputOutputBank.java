/*
    Viết code gửi/rút tiền trong ngân hàng
    Chức năng:
        - rút tiền trong ngân hàng ông A
        - Ghi chú giao dịch
    Input: không có (mã thẻ lấy từ tệp khách hàng 1 -> 3)
    Output:
        - trừ tiền trong thẻ
        - Ghi chú giao dịch
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;
import java.util.Random;

public class InputOutputBank {

    public static final int RUT_TIEN =  0;
    public static final int NAP_TIEN = 1;
    public static final int MAX_MONEY = 999999;

    public static void main(String[] args) {
        System.out.println("Start ...");
        System.out.println("Generator custome ...");
        Bank bank = new Bank();
        Custome[] customes = new Custome[3];
        for (int i = 0; i < 3; i++) {
            customes[i] = new Custome();
            bank.createCard(customes[i]);
        }
        // code tien hành nạp/rút tiền và ghi thông tin giao dịch ra ghi chú
        // có 3 trường hợp:
        // 1. nạp tiền
        // 2. rút tiền - có đủ tiền --> rút được
        // 3. rút tiền - không đủ --> không rút được
        Random generator = new Random();
        File file = new File("note.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (Custome custome : customes) {
                Card card = custome.getCard();
                int active = generator.nextInt(2);
                if (active == NAP_TIEN) {
                    int nap_tien = generator.nextInt(MAX_MONEY);
                    card.napTien(nap_tien);
                    System.out.printf("Nap thanh cong so tien: %d vao tai khoang %d \n", nap_tien, card.getSerialPin());
                    bufferedWriter.write("Nap thanh cong so tien: " + nap_tien + " vao tai khoan: " + card.getSerialPin());
                    bufferedWriter.newLine();
                }
                else {
                    int custome_money = card.getMoney();
                    int required_money = generator.nextInt(MAX_MONEY);
                    if (custome_money > required_money){
                        card.rutTien(required_money);
                        System.out.printf("Rut thanh cong so tien %d tu tai khoan %d \n", required_money, card.getSerialPin());
                        bufferedWriter.write("Rut thanh cong so tien: " + required_money + " tu tai khoan: " + card.getSerialPin());
                        bufferedWriter.newLine();
                    }
                    else{
                        System.out.println("So du trong tai khoan khong du");
                    }
                }
            }
            bufferedWriter.close();
            fileWriter.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}