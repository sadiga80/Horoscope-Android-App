package com.appsan.santhoshadigau.dailyhoroscope2018;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageButton;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton a,b,c,d,e,f,g,h,i,j,k,l;
    boolean connected,online;
    ProgressDialog pro;
    private AdView mAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        MobileAds.initialize(this, "ca-app-pub-4222568229171852~6596966978");

        check chk=new check();
        chk.execute();
        init();

    }

    public class check extends AsyncTask<Void, Void, Void>{

        ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            dialog.setMessage("Please Wait");
            dialog.setIndeterminate(false);
            dialog.setCancelable(false);
            dialog.setCanceledOnTouchOutside(false);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.show();
            super.onPreExecute();

        }

        @Override
        protected Void doInBackground(Void... params) {
            // TODO Auto-generated method stub
            if(isOnline())
                connected=true;
            else
                connected=false;
            return null;
        }
        @Override
        protected void onPostExecute(Void result) {
            // TODO Auto-generated method stub
            if(dialog != null && dialog.isShowing()){
                dialog.dismiss();
            }
            if(!connected){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Error")
                        .setMessage("Check Connection")
                        .setCancelable(false)
                        .setNegativeButton("Exit", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // TODO Auto-generated method stub
                                finish();
                            }
                        }).show();
            }
            super.onPostExecute(result);

        }

    }

    private boolean isOnline() {
        if (isConnected()) {
            try {
                URL url = new URL("http://www.google.com");  // or any valid link.
                HttpURLConnection urlc = (HttpURLConnection) url.openConnection();
                urlc.setConnectTimeout(3000);
                urlc.connect();
                if (urlc.getResponseCode() == 200) {
                    return true;
                }
                else
                    return false;
            } catch (MalformedURLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean isConnected() {
        // TODO Auto-generated method stub
        ConnectivityManager cm =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        }
        return false;

    }
    private void init() {
        a=(ImageButton)findViewById(R.id.aries);
        b=(ImageButton)findViewById(R.id.taurus);
        c=(ImageButton)findViewById(R.id.gemini);
        d=(ImageButton)findViewById(R.id.cancer);
        e=(ImageButton)findViewById(R.id.leo);
        f=(ImageButton)findViewById(R.id.virgo);
        g=(ImageButton)findViewById(R.id.libra);
        h=(ImageButton)findViewById(R.id.scorpio);
        i=(ImageButton)findViewById(R.id.sagittarius);
        j=(ImageButton)findViewById(R.id.capricorn);
        k=(ImageButton)findViewById(R.id.aquarius);
        l=(ImageButton)findViewById(R.id.pisces);
        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        d.setOnClickListener(this);
        e.setOnClickListener(this);
        f.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        i.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);
        l.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            aboutDialog();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        switch(view.getId()){
            case R.id.aries:
                i=new Intent(MainActivity.this,AriesActivity.class);
                startActivity(i);
                break;
            case R.id.taurus:
                i=new Intent(MainActivity.this,TaurusActivity.class);
                startActivity(i);
                break;
            case R.id.gemini:
                i=new Intent(MainActivity.this,GeminiActivity.class);
                startActivity(i);
                break;
            case R.id.cancer:
                i=new Intent(MainActivity.this,CancerActivity.class);
                startActivity(i);
                break;
            case R.id.leo:
                i=new Intent(MainActivity.this,LeoActivity.class);
                startActivity(i);
                break;
            case R.id.virgo:
                i=new Intent(MainActivity.this,VirgoActivity.class);
                startActivity(i);
                break;
            case R.id.libra:
                i=new Intent(MainActivity.this,LibraActivity.class);
                startActivity(i);
                break;
            case R.id.scorpio:
                i=new Intent(MainActivity.this,ScorpioActivity.class);
                startActivity(i);
                break;
            case R.id.sagittarius:
                i=new Intent(MainActivity.this,SagittariusActivity.class);
                startActivity(i);
                break;
            case R.id.capricorn:
                i=new Intent(MainActivity.this,CapricornActivity.class);
                startActivity(i);
                break;
            case R.id.aquarius:
                i=new Intent(MainActivity.this,AquariusActivity.class);
                startActivity(i);
                break;
            case R.id.pisces:
                i=new Intent(MainActivity.this,PiscesActivity.class);
                startActivity(i);
                break;
        }
    }
    private void aboutDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("About");
        final WebView webView = new WebView(this);
        String about = "<p>1.0.0</p>" +
                "<p> Developed by AppSan Technologies</p>" +
                "<p>A lightweight, opensource Horoscope app.</p>" +
                "<p>Developed by <a href='mailto:t.sadiga80@gmail.com'>Santhosh Adiga U</a></p>" +
                "<p>Data provided by <a href='http://feeds.feedburner.com/'>Feed Burner</a>" ;
        TypedArray ta = obtainStyledAttributes(new int[]{android.R.attr.textColorPrimary, R.attr.colorAccent});
        String textColor = String.format("#%06X", (0xFFFFFF & ta.getColor(0, Color.BLACK)));
        String accentColor = String.format("#%06X", (0xFFFFFF & ta.getColor(1, Color.BLUE)));
        ta.recycle();
        about = "<style media=\"screen\" type=\"text/css\">" +
                "body {\n" +
                "    color:" + textColor + ";\n" +
                "}\n" +
                "a:link {color:" + accentColor + "}\n" +
                "</style>" +
                about;
        webView.setBackgroundColor(Color.WHITE);
        webView.loadData(about, "text/html", "UTF-8");
        alert.setView(webView);
        alert.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

            }
        });
        alert.show();
    }
}
