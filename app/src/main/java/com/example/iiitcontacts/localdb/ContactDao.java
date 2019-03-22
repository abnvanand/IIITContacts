package com.example.iiitcontacts.localdb;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contact_table")
    LiveData<List<Contact>> getAll();

    @Query("SELECT * FROM contact_table WHERE name LIKE :name")
    LiveData<List<Contact>> findByName(String name);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Contact> contacts);

    @Query("DELETE FROM contact_table")
    void deleteAll();
}