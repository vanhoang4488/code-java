package com.os;

import lombok.Data;

import java.util.List;

@Data
public class Cursor {

    private CursorType type;
    private String content;
    private List<byte[]> imgBytes;
    private List<List<String>> table;

    public Cursor (CursorType type, String content) {
        this.type = type;
        this.content = content;
    }
}
