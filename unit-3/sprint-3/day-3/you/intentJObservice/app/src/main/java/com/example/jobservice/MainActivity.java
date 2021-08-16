package com.example.jobservice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mbtnclick1;
    private Button mbtnclick2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mbtnclick1=findViewById(R.id.btn1);
        mbtnclick2=findViewById(R.id.btn2);

    }


    @Override
    public void onClick(View v) {
        int id=v.getId();
        switch (id){
            case R.id.btn1:
                Intent intent1=new Intent(MainActivity.this,JobService.class);
                intent1.putExtra("jobId","1");
                JobService.enqueueWork(MainActivity.this,intent1);
                break;
            case R.id.btn2:
                Intent intent2=new Intent(MainActivity.this,JobService.class);
                intent2.putExtra("jobId","2");
                JobService.enqueueWork(MainActivity.this,intent2);
                break;

        }
    }
}