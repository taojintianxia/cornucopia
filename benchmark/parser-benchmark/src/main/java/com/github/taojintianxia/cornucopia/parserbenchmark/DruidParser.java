package com.github.taojintianxia.cornucopia.parserbenchmark;

import com.github.taojintianxia.cornucopia.parserbenchmark.constant.SQLConstant;
import com.github.taojintianxia.cornucopia.parserbenchmark.executor.SqlExecutor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DruidParser {

    public static void main( String... args ) {
        evaluateSimpleSelect();
        evaluateCreateTable();
        evaluateSimpleInsert();
        evaluateInsertAndUpdate();
        evaluateRegularJoin();
        evaluateLeftJoin();
        evaluateRightJoin();
        evaluateAddPrimaryKey();
        evaluateDropPrimaryKey();
        evaluateGroupByHaving();
        evaluateCreateIndexInCreateTable();
        evaluateCreateIndexForExistingTable();
        evaluateAggregateFunctionQueries();
        evaluateAddColumn();
        evaluateEditColumn();
        evaluateRenameColumn();
        evaluateDropColumn();
        evaluateCreateTableWithNonDuplicateValue();
        evaluateSelectComplexMax();
        evaluateSelectComplexExist();
        evaluateSelectComplexIn();
        evaluateSelectComplexSelfJoin();
        evaluateSelectComplexInnerJoin();
    }

    public static void evaluateSimpleSelect() {
        SqlExecutor.executeAndEvaluateSqlByDruid("SIMPLE_SELECT", SQLConstant.SIMPLE_SELECT);
    }

    public static void evaluateCreateTable() {
        SqlExecutor.executeAndEvaluateSqlByDruid("CREATE_TABLE", SQLConstant.CREATE_TABLE);
    }

    public static void evaluateSimpleInsert() {
        SqlExecutor.executeAndEvaluateSqlByDruid("SIMPLE_INSERT", SQLConstant.SIMPLE_INSERT);
    }

    public static void evaluateInsertAndUpdate() {
        SqlExecutor.executeAndEvaluateSqlByDruid("INSERT_AND_UPDATE", SQLConstant.INSERT_AND_UPDATE);
    }

    public static void evaluateRegularJoin() {
        SqlExecutor.executeAndEvaluateSqlByDruid("REGULAR_JOIN", SQLConstant.REGULAR_JOIN);
    }

    public static void evaluateLeftJoin() {
        SqlExecutor.executeAndEvaluateSqlByDruid("LEFT_JOIN", SQLConstant.LEFT_JOIN);
    }

    public static void evaluateRightJoin() {
        SqlExecutor.executeAndEvaluateSqlByDruid("RIGHT_JOIN", SQLConstant.RIGHT_JOIN);
    }

    public static void evaluateAddPrimaryKey() {
        SqlExecutor.executeAndEvaluateSqlByDruid("ADD_PRIMARY_KEY", SQLConstant.ADD_PRIMARY_KEY);
    }

    public static void evaluateDropPrimaryKey() {
        SqlExecutor.executeAndEvaluateSqlByDruid("DROP_PRIMARY_KEY", SQLConstant.DROP_PRIMARY_KEY);
    }

    public static void evaluateGroupByHaving() {
        try {
            SqlExecutor.executeAndEvaluateSqlByDruid("GROUP_BY_HAVING", SQLConstant.GROUP_BY_HAVING);
        } catch (Exception e) {
            log.error("got exception for {}", "GROUP_BY_HAVING");
        }
    }

    public static void evaluateCreateIndexInCreateTable() {
        SqlExecutor.executeAndEvaluateSqlByDruid("CREATE_INDEX_IN_CREATE_TABLE", SQLConstant.CREATE_INDEX_IN_TABLE);
    }

    public static void evaluateCreateIndexForExistingTable() {
        SqlExecutor.executeAndEvaluateSqlByDruid("CREATE_INDEX_FOR_EXISTING_TABLE", SQLConstant.CREATE_INDEX_FOR_EXISTING_TABLE);
    }

    public static void evaluateAggregateFunctionQueries() {
        SqlExecutor.executeAndEvaluateSqlByDruid("AGGREGATE_FUNCTION_QUERIES", SQLConstant.AGGREGATE_FUNCTION_QUERIES);
    }

    public static void evaluateAddColumn() {
        SqlExecutor.executeAndEvaluateSqlByDruid("ADD_COLUMN", SQLConstant.ADD_COLUMN);
    }

    public static void evaluateEditColumn() {
        SqlExecutor.executeAndEvaluateSqlByDruid("EDIT_COLUMN", SQLConstant.EDIT_COLUMN);
    }

    public static void evaluateRenameColumn() {
        SqlExecutor.executeAndEvaluateSqlByDruid("RENAME_COLUMN", SQLConstant.RENAME_COLUMN);
    }

    public static void evaluateDropColumn() {
        SqlExecutor.executeAndEvaluateSqlByDruid("DROP_COLUMN", SQLConstant.DROP_COLUMN);
    }

    public static void evaluateCreateTableWithNonDuplicateValue() {
        SqlExecutor.executeAndEvaluateSqlByDruid("CREATE_TABLE_WITH_NONE_DUPLICATE_VALUE", SQLConstant.CREATE_TABLE_WITH_NONE_DUPLICATE_VALUE);
    }

    public static void evaluateSelectComplexMax() {
        SqlExecutor.executeAndEvaluateSqlByDruid("SELECT_COMPLEX_MAX", SQLConstant.SELECT_COMPLEX_MAX);
    }

    public static void evaluateSelectComplexExist() {
        SqlExecutor.executeAndEvaluateSqlByDruid("SELECT_COMPLEX_EXIST", SQLConstant.SELECT_COMPLEX_EXIST);
    }

    public static void evaluateSelectComplexIn() {
        SqlExecutor.executeAndEvaluateSqlByDruid("SELECT_COMPLEX_IN", SQLConstant.SELECT_COMPLEX_IN);
    }

    public static void evaluateSelectComplexSelfJoin() {
        SqlExecutor.executeAndEvaluateSqlByDruid("SELECT_SELF_JOIN", SQLConstant.SELECT_SELF_JOIN);
    }

    public static void evaluateSelectComplexInnerJoin() {
        SqlExecutor.executeAndEvaluateSqlByDruid("SELECT_COMPLEX_INNER_JOIN", SQLConstant.SELECT_COMPLEX_INNER_JOIN);
    }
}

