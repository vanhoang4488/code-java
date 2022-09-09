package paltform.ctv.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import paltform.ctv.dao.entity.ImageData;
import paltform.ctv.dao.entity.model.BasicData;
import paltform.ctv.dao.entity.model.FileJsonModel;
import paltform.ctv.dao.entity.model.ImageOptionsJsonModel;
import paltform.ctv.service.AbstractMathpixService;
import paltform.ctv.service.IMathpixService;
import paltform.ctv.utils.RegularExpressionUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;

@Slf4j
@Service
public class ImageService extends AbstractMathpixService implements IMathpixService {
    @Override
    public ResponseEntity<Object> process(String path) {
        // Kiểm tra xem file có tồn tại không dựa theo tên file.
        boolean check = imageRepository.checkImageFile(path);
        if(!check)
            return ResponseEntity.ok("Image file don't exists");

        BasicData data = dataBuilder(path);
        String info = imageRepository.scan(data);

        // trường hợp kết nối thất bại.
        if(info == null) {
            return null;
        }
        return toObject(info);
    }

    @Override
    public BasicData dataBuilder(String path) {
        FileJsonModel file = null;
        try {
            file = FileJsonModel.builder().file(new FileInputStream(path)).build();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ImageOptionsJsonModel optionsJson = ImageOptionsJsonModel.builder()
                .math_inline_delimiters(new String[]{"$", "$"})
                .rm_spaces(true)
                .build();

        return ImageData.builder()
                .files(file)
                .option_json(optionsJson)
                .build();
    }

    @Override
    public ResponseEntity<Object> toObject(String info) {
        String latex = RegularExpressionUtil.textByImageScan(info);
        if(latex == null){
            log.error("Mathpix convert was failed{}", new Date());
        }
        return ResponseEntity.ok(latex);
    }
}
