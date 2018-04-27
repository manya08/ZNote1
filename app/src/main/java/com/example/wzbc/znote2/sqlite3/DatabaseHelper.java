package com.example.wzbc.znote2.sqlite3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by WZBC on 2018/4/16.
 */

public class DatabaseHelper extends SQLiteOpenHelper{
    private static final String TAG="hlc";
    private static DatabaseHelper mDatabaseHelper;

    private DatabaseHelper(Context context){
        super(context,D.DATABASENAME,null,D.DATABASE_VERSION);
        Log.d(TAG,"DB Version="+D.DATABASE_VERSION);
    }
    static DatabaseHelper getDatabaseHelper(Context context){
        if (mDatabaseHelper == null){
            mDatabaseHelper = new DatabaseHelper(context);
        }
        return  mDatabaseHelper;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        createTableNotes(db);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade=" + newVersion);
        dropTableNotes(db);
        createTableNotes(db);
        Log.d(TAG, "onUpgrade success");
    }
    public void createTableNotes(SQLiteDatabase db){
        String createTableNotes="create table "+D.Tables.NOTES+"("
                +D.Notes.KEY_ROWID+" INTEGER PRIMARY KEY,"
                +D.Notes.FIELD_NOTEBOOK_ID+" INTEGER,"
                +D.Notes.FIELD_NOTE+" TEXT,"
                +D.Notes.FIELD_NOTEDETAIL +" TEXT,"
                +D.Notes.FIELD_CREATED+" TIMESTAMP"+");";
        db.execSQL(createTableNotes);
        Log.d(TAG," CreateDB SUCSSED, SQL=" + createTableNotes);
    }
    public void dropTableNotes(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + D.Notes.FIELD_NOTEBOOK_ID);
    }


}
