package com.os.interceptor;

import com.os.entity.QuestionAnswer;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.StringValue;
import net.sf.jsqlparser.expression.operators.relational.ExpressionList;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import net.sf.jsqlparser.expression.operators.relational.MultiExpressionList;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.insert.Insert;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Intercepts(
        value = {
                @Signature(type = Executor.class, method = "query",
                        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class QuestionAnswerInterceptor implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler handler = (StatementHandler) invocation.getTarget();
        MetaObject metaObject = MetaObject.forObject(handler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY, new DefaultReflectorFactory());
        MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");

        if (SqlCommandType.INSERT == mappedStatement.getSqlCommandType() ||
                SqlCommandType.UPDATE == mappedStatement.getSqlCommandType()) {
            BoundSql boundSql = handler.getBoundSql();
            Statement statement = CCJSqlParserUtil.parse(boundSql.getSql());
        }
        return invocation.proceed();
    }

    private String getTable (Statement statement) {
        if (statement instanceof Insert) return ((Insert) statement).getTable().getName();
        else  return ((Update) statement).getTable().getName();
    }

    private void processor (Statement statement) {
        if (statement instanceof Insert) this.processorInsert((Insert) statement);
        else this.processorUpdate((Update) statement);
    }

    private void processorInsert (Insert insert) {
        String tableName = insert.getTable().getName();
        if (QuestionAnswer.class.getSimpleName().equalsIgnoreCase(tableName)) {
            List<ExpressionList> expressionLists = this.getItemsListExpressionList(insert);
            expressionLists.forEach(expressionList -> {
                List<Expression> expressions = expressionList.getExpressions();
                expressions.forEach(expression -> {
                    if (expression instanceof StringValue) {
                        StringValue stringValue = (StringValue) expression;
                        stringValue.get
                    }
                });
            });
        }
    }

    private void processorUpdate (Update update) {
        String tableName = update.getTable().getName();
        if (QuestionAnswer.class.getSimpleName().equalsIgnoreCase(tableName)) {

        }
    }

    private List<ExpressionList> getItemsListExpressionList(Insert insert){
        ItemsList itemsList = insert.getItemsList();
        List<ExpressionList> expressionList = new ArrayList<>(10);
        if(itemsList instanceof MultiExpressionList){
            MultiExpressionList multiExpressionList = (MultiExpressionList)insert.getItemsList();
            expressionList.addAll(multiExpressionList.getExpressionLists());
        }else{
            ExpressionList expressions = (ExpressionList)insert.getItemsList();
            expressionList.add(expressions);
        }
        return expressionList;
    }
}
