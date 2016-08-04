package ca.kgb.network;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by admin on 8/4/2016.
 */
public class NamesTask extends AsyncTask<String, Void, String> {
    private static final String TAG = NamesTask.class.getSimpleName();
    private TextView mTextView;
    private MainActivity mainActivity;

    public NamesTask(TextView textView){
        mTextView = textView;
    }

    public NamesTask(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    protected String doInBackground(String... strings) {
        String url = "http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";
        HttpURLConnection httpURLConnection = null;
        //textView = (TextView)findViewById(R.id.updateTV);

        try {
            URL urlFormated = new URL(url);
            httpURLConnection = (HttpURLConnection)urlFormated.openConnection();
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());

            Scanner scanner = new Scanner(inputStream);
            StringBuilder stringBuilder = new StringBuilder();

            while (scanner.hasNext()) {
                stringBuilder.append(scanner.next());
            }
            return stringBuilder.toString();
          //  textView.setText(stringBuilder.toString());
            //Log.d(TAG, "DoMagic: " + stringBuilder.toString());
//            while (scanner.hasNext()) {
//                Log.d(TAG, "DoMagic: " + scanner.next());
//            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }

        return "";
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: " + s);
//        mTextView.setText(s);
        mainActivity.loadData(s);
    }

}
