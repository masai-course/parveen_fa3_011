package com.example.myapplication;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class apiService extends IntentService {

    private int input;


    public apiService(String name) {
        super(name);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        showNotificationAndStartForeGround();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        input = intent.getIntExtra("input", 0);
        callApi();
    }
    private void callApi() {
        ApiiService apiService = Network.getInstance().create(ApiiService.class);
        apiService.fetchData(input).enqueue(new Callback<ResponseModel>() {
            @Override
            public void onResponse(Call<ResponseModel> call, Response<ResponseModel> response) {
                if (response.body() != null) {
                    ResponseModel responseModel = response.body();
                    Intent intent = new Intent("com.example.api_calling_using_service");
                    intent.putExtra("Title", responseModel.getTitle());
                    sendBroadcast(intent);
                }
            }

            @Override
            public void onFailure(Call<ResponseModel> call, Throwable t) {

            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    private void showNotificationAndStartForeGround() {
        createChannel();

        NotificationCompat.Builder notificationBuilder = null;
        notificationBuilder = new NotificationCompat.Builder(this, "CHANNEL_ID")
                .setContentTitle("Music is playing in the background")
                .setPriority(NotificationCompat.PRIORITY_HIGH);
        Notification notification = null;
        notification = notificationBuilder.build();
        startForeground(1, notification);
    }



    /*
    Create noticiation channel if OS version is greater than or eqaul to Oreo
    */
    public void createChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Call Notifications");
            Objects.requireNonNull(this.getSystemService(NotificationManager.class)).createNotificationChannel(channel);
        }
    }
}
