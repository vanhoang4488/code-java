package com.os;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class TableParser {

    private static final Pattern CELL_PATTERN = Pattern.compile("<(td)>([^<]+)</\\1>");

    private static final String ROW_START = "<tr>";
    private static final String ROW_END = "</tr>";

    private static final String TABLE_START = "<table>";

    private static final String TABLE_END = "</table>";

    private TableParser() {}

    public static List<Cursor> getTable (List<Cursor> cursors) {
        List<Cursor> tables = new ArrayList<>();
        cursors.forEach(cursor -> {
            if (CursorType.STRING.equals(cursor.getType())) {
                findTable(tables, cursor.getContent());
            }
            else tables.add(cursor);
        });

        return tables;
    }

    private static void findTable (List<Cursor> cursors, String tables) {
        int start = tables.indexOf(TABLE_START);
        int end = tables.indexOf(TABLE_END);

        if (start < 0 || end < 0) return;

        if (start > 0) cursors.add(new Cursor(CursorType.STRING, tables.substring(0, start)));

        List<List<String>> rows = new ArrayList<>();
        findRows(rows, tables.substring(start, end+TABLE_END.length()));
        Cursor cursor = new Cursor(CursorType.TABLE, tables);
        cursor.setTable(rows);
        cursors.add(cursor);

        findTable(cursors, tables.substring(end+TABLE_END.length()));
    }

    private static void findRows (List<List<String>> rows, String table) {
        int start = table.indexOf(ROW_START);
        int end = table.indexOf(ROW_END);

        if (start < 0 && end < 0) return;

        List<String> cells = findCells(table.substring(start, end+ROW_END.length()));
        rows.add(cells);

        findRows(rows, table.substring(end+ROW_END.length()));
    }

    private static List<String> findCells (String row) {
        List<String> cells = new ArrayList<>();
        Matcher matcher = CELL_PATTERN.matcher(row);
        while (matcher.find()) {
            cells.add(matcher.group(2));
        }
        return cells;
    }
}
