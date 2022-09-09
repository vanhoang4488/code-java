package paltform.ctv.dao.repository;

import paltform.ctv.dao.entity.model.BasicData;

public interface IMathpixRepository {

    //Gọi MathpixApi để xử lý dữ liệu.
    String scan(BasicData data);

    // Kiểm tra xem file có tồn tại không?
    boolean checkImageFile(String path);
}
