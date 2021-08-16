package com.example.jobservice;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Switch;

import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;


public class JobService extends JobIntentService {


   public static void enqueueWork(Context context,Intent intent){
       enqueueWork(context,JobService.class,123,intent);
   }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("praveen", "onCreate");
    }

    @Override
    protected void onHandleWork(@NonNull  Intent intent) {
        int id=intent.getIntExtra("jobId",0);
        switch (id){
            case 1:
                for (int i=0;i<10;i++){
                    Log.d("praveen", "id"+id+"  i="+i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                for (int i=0;i<12;i++){
                    Log.d("praveen", "id"+id+"  i="+i);
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("praveen", "onDestroy");
    }
}
