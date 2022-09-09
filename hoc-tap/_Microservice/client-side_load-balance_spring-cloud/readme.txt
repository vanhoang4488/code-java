Một ví dụ đợn giản về cơ chế load-balance (cân bằng tải)
lưu ý duy nhất ở đây là:
say-hello có 3 instance(thể hiện)
mặc định khi run module bằng nút run
hay mvn spring-boot:run
thì chương trình chạy ở cổng 8090.
mà trong SayHelloConfiguration.java ta khai báo 3 instance ở 3 cổng:
+> 8090
+> 9092
+> 9999
=> hệ thống sẽ lần lượt gửi luân phiên request đến 3 thể hiện
=> mà chúng ta có bật 1 thể hiện => 2/3 lần gửi là error 500
=> muốn không bị lỗi thì bật cả 3 thể hiện lên.