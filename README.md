# Java JDBC API basis.

![Java JDBC API](https://img.shields.io/badge/JAVA%20SE%2011-JDBC%20API%20|%20Logger%20|%20ResourceBundle%20|%20Javadoc-indianred?style=flat&logo=java)
![MySQL RDBMS](https://img.shields.io/badge/MySQL-%20DQL%20|%20DDL%20|%20DML%20-steelblue?style=flat&logo=mysql&logoColor=white)

## ( *jdbc-api-statement-executor* ) ![v0.2](https://img.shields.io/badge/version-0.2.x-green?style=flat&logo=GitHub&logoColor=white)
> Exploring `java.sql.DriverManager` , `java.sql.Connection`  , `java.sql.Statement` , `java.sql.ResultSet` features.

*fevvelasquez* writes the [StatementExecutor](/src/me/fevvelasquez/jdbc/api/statement/StatementExecutor.java) own class as a factory of database connected, **ready to use**, automated Statement instances.
So, you can **execute any valid SQL** statement directly and see the results into a [StatementResult](/src/me/fevvelasquez/jdbc/api/statement/StatementResult.java) instance. 

[Demo](/src/me/fevvelasquez/jdbc/api/app/Demo.java) class with examples is available.


Even if *MySql* is used for the demo, a distinct *RDBMS* or distinct database can be configured in [db.properties](/src/me/fevvelasquez/jdbc/api/app/db.properties).

### Recreating the, MySQL, demo database.
If needed, you can recreate the demo database using this [MySQL script](/mysql-scripts/store.sql).

## Quick Preview.
> *UPDATE* statement is executed, then *SELECT* shows the resultset without the need of providing table's description for printing. 

Some code from [Demo](/src/me/fevvelasquez/jdbc/api/app/Demo.java) goes as follows:

```java

// Execute UPDATE example:
se.executeStatement("UPDATE products SET name = 'updated at " + LocalTime.now() + "' WHERE product_id = 7");
// ------------------------------------------------------------------------------------

// Execute SELECT example:
StatementResult select = se.executeStatement("SELECT * FROM products WHERE product_id <= 7");
// ------------------------------------------------------------------------------------

```

Code above produces next result:

![](/.gitimages/demo.png)

