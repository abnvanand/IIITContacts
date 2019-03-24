package com.example.iiitcontacts.viewmodels;

import android.app.Application;

import com.example.iiitcontacts.ContactRepository;
import com.example.iiitcontacts.localdb.Contact;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import timber.log.Timber;

public class ContactViewModel extends AndroidViewModel {

    private LiveData<List<Contact>> mAllContacts;
    private ContactRepository mRepository;

    public ContactViewModel(Application application) {
        super(application);
        mRepository = new ContactRepository(application);
        mAllContacts = mRepository.getAllContacts();
    }

    public LiveData<List<Contact>> getAllContacts() {
        return mAllContacts;
    }

    public LiveData<List<Contact>> getContactsByName(String name) {
        Timber.d("name: %s", name);
        mAllContacts = mRepository.getContactsByName(name);
        return mAllContacts;
    }
}