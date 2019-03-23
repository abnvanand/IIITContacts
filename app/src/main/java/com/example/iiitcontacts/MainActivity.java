package com.example.iiitcontacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.iiitcontacts.adapters.ContactsAdapter;
import com.example.iiitcontacts.databinding.ActivityMainBinding;
import com.example.iiitcontacts.databinding.ItemContactBinding;
import com.example.iiitcontacts.localdb.Contact;
import com.example.iiitcontacts.util.Constants;
import com.example.iiitcontacts.viewmodels.ContactViewModel;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity
        implements ContactsAdapter.OnItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        binding.recyclerView.addItemDecoration(dividerItemDecoration);

        ArrayList<Contact> contactList = new ArrayList<>();

        ContactsAdapter mAdapter = new ContactsAdapter(contactList);
        mAdapter.setItemClickListener(this);
        binding.recyclerView.setAdapter(mAdapter);

        ContactViewModel mContactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        // Update the cached copy of the contacts in the adapter.
        mContactViewModel.getAllContacts().observe(this, mAdapter::setData);
    }

    @Override
    public void onItemClick(@NonNull ItemContactBinding binding) {
        View view = binding.getRoot();
        Contact contact = binding.getContact();

        Intent intent = new Intent(view.getContext(), ContactDetailsActivity.class);
        intent.putExtra(Constants.EXTRA_CONTACT, contact);
        startActivity(intent);
    }
}
