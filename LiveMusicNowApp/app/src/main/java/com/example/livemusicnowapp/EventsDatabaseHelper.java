package com.example.livemusicnowapp;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;
import android.util.Log;

public class EventsDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "livemusicnow.db";
    private static final int DATABASE_VERSION = 5;

    /*Database creation SQL statement*/
    private static final String CREATE_TABLE_EVENTS =
            "create table event (_id integer primary key autoincrement, "
                    + "band text not null, "
                    + "bandLink text not null, "
                    + "genre text not null, "
                    + "description text not null, "
                    + "date text not null, "
                    + "time text not null, "
                    + "venue text not null, "
                    + "address text not null, "
                    + "city text not null, "
                    + "state text not null, "
                    + "zipcode text not null, "
                    + "venueLink text not null, "
                    + "ticketPrice text not null, "
                    + "ticketLink text not null, "
                    + "logoLink text not null);";
    public EventsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_EVENTS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.w(EventsDatabaseHelper.class.getName(),
                "Upgrading database from version " + i + " to " + i1 + " which will destroy all old data");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS events");
        onCreate(sqLiteDatabase);
    }
}
