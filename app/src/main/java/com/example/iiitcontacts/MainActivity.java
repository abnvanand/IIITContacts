package com.example.iiitcontacts;

import android.os.Bundle;
import android.widget.TextView;

import com.example.iiitcontacts.network.OkHttp;
import com.example.iiitcontacts.pojo.Contact;
import com.example.iiitcontacts.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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

                ArrayList<Contact> contactList;
                contactList = new Gson().fromJson(responseString,
                        new TypeToken<List<Contact>>() {
                        }.getType());
                Timber.d("Contactlist: %s", contactList);
                TextView tv = findViewById(R.id.textView);
                tv.setText(contactList.get(0).getName());
            }
        });
    }
}
