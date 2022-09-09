Đề bài: Một ví dụ đơn giản về microservices, gồm
    + 1 gateway
    + 2 service

=> bài học rút ra ở đây là, ở các service cần dependency:
        **** spring-cloud-starter-loadbalancer ****

** Lưu ý:
- spring cloud từ Hoxton.SR1 trờ xuống thì service không cần dependency trên.
- từ spring cloud Hoxton.SR2 trở đi thì service bắt buộc cần => nếu không có, thì khi
chạy project sẽ dẫn đến lỗi 503, servie có thể nhận request đầu tiên hoặc không, nhưng
từ request thứ 2 trở đi thì chắc chắn lỗi.