package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEtNumber;
    private Button mBtnFetch;
    private TextView mTvTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        IntentFilter intentFilter = new IntentFilter("com.example.api_calling_using_service");
        registerReceiver(serviceReceiver, intentFilter);
    }

    private void initViews() {
        mBtnFetch = findViewById(R.id.btnfetch);
        mEtNumber = findViewById(R.id.metnumber);
        mTvTitle = findViewById(R.id.tvtext);
        mBtnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ApiiService.class);
                intent.putExtra("input", Integer.parseInt(mEtNumber.getText().toString()));
                startService(intent);
            }
        });
    }

    private BroadcastReceiver serviceReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String Title = intent.getStringExtra("Title");
            mTvTitle.setText(Title);
            Toast.makeText(MainActivity.this, Title, Toast.LENGTH_SHORT).show();
        }
    };
}