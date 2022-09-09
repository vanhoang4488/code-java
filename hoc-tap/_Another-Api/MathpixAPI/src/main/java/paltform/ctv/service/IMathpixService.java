package paltform.ctv.service;

import org.springframework.http.ResponseEntity;
import paltform.ctv.dao.entity.model.BasicData;

public interface IMathpixService {

    //bộ xử lý trung tâm, gọi đến các hàm để xử lý yêu cầu.
    ResponseEntity<Object> process(String path);

    //chuyển dữ liệu đầu vào sang Json và bổ sung thêm các yêu cầu cho scan.
    BasicData dataBuilder(String path);

    //Chuyển Json nhận được dang kiểu đối tượng mong muốn.
    ResponseEntity<Object> toObject(String info);
}
