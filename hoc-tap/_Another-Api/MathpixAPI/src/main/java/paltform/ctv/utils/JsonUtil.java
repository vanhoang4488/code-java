package paltform.ctv.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Slf4j
@Component
public class JsonUtil {

    @Autowired
    private static ObjectMapper objectMapper;

    @PostConstruct
    public void init(){
        if(Objects.isNull(objectMapper)){
            this.initInstance();
        }
    }

    private synchronized void initInstance(){

        objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        objectMapper.enable(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS);
    }

    public static String objectToJson(Object object){

        String tmp = "";
        try{
            if(object != null){
                tmp = objectMapper.writeValueAsString(object);
            }
        }
        catch(JsonProcessingException e){
            log.error("Mapping Object to Json was failed {}", e.getMessage());
        }
        return tmp;
    }

    public static Object jsonToObject(String json, Class<?> clazz) throws Exception{

        Object object = null;
        try{
            object = objectMapper.readValue(json, clazz);
        }
        catch(Exception e){
            log.error("Mapping Json to Object was failed {}", e.getMessage());
            throw new Exception("Mapping Json to Object was failed {}" + e.getMessage());
        }
        return object;
    }
}
