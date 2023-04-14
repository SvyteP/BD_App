package com.example.bd_app.db;

public class MyDataBase {
    public static final String table_name = "my_table";
    public static final String _id = "_id";
    public static final String title = "title";
    public static final String comment = "comment";
    public static final String db_name = "myDb.db";
    public static final int db_version = 1;
    public static final String table_structure = "CREATE TABLE IF NOT EXISTS"+
            table_name + "( " + _id + "INTEGER PRIMARY KEY," + title +"TEXT," +
            comment + "TEXT)";
    public static final String drop_table = "DROP TABLE IF EXISTS" + table_name;
}
