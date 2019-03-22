package com.example.iiitcontacts.localdb;

import android.content.Context;

import com.example.iiitcontacts.network.OkHttp;
import com.example.iiitcontacts.util.Constants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import timber.log.Timber;

public class FetchContactsWorker extends Worker {
    public FetchContactsWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        OkHttpClient client = OkHttp.getInstance();

        Request request = new Request.Builder()
                .url(Constants.API_URL)
                .build();

        try {
            Response response = client.newCall(request).execute();

            String responseString = response.body().string();

            Timber.d("Response data: %s", responseString);

            ArrayList<Contact> contactList = new Gson().fromJson(responseString,
                    new TypeToken<List<Contact>>() {
                    }.getType());
            Timber.d("Contactlist: %s", contactList);
            MyRoomDatabase database = MyRoomDatabase.getDatabase(getApplicationContext());
            database.contactDao().deleteAll();
            database.contactDao().insertAll(contactList);
            return Result.success();

        } catch (IOException e) {
            Timber.e(e);

            e.printStackTrace();
            return Result.failure();
        }
    }
}