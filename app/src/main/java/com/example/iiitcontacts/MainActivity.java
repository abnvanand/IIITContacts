package com.example.iiitcontacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;

import com.example.iiitcontacts.adapters.ContactsAdapter;
import com.example.iiitcontacts.databinding.ActivityMainBinding;
import com.example.iiitcontacts.databinding.ItemContactBinding;
import com.example.iiitcontacts.localdb.Contact;
import com.example.iiitcontacts.util.Constants;
import com.example.iiitcontacts.viewmodels.ContactViewModel;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

public class MainActivity extends AppCompatActivity
        implements ContactsAdapter.OnItemClickListener, SearchView.OnQueryTextListener {

    ContactViewModel mContactViewModel;
    ContactsAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        setupRecyclerView(binding);

        ArrayList<Contact> contactList = new ArrayList<>();

        mAdapter = new ContactsAdapter(contactList);
        mAdapter.setItemClickListener(this);

        binding.recyclerView.setAdapter(mAdapter);

        mContactViewModel = ViewModelProviders.of(this).get(ContactViewModel.class);
        // Update the cached copy of the contacts in the adapter.
        mContactViewModel.getAllContacts().observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> newData) {
                mAdapter.setData(newData);
            }
        });
    }

    private void setupRecyclerView(ActivityMainBinding binding) {
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                LinearLayoutManager.VERTICAL);
        binding.recyclerView.addItemDecoration(dividerItemDecoration);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public void onItemClick(@NonNull ItemContactBinding binding) {
        View view = binding.getRoot();
        Contact contact = binding.getContact();

        Intent intent = new Intent(view.getContext(), ContactDetailsActivity.class);
        intent.putExtra(Constants.EXTRA_CONTACT, contact);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        mContactViewModel.getContactsByName(newText).observe(this, new Observer<List<Contact>>() {
            @Override
            public void onChanged(List<Contact> newData) {
                mAdapter.setData(newData);
            }
        });
        return true;
    }
}
