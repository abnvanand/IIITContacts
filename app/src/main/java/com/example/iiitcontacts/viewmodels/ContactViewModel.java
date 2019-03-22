package com.example.iiitcontacts.viewmodels;

import android.app.Application;

import com.example.iiitcontacts.ContactRepository;
import com.example.iiitcontacts.localdb.Contact;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ContactViewModel extends AndroidViewModel {

    private LiveData<List<Contact>> mAllContacts;

    public ContactViewModel(Application application) {
        super(application);
        ContactRepository mRepository = new ContactRepository(application);
        mAllContacts = mRepository.getAllContacts();
    }

    public LiveData<List<Contact>> getAllContacts() {
        return mAllContacts;
    }
}