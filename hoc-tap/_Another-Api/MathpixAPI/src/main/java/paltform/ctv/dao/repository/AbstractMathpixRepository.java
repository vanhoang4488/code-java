package paltform.ctv.dao.repository;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import paltform.ctv.dao.feign.ICMSMathpixFeign;

@Repository
public abstract class AbstractMathpixRepository {

    @Autowired
    protected ICMSMathpixFeign icmsMathpixFeign;

    @Value("${mathpix.app.id}")
    private String app;

    @Value("${mathpix.app.key}")
    private String key;

    @Value("${image.url.base}")
    protected String imageUrlBase;

    public String getHeaders(){

        return String.format("{'app_id':%s, 'app_key':%s, 'Content-Type':'application/json'}", this.app, this.key);
    }
}
