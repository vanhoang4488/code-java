package paltform.ctv.dao.repository.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import paltform.ctv.dao.entity.ImageData;
import paltform.ctv.dao.entity.model.BasicData;
import paltform.ctv.dao.repository.AbstractMathpixRepository;
import paltform.ctv.dao.repository.IMathpixRepository;
import paltform.ctv.utils.JsonUtil;

import java.io.File;

@Slf4j
@Repository
public class ImageRepository extends AbstractMathpixRepository implements IMathpixRepository{

    @Override
    public String scan(BasicData data) {
        ImageData imageData = (ImageData) data;

        ResponseEntity<Object> entity = icmsMathpixFeign.imageScan(this.getHeaders(),
                JsonUtil.objectToJson(imageData.getFiles()),
                JsonUtil.objectToJson(imageData.getOption_json()));

        if(entity.getStatusCode().is2xxSuccessful() && entity.getBody() != null)
            return entity.getBody().toString();

        return null;
    }

    @Override
    public boolean checkImageFile(String path) {

        File file = new File(path);
        if(file.exists())
            return true;
        return false;
    }
}
