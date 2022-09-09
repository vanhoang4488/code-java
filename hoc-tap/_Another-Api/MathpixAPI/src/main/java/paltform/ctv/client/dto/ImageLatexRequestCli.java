package paltform.ctv.client.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class ImageLatexRequestCli implements Serializable {
    private static final long serialVersionUID = 1L;

    private String text;
}
