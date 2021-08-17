package com.github.taojintianxia.cornucopia.parserbenchmark.constant;

public interface SQLConstant {

    String SIMPLE_SELECT = "select c from emp;";

    String CREATE_TABLE = "CREATE TABLE  'emp' (\n" +
                                              "  'id' INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,\n" +
                                              "  'name' VARCHAR(45) NOT NULL,\n" +
                                              "  'lastname' VARCHAR(45),\n" +
                                              "  'dept' VARCHAR(45) DEFAULT 'sales',\n" +
                                              "  PRIMARY KEY ('id')\n" +
                                              ")\n" +
                                              "ENGINE = InnoDB;";

    String SIMPLE_INSERT = "insert into emp (name,lastname,dept) values('new name','new last name','Accounts');";

    String INSERT_AND_UPDATE = "insert into emp (id,name,lastname,dept) values('key that already exists', 'new name','new last name','Accounts') \n" +
                               "on duplicate KEY UPDATE  name='default name', lastname='default last name';";

    String REGULAR_JOIN = "select emp.name,department.name from emp join department on emp.dept = department.name;";

    String LEFT_JOIN = "select emp.name,department.name from emp left join department on emp.dept = department.name;";

    String RIGHT_JOIN = "select emp.name,department.name from emp right join department on emp.dept = department.name;";

    String ADD_PRIMARY_KEY = "ALTER TABLE 'TABLE_NAME'  DROP PRIMARY KEY, ADD PRIMARY KEY ('COLUMN_NAME');";

    String DROP_PRIMARY_KEY = "ALTER TABLE 'TABLE_NAME'  DROP PRIMARY KEY;";

    String GROUP_BY_HAVING = "Select * from TABLE_NAME group_by dept  having salary > 10000;";

    String CREATE_INDEX_IN_CREATE_TABLE = "CREATE TABLE  'emp' (\n" +
                                          "Name varchar(45),\n" +
                                          "  'id' INT, INDEX(ID)\n" +
                                          ");";

    String CREATE_INDEX_FOR_EXISTING_TABLE = "Create Index id_index on emp(ID);";

    String AGGREGATE_FUNCTION_QUERIES = "select distinct name,count(dept) as cnt from emp group by dept  order by cnt DESC;";

    String ADD_COLUMN = "Alter table 'emp' add column salary varchar(45);";

    String EDIT_COLUMN = "Alter table 'emp' modify column salary int(10);";

    String RENAME_COLUMN = "Alter table 'emp' change salary salary2 varchar(45);";

    String DROP_COLUMN = "Alter table 'emp' drop column salary;";

    String CREATE_TABLE_WITH_NONE_DUPLICATE_VALUE = "create table 'emp2' as select * from emp where 1 group by 'lastname';";

    String SELECT_COMPLEX_MAX = "SELECT F.*\n" +
                                "FROM FIRES F,\n" +
                                "(SELECT MAX(ESTLOSS) MAXLOSS\n" +
                                "FROM FIRES) M\n" +
                                "WHERE F.ESTLOSS = M.MAXLOSS;";

    String SELECT_COMPLEX_EXIST = "SELECT *\n" +
                                  "FROM PARCELS P\n" +
                                  "WHERE NOT EXISTS\n" +
                                  "(SELECT NULL\n" +
                                  "FROM FIRES F\n" +
                                  "WHERE P.PARCELID = F.PARCELID);";

    String SELECT_COMPLEX_IN = "SELECT *\n" +
                               "FROM PARCELS\n" +
                               "WHERE (PID, WPB) NOT IN\n" +
                               "(SELECT PID, WPB\n" +
                               "FROM PERMITS);";

    String SELECT_SELF_JOIN = "SELECT M1.PAPER\n" +
                              "FROM MATCH M1, MATCH M2\n" +
                              "WHERE M1.PAPER = M2.PAPER\n" +
                              "AND M1.CODE = 601\n" +
                              "AND M2.CODE = 602;";
}

