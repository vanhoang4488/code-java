package com.example._solution;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.sql.DataSourceDefinition;
import java.util.List;
import java.util.Map;

@Component
public class Branch {

    @Value("#{${sortedBranch}}")
    private Map<String, Integer> sortedBranch;
    @Value("#{${branch.list}}")
    private List<String> branchList;

    public void display() {
        sortedBranch.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });
        System.out.println("//=====================");
        branchList.stream().forEach(value -> {
            System.out.println(value);
        });
    }
}
