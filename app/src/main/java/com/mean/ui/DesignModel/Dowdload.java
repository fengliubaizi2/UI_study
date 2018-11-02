package com.mean.ui.DesignModel;

import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import java.net.URL;

/**
 * Created by renzhenhua on 2017/10/26.
 */

public class Dowdload extends AsyncTask<URL,Integer,Long> {
    @Override
    protected Long doInBackground(URL... params) {
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Long aLong) {
        super.onPostExecute(aLong);
        Log.i("99","打印结果");
    }
}
