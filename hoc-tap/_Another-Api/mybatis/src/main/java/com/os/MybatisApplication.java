package com.os;

import org.apache.ibatis.jdbc.SQL;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication(exclude =
        {DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class})
public class MybatisApplication {

    public static void main(String[] args){
        SpringApplication.run(MybatisApplication.class, args);
        sql();
    }
    private static void sql () {
        List<String> fieldNameList = new ArrayList<>();
        fieldNameList.add("state");
        SQL sql = new SQL();
        sql.UPDATE("test");
        fieldNameList.forEach(fieldName ->{
            sql.SET("`"+fieldName+"` = #{entity."+fieldName+"}");
        });
        sql.WHERE("state = 3");
        System.out.println(sql.toString());
    }

}
