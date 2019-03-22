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
    private LiveData<List<Contact>> mAllContacts;

    public ContactRepository(Application application) {
        MyRoomDatabase db = MyRoomDatabase.getDatabase(application);
        ContactDao mContactDao = db.contactDao();
        mAllContacts = mContactDao.getAll();


        // background worker to fetch contacts from the network
        OneTimeWorkRequest fetchdata = new OneTimeWorkRequest.Builder(FetchContactsWorker.class)
                .build();
        WorkManager mWorkManager = WorkManager.getInstance();
        mWorkManager.enqueue(fetchdata);
    }


    public LiveData<List<Contact>> getAllContacts() {
        return mAllContacts;
    }
}
