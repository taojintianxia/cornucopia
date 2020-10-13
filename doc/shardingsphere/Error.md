1.Caused by: java.lang.RuntimeException: Failed to load driver class com.mysql.jdbc.Driver in either of HikariConfig class loader or Thread context classloader

忘记将 `mysql-connector-java` 放入 pom 文件中
