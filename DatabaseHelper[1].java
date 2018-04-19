package com.project.hawkeye.voting_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "info.db";
    public static final String TABLE_NAME = "info_table";
    public static final String COL_1 = "vid";
    public static final String COL_2 = "aid";
    public static final String COL_3 = "name";
    public static final String COL_4 = "dob";
    public static final String COL_5 = "sex";
    public static final String COL_6 = "casted";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table " + TABLE_NAME + " (vid TEXT PRIMARY KEY ,aid TEXT UNIQUE ,name TEXT,dob TEXT , sex TEXT , casted TEXT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String vid, String aid, String name, String dob, String sex, String casted) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, vid);
        contentValues.put(COL_2, aid);
        contentValues.put(COL_3, name);
        contentValues.put(COL_4, dob);
        contentValues.put(COL_5, sex);
        contentValues.put(COL_6, casted);

        long result = db.insert(TABLE_NAME, null, contentValues);
        db.close();
        if (result == -1)
            return false;
        else
            return true;

    }
    public Cursor getAllData(String vtid) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select vid "+TABLE_NAME;
        Cursor res = db.rawQuery(query,null);
        String a;
        if(res.moveToFirst()){
            do{
                a = res.getString(0);
                if(a.equals(vtid)){
                    break;
                }
            }while(res.moveToNext());
        }
        return res;
    }

    public String checkuser(String vid) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "select vid  " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        a = "not found";
        if (cursor.moveToFirst()) {
            do {

                    a = cursor.getString(0);

                    if (a.equals(vid)) {

                            return a;




                    }

            }while (cursor.moveToNext());
        }
        return a;
    }
}





