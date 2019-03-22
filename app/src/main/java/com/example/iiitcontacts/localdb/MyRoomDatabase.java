package com.example.iiitcontacts.localdb;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import static com.example.iiitcontacts.util.Constants.DATABASE_NAME;

@Database(entities = {Contact.class}, version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();

    private static volatile MyRoomDatabase INSTANCE;

    public static MyRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MyRoomDatabase.class, DATABASE_NAME)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
