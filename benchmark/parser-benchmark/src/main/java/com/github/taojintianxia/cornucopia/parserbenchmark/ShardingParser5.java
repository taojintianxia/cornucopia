package com.github.taojintianxia.cornucopia.parserbenchmark;

import com.github.taojintianxia.cornucopia.parserbenchmark.constant.SQLConstant;
import com.github.taojintianxia.cornucopia.parserbenchmark.executor.SqlExecutor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ShardingParser5 {

    public static void main( String... args ) {
//        evaluateSimpleSelect();
//        evaluateCreateTable();
//        evaluateSimpleInsert();
//        evaluateInsertAndUpdate();
//        evaluateRegularJoin();
//        evaluateLeftJoin();
//        evaluateRightJoin();
//        evaluateAddPrimaryKey();
//        evaluateDropPrimaryKey();
//        evaluateGroupByHaving();
//        evaluateCreateIndexInCreateTable();
//        evaluateCreateIndexForExistingTable();
//        evaluateAggregateFunctionQueries();
//        evaluateAddColumn();
//        evaluateEditColumn();
//        evaluateRenameColumn();
//        evaluateDropColumn();
//        evaluateCreateTableWithNonDuplicateValue();
        evaluateSelectComplexMax();
        evaluateSelectComplexExist();
        evaluateSelectComplexIn();
        evaluateSelectComplexSelfJoin();
        evaluateSelectComplexInnerJoin();
    }

    public static void evaluateSimpleSelect() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("SIMPLE_SELECT", SQLConstant.SIMPLE_SELECT);
    }

    public static void evaluateCreateTable() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("CREATE_TABLE", SQLConstant.CREATE_TABLE);
        } catch (Exception e) {
            log.error("got exception for {}", "CREATE_TABLE");
        }
    }

    public static void evaluateSimpleInsert() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("SIMPLE_INSERT", SQLConstant.SIMPLE_INSERT);
    }

    public static void evaluateInsertAndUpdate() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("INSERT_AND_UPDATE", SQLConstant.INSERT_AND_UPDATE);
    }

    public static void evaluateRegularJoin() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("REGULAR_JOIN", SQLConstant.REGULAR_JOIN);
    }

    public static void evaluateLeftJoin() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("LEFT_JOIN", SQLConstant.LEFT_JOIN);
    }

    public static void evaluateRightJoin() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("RIGHT_JOIN", SQLConstant.RIGHT_JOIN);
    }

    public static void evaluateAddPrimaryKey() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("ADD_PRIMARY_KEY", SQLConstant.ADD_PRIMARY_KEY);
        } catch (Exception e) {
            log.error("got exception for {}", "ADD_PRIMARY_KEY");
        }
    }

    public static void evaluateDropPrimaryKey() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("DROP_PRIMARY_KEY", SQLConstant.DROP_PRIMARY_KEY);
        } catch (Exception e) {
            log.error("got exception for {}", "DROP_PRIMARY_KEY");
        }
    }

    public static void evaluateGroupByHaving() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("GROUP_BY_HAVING", SQLConstant.GROUP_BY_HAVING);
        } catch (Exception e) {
            log.error("got exception for {}", "GROUP_BY_HAVING");
        }
    }

    public static void evaluateCreateIndexInCreateTable() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("CREATE_INDEX_IN_CREATE_TABLE", SQLConstant.CREATE_INDEX_IN_CREATE_TABLE);
        } catch (Exception e) {
            log.error("got exception for {}", "CREATE_INDEX_IN_CREATE_TABLE");
        }
    }

    public static void evaluateCreateIndexForExistingTable() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("CREATE_INDEX_FOR_EXISTING_TABLE", SQLConstant.CREATE_INDEX_FOR_EXISTING_TABLE);
    }

    public static void evaluateAggregateFunctionQueries() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("AGGREGATE_FUNCTION_QUERIES", SQLConstant.AGGREGATE_FUNCTION_QUERIES);
    }

    public static void evaluateAddColumn() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("ADD_COLUMN", SQLConstant.ADD_COLUMN);
        } catch (Exception e) {
            log.error("got exception for {}", "ADD_COLUMN");
        }
    }

    public static void evaluateEditColumn() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("EDIT_COLUMN", SQLConstant.EDIT_COLUMN);
        } catch (Exception e) {
            log.error("got exception for {}", "EDIT_COLUMN");
        }
    }

    public static void evaluateRenameColumn() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("RENAME_COLUMN", SQLConstant.RENAME_COLUMN);
        } catch (Exception e) {
            log.error("got exception for {}", "RENAME_COLUMN");
        }
    }

    public static void evaluateDropColumn() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("DROP_COLUMN", SQLConstant.DROP_COLUMN);
        } catch (Exception e) {
            log.error("got exception for {}", "DROP_COLUMN");
        }
    }

    public static void evaluateCreateTableWithNonDuplicateValue() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("CREATE_TABLE_WITH_NONE_DUPLICATE_VALUE", SQLConstant.CREATE_TABLE_WITH_NONE_DUPLICATE_VALUE);
        } catch (Exception e) {
            log.error("got exception for {}", "CREATE_TABLE_WITH_NONE_DUPLICATE_VALUE");
        }
    }

    public static void evaluateSelectComplexMax() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("SELECT_COMPLEX_MAX", SQLConstant.SELECT_COMPLEX_MAX);
    }

    public static void evaluateSelectComplexExist() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("SELECT_COMPLEX_EXIST", SQLConstant.SELECT_COMPLEX_EXIST);
    }

    public static void evaluateSelectComplexIn() {
        SqlExecutor.executeAndEvaluateSqlByShardingParser5("SELECT_COMPLEX_IN", SQLConstant.SELECT_COMPLEX_IN);
    }

    public static void evaluateSelectComplexSelfJoin() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("SELECT_SELF_JOIN", SQLConstant.SELECT_SELF_JOIN);
        } catch (Exception e) {
            log.error("got exception for {}", "SELECT_SELF_JOIN");
        }
    }

    public static void evaluateSelectComplexInnerJoin() {
        try {
            SqlExecutor.executeAndEvaluateSqlByShardingParser5("SELECT_COMPLEX_INNER_JOIN", SQLConstant.SELECT_COMPLEX_INNER_JOIN);
        } catch (Exception e) {
            log.error("got exception for {}", "SELECT_COMPLEX_INNER_JOIN");
        }
    }
}
