package com.example.a.a11_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by a on 2017-02-08.
 */

public class TestSQLiteHandler {
    TestSQLiteOpenHelper helper;

    public TestSQLiteHandler(Context context){
        helper = new TestSQLiteOpenHelper(context, "people", null, 1);
    }

    public void insert(String name, int age, String address){
        SQLiteDatabase db = helper.getWritableDatabase();

    }
}
