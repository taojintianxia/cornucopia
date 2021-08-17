package com.github.taojintianxia.cornucopia.parserbenchmark.constant;

public interface SQLConstant {

    String SIMPLE_SELECT = "select c from emp;";

    String CREATE_TABLE = "CREATE TABLE  'emp' ( " +
                                              "  'id' INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, " +
                                              "  'name' VARCHAR(45) NOT NULL, " +
                                              "  'lastname' VARCHAR(45), " +
                                              "  'dept' VARCHAR(45) DEFAULT 'sales', " +
                                              "  PRIMARY KEY ('id') " +
                                              ") " +
                                              "ENGINE = InnoDB;";

    String SIMPLE_INSERT = "insert into emp (name,lastname,dept) values('new name','new last name','Accounts');";

    String INSERT_AND_UPDATE = "insert into emp (id,name,lastname,dept) values('key that already exists', 'new name','new last name','Accounts')  " +
                               "on duplicate KEY UPDATE  name='default name', lastname='default last name';";

    String REGULAR_JOIN = "select emp.name,department.name from emp join department on emp.dept = department.name;";

    String LEFT_JOIN = "select emp.name,department.name from emp left join department on emp.dept = department.name;";

    String RIGHT_JOIN = "select emp.name,department.name from emp right join department on emp.dept = department.name;";

    String ADD_PRIMARY_KEY = "ALTER TABLE 'TABLE_NAME'  DROP PRIMARY KEY, ADD PRIMARY KEY ('COLUMN_NAME');";

    String DROP_PRIMARY_KEY = "ALTER TABLE 'TABLE_NAME'  DROP PRIMARY KEY;";

    String GROUP_BY_HAVING = "Select * from TABLE_NAME group_by dept  having salary > 10000;";

    String CREATE_INDEX_IN_CREATE_TABLE = "CREATE TABLE  'emp' ( " +
                                          "Name varchar(45), " +
                                          "  'id' INT, INDEX(ID) " +
                                          ");";

    String CREATE_INDEX_FOR_EXISTING_TABLE = "Create Index id_index on emp(ID);";

    String AGGREGATE_FUNCTION_QUERIES = "select distinct name,count(dept) as cnt from emp group by dept  order by cnt DESC;";

    String ADD_COLUMN = "Alter table 'emp' add column salary varchar(45);";

    String EDIT_COLUMN = "Alter table 'emp' modify column salary int(10);";

    String RENAME_COLUMN = "Alter table 'emp' change salary salary2 varchar(45);";

    String DROP_COLUMN = "Alter table 'emp' drop column salary;";

    String CREATE_TABLE_WITH_NONE_DUPLICATE_VALUE = "create table 'emp2' as select * from emp where 1 group by 'lastname';";

    String SELECT_COMPLEX_MAX = "SELECT F.* " +
                                "FROM FIRES F, " +
                                "(SELECT MAX(ESTLOSS) MAXLOSS " +
                                "FROM FIRES) M " +
                                "WHERE F.ESTLOSS = M.MAXLOSS;";

    String SELECT_COMPLEX_EXIST = "SELECT * " +
                                  "FROM PARCELS P " +
                                  "WHERE NOT EXISTS " +
                                  "(SELECT NULL " +
                                  "FROM FIRES F " +
                                  "WHERE P.PARCELID = F.PARCELID);";

    String SELECT_COMPLEX_IN = "SELECT * " +
                               "FROM PARCELS " +
                               "WHERE (PID, WPB) NOT IN " +
                               "(SELECT PID, WPB " +
                               "FROM PERMITS);";

    String SELECT_SELF_JOIN = "SELECT M1.PAPER " +
                              "FROM MATCH M1, MATCH M2 " +
                              "WHERE M1.PAPER = M2.PAPER " +
                              "AND M1.CODE = 601 " +
                              "AND M2.CODE = 602;";

    String SELECT_COMPLEX_INNER_JOIN = "SELECT contact.*, order.*  " +
                                       "FROM contact  " +
                                       "INNER JOIN order  " +
                                       "ON contact.Id = order.ContactId  " +
                                       "INNER JOIN (SELECT DISTINCT ContactId   " +
                                       "            FROM order   " +
                                       "            WHERE (ItemBought = 'Adult Membership' AND ItemValidDate = '2009/10')   " +
                                       "            OR (ItemBought = 'Adult Membership' AND ItemValidDate = '2010/11')) Sub1  " +
                                       "ON contact.Id = Sub1.ContactId  " +
                                       "INNER JOIN (SELECT DISTINCT ContactId  " +
                                       "            FROM order   " +
                                       "            WHERE (ItemBought = 'Adult Membership' AND ItemValidDate = '2012/13')) Sub2  " +
                                       "ON contact.Id = Sub2.ContactId";
}

