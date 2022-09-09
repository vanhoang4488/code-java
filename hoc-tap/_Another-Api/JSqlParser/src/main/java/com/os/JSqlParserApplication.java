package com.os;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.expression.operators.relational.ItemsListVisitorAdapter;
import net.sf.jsqlparser.expression.operators.relational.MultiExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.select.FromItem;
import net.sf.jsqlparser.statement.select.Join;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.update.Update;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class JSqlParserApplication {

    // ExpressionList là  nguyên 1 dòng giá trị.
    // Expression là 1 giá trị trong dòng đó.
    // nếu có nhiều hơn 1 dòng chèn vào thì là MultiExpressionList.
    @Test
    public void WhatIsExpression() throws JSQLParserException {
        String sql = "Insert into mybatis(id, name, count) values" +
                "(1, 'a', 1), " +
                "(2, 'b', 2)";
        Statement statement = CCJSqlParserUtil.parse(sql);
        Insert insert = (Insert) statement;
        ItemsList itemsList = insert.getItemsList();
        List<ExpressionList> expressionList = new ArrayList<>(10);
        if(itemsList instanceof MultiExpressionList){
            MultiExpressionList multiExpressionList = (MultiExpressionList)insert.getItemsList();
            expressionList.addAll(multiExpressionList.getExpressionLists());
            System.out.println("--------------------");
        }else{
            ExpressionList expressions = (ExpressionList)insert.getItemsList();
            expressionList.add(expressions);
        }
        expressionList.forEach(e -> {
            System.out.println(e.toString());
            List<Expression> expressions = e.getExpressions();
            expressions.forEach(ex -> {
                System.out.println("==> {}: " + ex.toString());
            });
        });

        System.out.println(insert.toString());
    }

    @Test
    public void andExpression() throws JSQLParserException {
        String sql = "update Mybatis " +
                "SET a = 'name'" +
                "Where b = 2";
        Statement statement = CCJSqlParserUtil.parse(sql);

        Update update = (Update) statement;
        System.out.println("==> last update: " + update.toString());
        Expression expression = update.getWhere();
        String extraWhere = "(1 = 1) and";
        Expression extraExpression = CCJSqlParserUtil.parseExpression(extraWhere);
        System.out.println("==> extra expression: " + extraExpression.toString());
        AndExpression andExpression = new AndExpression(expression, extraExpression);
        System.out.println("==> andExpression: " + andExpression.toString());
        update.setWhere(andExpression);
        System.out.println("==> now update: " + update.toString());
    }

    @Test
    public void setColumn() throws JSQLParserException {
        String sql = "Insert into mybatis(id, name, count) values" +
                "(1, 'a', 1), " +
                "(2, 'b', 2)";
        Statement statement = CCJSqlParserUtil.parse(sql);
        Insert insert = (Insert) statement;

        // setColumns
        List<Column> columns = insert.getColumns();
        Column column = new Column("total");
        columns.add(column);
        insert.setColumns(columns);
        insert.getColumns().forEach(c -> System.out.println("==> c1: " + c.toString()));
        System.out.println("-----------------");
    }

    @Test
    public void addColumn() throws JSQLParserException {
        String sql = "Insert into mybatis(id, name, count) values" +
                "(1, 'a', 1), " +
                "(2, 'b', 2)";
        Statement statement = CCJSqlParserUtil.parse(sql);
        Insert insert = (Insert) statement;

        // addColumns
        Column column = new Column("total");
        insert.addColumns(column);
        insert.getColumns().forEach(c -> System.out.println("==> c2: " + c.toString()));
    }

    // áp dụng trong batch.
    @Test
    public void WhatIsDuplicateUpdateColumns() throws JSQLParserException {
        String sql = "Insert into mybatis(id, name, count) values" +
                "(1, 'a', 1), " +
                "(2, 'b', 2)";
        Statement statement = CCJSqlParserUtil.parse(sql);
        Insert insert = (Insert) statement;

        // addColumns
        Column column = new Column("total");
        insert.addColumns(column);
        insert.getColumns().forEach(c -> System.out.println("==> c: " + c.toString()));

        List<Column> ducList = insert.getDuplicateUpdateColumns();
        if(!Objects.isNull(ducList))
            System.out.println("??????????");
        //ducList.forEach(c -> System.out.println("-->> duc: " + c.toString()));
    }

    //fromItem
    @Test
    public void fromItem() throws JSQLParserException {
        String sql = "Select a, b from `Mybatis` as my";
        Statement statement = CCJSqlParserUtil.parse(sql);

        Select select = (Select) statement;
        PlainSelect plainSelect = (PlainSelect) select.getSelectBody();
        System.out.printf("===> plainSelect: %s\n", plainSelect.toString());
        FromItem fromItem = plainSelect.getFromItem();
        Alias alias = fromItem.getAlias();
        if(!Objects.isNull(alias))
            System.out.println("===> alias table name: " + alias.getName());
        System.out.printf("===> table name: %s\n", fromItem.toString());
    }

    //Table
    @Test
    public void table() throws JSQLParserException{
        String sql = "delete from Mybatis Where a = 'name'";
        Statement statement = CCJSqlParserUtil.parse(sql);

        Delete delete = (Delete) statement;
        Table table = delete.getTable();
        System.out.println("==> delete: " + delete.toString());
        System.out.println("==> table to String: " + table.toString());
        System.out.println("==> table name: " + table.getName());
    }

    @Test
    public void addKeyAndValueExpressionList() throws JSQLParserException {
        String sql = "insert into mybatis " +
                "values" +
                "(1, 2, 3)";
        Statement statement = CCJSqlParserUtil.parse(sql);
        Insert insert = (Insert) statement;

        Column column = new Column("tenantId");
        insert.addColumns(column);
        System.out.println("====> afterAddColumn: " + insert.toString());

        ItemsList itemsList = insert.getItemsList();
        itemsList.accept(new ItemsListVisitorAdapter() {
            @Override
            public void visit(ExpressionList expressionList){
                List<Expression> expressions = expressionList.getExpressions();

                expressionList.addExpressions(new StringValue("123"));
            }
        });
        System.out.println("====> afterAddValue: " + insert.toString());
    }

    @Test
    public void visitPlainSelect() throws JSQLParserException{
        String sql = "select name from mybatis where 1 = 1";
        Statement statement = CCJSqlParserUtil.parse(sql);

        Select select = (Select) statement;

        System.out.println(select.toString());
    }

    @Test
    public void joinPlainSelect() throws JSQLParserException{
        String sql = "select name from mybatis where 1 = 1";
        Statement statement = CCJSqlParserUtil.parse(sql);

        Select select = (Select) statement;

        PlainSelect plainSelect = (PlainSelect) select.getSelectBody();

        List<Join> list = plainSelect.getJoins();

    }


}
