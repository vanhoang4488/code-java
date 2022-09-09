package paltform.ctv.dao.entity;

import lombok.Builder;
import lombok.Data;
import paltform.ctv.dao.entity.model.BasicData;
import paltform.ctv.dao.entity.model.FileJsonModel;
import paltform.ctv.dao.entity.model.PdfOptionsJsonModel;

@Data
@Builder
public class PdfData extends BasicData {

    protected FileJsonModel files;
    private PdfOptionsJsonModel option_json;
}
