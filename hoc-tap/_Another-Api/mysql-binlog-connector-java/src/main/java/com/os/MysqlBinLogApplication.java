package com.os;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
public class MysqlBinLogApplication {


    public static void main(String[] args) throws IOException {
        SpringApplication.run(MysqlBinLogApplication.class, args);

        BinaryLogClient client =
                new BinaryLogClient(
                        "localhost", 3306,
                        "root", "thaibinh");

        client.registerEventListener(new BinaryLogClient.EventListener() {
            @Override
            public void onEvent(Event event) {
                EventType eventType = event.getHeader().getEventType();
                System.out.println("===> Event type: " + eventType.toString());
                if(eventType == EventType.TABLE_MAP){
                    TableMapEventData tableMapEventData = event.getData();
                    System.out.println("===> database: " + tableMapEventData.getDatabase());
                    System.out.println("===> table: " + tableMapEventData.getTable());
                    System.out.println("===> tableId: " + tableMapEventData.getTableId());
                }

                if(EventType.isWrite(eventType)){
                    WriteRowsEventData data = event.getData();
                    setRowData(data.getRows(), eventType);
                }
                else if(EventType.isDelete(eventType)){
                    DeleteRowsEventData data = event.getData();
                    setRowData(data.getRows(), eventType);
                }
                else if(EventType.isUpdate(eventType)){
                    UpdateRowsEventData data = event.getData();
                }
            }
        });

        client.connect();
    }

    private static void setRowData(List<Serializable[]> linkedList, EventType eventType){
        for(Serializable[] rows : linkedList){

            Arrays.stream(rows).forEach(value -> {System.out.println(value.toString());});
            System.out.println("---------------");
        }
        System.out.println("========>>><<<===========");
    }
}
