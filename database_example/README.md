## Java Database Connectivity (or JDBC for short) is a Java API designed to connect and manage relational databases in applications programmed with Java.

### The JDBC API uses JDBC drivers to interact with a database. There are different types of JDBC drivers:

- JDBC-ODBC bridge driver: Use JDBC-ODBC bridge driver for testing JDBC applications against an ODBC (Open database connectivity) data source.

- Native driver: Native driver requires a native database API.

- Network driver protocol: Network driver protocol is common; it’s created for a particular vendor’s database.


### Using JDBC

##### When using JDBC to connect and manage a database, JDBC works in the following steps:

- Register the JDBC driver class

- Create a connection to the database

- Create a statement object to perform an SQL query

- Execute the statement object and return a query ResultSet

- Process the ResultSet

- Close ResultSet and statement

- Close the connection

#### Advantages of JDBC

- No installation: JDBC comes with every JDK, and you don’t need any additional libraries installed to use it.

- Database Agnostic: JDBC can read any database as long as the connection is with the proper drivers.

- Connection pooling: JDBC connection pooling saves time when opening and closing database connections for every user.

- Easy database access: JDBC low-level database access makes complex SQL queries efficient.

#### Limitations of JDBC

- With JDBC, each type of database requires a specific driver.

- To prevent SQL injection attacks, JDBC does not allow more than one value to a placeholder.

- The significant programming overhead makes use of JDBC in large-scale projects hard.

- Java Developers using JDBC must know how to write good SQL queries.

#### Conclusion

- In this shot, we defined Java Database Connectivity, its architecture, and how to use it. We also learned its advantages and limitations.


##### Source: [how.dev/answers/what-is-java-database-connectivity](https://how.dev/answers/what-is-java-database-connectivity)
