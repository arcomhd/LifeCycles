package com.example.lifecycles;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> mTextView;
    SimpleAsyncTask(TextView textView){
        mTextView=new WeakReference<>(textView);
    }
    @Override
    protected String doInBackground(Void... voids) {
        Random r=new Random();
        int n=r.nextInt(11);
        int s=n * 200;
        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "Bangun setelah "+s+" ms";
    }
    @Override
    protected void onPostExecute(String s) {
        mTextView.get().setText(s);
    }
}
