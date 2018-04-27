package com.example.wzbc.znote2.sqlite3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.Date;


/**
 * Created by WZBC on 2018/4/16.
 */

public class NotesDao {
    private DatabaseHelper mOpenHelper;
    private SQLiteDatabase mydb;
    private static final String TAG="hlc";

    public NotesDao(Context context){
        mOpenHelper =DatabaseHelper.getDatabaseHelper(context);
    }
    public void open(){
        try{
            mydb =mOpenHelper.getWritableDatabase();

        }catch (SQLException e){
            Log.e("Database","SQL exception");
            e.printStackTrace();
        }
    }
    public  void close(){
        mOpenHelper.close();
    }

    public long insertNote(String noteName,String noteDetail){
        Date dateNow =new Date();
        ContentValues args =new ContentValues();
        args.put(D.Notes.FIELD_NOTE, noteName);
        args.put(D.Notes.FIELD_NOTEDETAIL, noteDetail);
        args.put(D.Notes.FIELD_CREATED, dateNow.getTime());
        return mydb.insert(D.Tables.NOTES,null,args);
    }
    public Cursor getNotes(){
        return mydb.query(D.Tables.NOTES,new String[] {D.Notes.KEY_ROWID,
                D.Notes.FIELD_NOTE,
                D.Notes.FIELD_NOTEDETAIL,
                D.Notes.FIELD_CREATED},null,null,null,null,null);
    }
    public Cursor get(long rowID){
        Cursor mcursor =mydb.query(D.Tables.NOTES,new String[]{D.Notes.KEY_ROWID,
                D.Notes.FIELD_NOTE,
                D.Notes.FIELD_CREATED,
                D.Notes.FIELD_NOTEDETAIL},
                D.Notes.KEY_ROWID+"="+
                rowID,null,null,null,null);
        if(mcursor !=null){
            mcursor.moveToFirst();
        }
        return mcursor;
    }
}
