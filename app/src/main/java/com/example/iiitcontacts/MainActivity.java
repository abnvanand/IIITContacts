package com.example.iiitcontacts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.iiitcontacts.adapters.ContactsAdapter;
import com.example.iiitcontacts.databinding.ActivityMainBinding;
import com.example.iiitcontacts.databinding.ItemContactBinding;
import com.example.iiitcontacts.network.OkHttp;
import com.example.iiitcontacts.pojo.Contact;
import com.example.iiitcontacts.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity
        implements ContactsAdapter.OnItemClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<Contact> contactList = new ArrayList<>();

        ContactsAdapter mAdapter = new ContactsAdapter(contactList);
        mAdapter.setItemClickListener(this);
        binding.recyclerView.setAdapter(mAdapter);

        OkHttpClient client = OkHttp.getInstance();

        Request request = new Request.Builder()
                .url(Constants.API_URL)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                Timber.e(e);
            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                String responseString = response.body().string();

                Timber.d("Response data: %s", responseString);

                ArrayList<Contact> contactList = new Gson().fromJson(responseString,
                        new TypeToken<List<Contact>>() {
                        }.getType());
                Timber.d("Contactlist: %s", contactList);

                mAdapter.setData(contactList);
                runOnUiThread(mAdapter::notifyDataSetChanged);
            }
        });
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
