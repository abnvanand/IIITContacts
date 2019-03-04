package com.example.iiitcontacts;

import android.content.Intent;
import android.os.Bundle;

import com.example.iiitcontacts.databinding.ActivityContactDetailsBinding;
import com.example.iiitcontacts.pojo.Contact;
import com.example.iiitcontacts.util.Constants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

public class ContactDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_details);
        ActivityContactDetailsBinding binding = DataBindingUtil
                .setContentView(this, R.layout.activity_contact_details);

        Intent intent = getIntent();
        Contact contact = (Contact) intent.getSerializableExtra(Constants.EXTRA_CONTACT);

        binding.setContact(contact);
    }
}
