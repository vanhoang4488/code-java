package paltform.ctv.dao.entity.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;

@Getter
@Setter
@Builder
public class FileJsonModel {

    private FileInputStream file;
}
