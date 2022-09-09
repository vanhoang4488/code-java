package com.os;

/*
 * Giải thích:
 * 1, Hãy nhớ đến sự kế thừa của phương thức trong java.
 *  +> kiểu cha có thể trỏ đến 1 thể hiện của lớp con,
 *      nhưng về bản chất con trỏ lớp cha đó chỉ có thể chứa các phương thức bên trong lớp cha ban đầu
 *      mà thôi! Những phương thức cài đè của lớp con sẽ được cài đè động trong quá trình run-time.
 *  +> Vì thế những gì cha không có thì không thể gọi.
 * 2, Xét đến ví dụ hiện tại của ta:
 *  +> lớp con có 1 phương thức setData(Integer data ) overloading setData(Object data) của lớp cha.
 *  +> Hỏi: nếu dùng kiều lớp cha truy cập đến setData("hoang"), kết quả xảy ra là gì?
 *  +> lớp cha có, lớp con không cài đè thì lẽ ra phải được chứ nhỉ? => ừ, thì được mà!
 * Tao thật không hiểu sao trên tài liệu oracle: https://docs.oracle.com/javase/tutorial/java/generics/bridgeMethods.html
 * lại báo không được.
 * TL: không được ở đây là Integer so = mn.data;
 * TL: xem kỹ lại, vấn đề ở đây không phải là cấu trúc trước khi complier mà là việc ép các kiểu đối tượng.
 *  +> ở đây là: Node n = mn.
 *  +> chi tiết hơn: tham khảo ví dụ BridgeMethod2.
 */

public class BridgeMethodMain {

    public static void main(String[] args){
        MyNode mn = new MyNode(5);
        Node n = mn;

        n.setData("hoang");
        Integer so = (Integer) mn.data; // vị trí cast lỗi.
    }
}
