package paltform.ctv.dao.entity.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PdfOptionsJsonModel extends ImageOptionsJsonModel {

    private String conversion_format;
}
