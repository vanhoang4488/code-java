package paltform.ctv.dao.entity.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ImageOptionsJsonModel {

    private String[] math_inline_delimiters;
    private boolean rm_spaces;
}
