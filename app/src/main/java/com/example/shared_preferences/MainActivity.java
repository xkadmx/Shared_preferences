package com.example.shared_preferences;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new AsyncTest().execute("Wesolych", "swiat");
    }
    private class AsyncTest extends AsyncTask<String, String, String>{
        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Pobieranie");
            super.onPreExecute();
        }

        @Override/*runs after doInBackground()*/
        protected void onPostExecute(String aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override /* runs in WORKER */
        protected String doInBackground(String... voids) {
            return null;
        }
    }
}
