package com.example.lifecycles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AsyncTaskActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);
        textView=findViewById(R.id.textView);
    }

    public void startTask(View view) {
        textView.setText("Istirahat");
        new SimpleAsyncTask(textView).execute();
    }
}