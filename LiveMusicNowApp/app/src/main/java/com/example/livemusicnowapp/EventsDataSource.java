package com.example.livemusicnowapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class EventsDataSource {
    private SQLiteDatabase database;
    private EventsDatabaseHelper dbHelper;

    public EventsDataSource(Context context) {
        dbHelper = new EventsDatabaseHelper(context);
    }
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
        dbHelper.onCreate(database); //added to fix table not existing error - creates table already exists error now
    }
    public void close(){
        dbHelper.close();
    }
    public boolean insertEvent(Event event) {
        boolean didSucceed = false;
        try {
            ContentValues initialValues = new ContentValues();
            initialValues.put("band", event.getBandName());
            initialValues.put("bandLink", event.getBandLink());
            initialValues.put("genre", event.getGenre());
            initialValues.put("description", event.getDescription());
            initialValues.put("date", event.getDate());
            initialValues.put("time", event.getTime());
            initialValues.put("venue", event.getVenue());
            initialValues.put("address", event.getAddress());
            initialValues.put("city", event.getCity());
            initialValues.put("state", event.getState());
            initialValues.put("zipcode", event.getZipCode());
            initialValues.put("venueLink", event.getVenueLink());
            initialValues.put("ticketPrice", event.getTicketPrice());
            initialValues.put("ticketLink", event.getTicketLink());
            initialValues.put("logoLink", event.getLogoLink());

            didSucceed = database.insert("event", null, initialValues) > 0;
        } catch (Exception e) {
            //Do nothing - will return false if there is no exception
        }
        return didSucceed;
    }

    public boolean updateEvent(Event event) {
        boolean didSucceed = false;
        try {
            Long rowId = (long) event.getEventID();

            ContentValues updateValues = new ContentValues();
            updateValues.put("band", event.getBandName());
            updateValues.put("bandLink", event.getBandLink());
            updateValues.put("genre", event.getGenre());
            updateValues.put("description", event.getDescription());
            updateValues.put("date", event.getDate());
            updateValues.put("time", event.getTime());
            updateValues.put("venue", event.getVenue());
            updateValues.put("address", event.getAddress());
            updateValues.put("city", event.getCity());
            updateValues.put("state", event.getState());
            updateValues.put("zipcode", event.getZipCode());
            updateValues.put("venueLink", event.getVenueLink());
            updateValues.put("ticketPrice", event.getTicketPrice());
            updateValues.put("ticketLink", event.getTicketLink());
            updateValues.put("logoLink", event.getLogoLink());

            didSucceed = database.update("event", updateValues, "_id=" + rowId, null) > 0;


        } catch (Exception e) {

        }
        return didSucceed;
    }
    public int getLastEventID(){
        int lastId;
        try {
            String query = "select MAX(_id) from event";
            Cursor cursor = database.rawQuery(query, null);
            cursor.moveToFirst();
            lastId = cursor.getInt(0);
            cursor.close();
        } catch (Exception e) {
            lastId = -1;
        }
        return lastId;
    }
    public ArrayList<String> getEventBand() {
        ArrayList<String> eventBand = new ArrayList<>();
        try {
            String query = "Select band from event";
            Cursor cursor = database.rawQuery(query, null);

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                eventBand.add(cursor.getString(0));
                cursor.moveToNext();
            }
            cursor.close();
        } catch (Exception e) {
            eventBand = new ArrayList<String>();
        }
        return eventBand;
    }
    public ArrayList<Event> getEvents(){
        ArrayList<Event> events = new ArrayList<Event>();
        try {
            String query = "Select * from event";
            Cursor cursor = database.rawQuery(query, null);
            Event newEvent;
            cursor.moveToFirst();
            while (!cursor.isAfterLast()){
                newEvent = new Event();
                newEvent.setEventID(cursor.getInt(0));
                newEvent.setBandName(cursor.getString(1));
                newEvent.setBandLink(cursor.getString(2));
                newEvent.setGenre(cursor.getString(3));
                newEvent.setDescription(cursor.getString(4));
                newEvent.setDate(cursor.getString(5));
                newEvent.setTime(cursor.getString(6));
                newEvent.setVenue(cursor.getString(7));
                newEvent.setAddress(cursor.getString(8));
                newEvent.setCity(cursor.getString(9));
                newEvent.setState(cursor.getString(10));
                newEvent.setZipCode(cursor.getString(11));
                newEvent.setVenueLink(cursor.getString(12));
                newEvent.setTicketPrice(cursor.getString(13));
                newEvent.setTicketLink(cursor.getString(14));
                newEvent.setLogoLink(cursor.getString(15));
                events.add(newEvent);
                cursor.moveToNext();
            }
            cursor.close();
        } catch (Exception e) {
            events = new ArrayList<Event>();
        }
        return events;
    }
    public Event getSpecificEvent(int eventId) {
        Event event = new Event();
        String query = "SELECT * FROM event WHERE _id =" + eventId;
        Cursor cursor = database.rawQuery(query, null);
        if (cursor.moveToFirst()) {
            event.setEventID(cursor.getInt(0));
            event.setBandName(cursor.getString(1));
            event.setBandLink(cursor.getString(2));
            event.setGenre(cursor.getString(3));
            event.setDescription(cursor.getString(4));
            event.setDate(cursor.getString(5));
            event.setTime(cursor.getString(6));
            event.setVenue(cursor.getString(7));
            event.setAddress(cursor.getString(8));
            event.setCity(cursor.getString(9));
            event.setState(cursor.getString(10));
            event.setZipCode(cursor.getString(11));
            event.setVenueLink(cursor.getString(12));
            event.setTicketPrice(cursor.getString(13));
            event.setTicketLink(cursor.getString(14));
            event.setLogoLink(cursor.getString(15));
            cursor.close();
        }
        return event;
    }
    public boolean deleteEvent(int eventId){
        boolean didDelete = false;
        try {
            didDelete = database.delete("event", "_id=" + eventId, null) > 0;
        } catch (Exception e) {
            //
        }
        return didDelete;
    }
}
