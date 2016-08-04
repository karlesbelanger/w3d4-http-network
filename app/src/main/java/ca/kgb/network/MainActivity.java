package ca.kgb.network;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public void DoMagic(View view) {
        String url = "http://www.mocky.io/v2/57a01bec0f0000c10d0f650f";
        HttpURLConnection httpURLConnection = null;

        try {
            URL urlFormated = new URL(url);
            httpURLConnection = (HttpURLConnection)urlFormated.openConnection();
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());

            Scanner scanner = new Scanner(inputStream);
            StringBuilder stringBuilder = new StringBuilder();

            while (scanner.hasNext()) {
                stringBuilder.append(scanner.next());
            }

            Log.d(TAG, "DoMagic: " + stringBuilder.toString());
//            while (scanner.hasNext()) {
//                Log.d(TAG, "DoMagic: " + scanner.next());
//            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
