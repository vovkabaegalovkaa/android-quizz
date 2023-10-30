package com.example.victorina;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

    public class DBAdapter extends SQLiteOpenHelper {
        private static final String MY_TABLE = "MY_TABLE";
        private static final String COLUMN_NAME = "COLUMN_NAME";


        public DBAdapter(@Nullable Context context) {
            super(context, "new.db", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + MY_TABLE + " (" + COLUMN_NAME + " TEXT);");
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        }

        public void addOne(String name){
            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put(COLUMN_NAME, name);
            db.insert(MY_TABLE, null, cv);
            db.close();
        }

        public String getAll(){
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.query(MY_TABLE, null, null, null, null, null, null, null);
            String name = "";
            if(cursor.moveToFirst()){
                do{
                    int id_n = cursor.getColumnIndex(COLUMN_NAME);
                    name = cursor.getString(id_n);
                }while (cursor.moveToNext());
            }
            db.close();
            return name;
        }
    }

