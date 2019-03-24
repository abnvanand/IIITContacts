package com.example.iiitcontacts;

import android.app.Application;

import com.example.iiitcontacts.localdb.Contact;
import com.example.iiitcontacts.localdb.ContactDao;
import com.example.iiitcontacts.localdb.FetchContactsWorker;
import com.example.iiitcontacts.localdb.MyRoomDatabase;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

public class ContactRepository {
    private ContactDao mContactDao;

    public ContactRepository(Application application) {
        // Get database
        MyRoomDatabase db = MyRoomDatabase.getDatabase(application);
        mContactDao = db.contactDao();


        // background worker to fetch contacts from the network
        OneTimeWorkRequest fetchdata = new OneTimeWorkRequest.Builder(FetchContactsWorker.class)
                .build();
        WorkManager mWorkManager = WorkManager.getInstance();
        mWorkManager.enqueue(fetchdata);
    }


    public LiveData<List<Contact>> getAllContacts() {
        LiveData<List<Contact>> mAllContacts;
        mAllContacts = mContactDao.getAll();

        return mAllContacts;
    }

    public LiveData<List<Contact>> getContactsByName(String name) {
        // Add % to front and back so that the query becomes something like
        // SELECT * FROM tablename WHERE fieldname LIKE %name%
        // We are doing this here bcoz Room does not support adding %% in the query part of DAO.
        String query = String.format("%s%s%s", "%", name, "%");
        LiveData<List<Contact>> mFilteredContacts;
        mFilteredContacts = mContactDao.findByName(query);

        return mFilteredContacts;
    }
}
