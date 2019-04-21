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

        new AsyncTest().execute(20);
    }
    private class AsyncTest extends AsyncTask<Integer, String, Void>{
        private ProgressDialog dialog;

        @Override
        protected void onPreExecute() {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("Pobieranie");
            dialog.setMessage("Trwa pobieranie czekoladowych, wielkanocnych kalorii...");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.show(); /*showing dialog to the world!*/
        }

        @Override/*runs after doInBackground()*/
        protected void onPostExecute(Void aVoid) {
            dialog.cancel();/*hiding dialog after doInBackground execution*/

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }

        @Override /* runs in WORKER */
        protected Void doInBackground(Integer... voids) {
            for(int i = 0; i <= 10; i++){
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return null;
        }
    }
}
