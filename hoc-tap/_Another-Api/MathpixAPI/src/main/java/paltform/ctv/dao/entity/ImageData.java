package paltform.ctv.dao.entity;

import lombok.Builder;
import lombok.Data;
import paltform.ctv.dao.entity.model.BasicData;
import paltform.ctv.dao.entity.model.FileJsonModel;
import paltform.ctv.dao.entity.model.ImageOptionsJsonModel;

@Data
@Builder
public class ImageData extends BasicData {

    protected FileJsonModel files;
    private ImageOptionsJsonModel option_json;
}
