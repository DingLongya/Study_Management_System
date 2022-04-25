package com.e.library_management_system;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DateBaseHelper extends SQLiteOpenHelper {

    private static final String CREAT_Study = "create table study_list("
            + "id integer primary key autoincrement,"
            + "acount text,"
            + "password text,"
            + "qq text)";
    private Context mycontext;
    public DateBaseHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        mycontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREAT_Study);
        Log.d("TEST: ", "create successed");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}