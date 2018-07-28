# JDBC
Multiple programs used to test out and practice with javas JDBC API


RecordTester.java
RecordTester is a simple beginners program to get familiar with javas JDBC API. Takes in arguments from the console to connect to a database and then create a table and insert values into the table. The number of rows and columns are passed into the program through the console.

Arg[0] is the dbms
Arg[1] is the name of the database file
Arg[2] is the name of the table to create
Arg[3] is the data type 
Arg[4] is the number of rows
Arg[5] is the number of columns


IsolationTest.java
IsolationTest is a program to test out the various levels of isolation that MySQL can implement. Tests the isolation levels READ COMMITTED and SERIALIZABLE. Test is performed by setting the isolation levels then executing a sequence of interleaving operations and then printing the results of the operation on the data base. Showing what happened during the different levels of isolation.


