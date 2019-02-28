package com.appsan.santhoshadigau.dailyhoroscope2018;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
/**
 * Created by santhoshadigau on 12/03/18.
 */
public class AriesActivity extends Activity {
    TextView tv,tv1,tv2;
    ImageView iv;
    Boolean connected;
    private AdView mAdView;
    private String finalUrl="http://feeds.feedburner.com/AstroSageAries?format=xml";
    private HandleXML obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.common_activity);
        init();
        tv.setText(R.string.Aries);
        iv.setBackgroundResource(R.drawable.aries);
        mAdView = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        MobileAds.initialize(this, "ca-app-pub-8426956179579553~7416219500");
        fetch();
    }

    private void init() {
        tv=(TextView)findViewById(R.id.textView);
        tv1=(TextView)findViewById(R.id.textView1);
        tv2=(TextView)findViewById(R.id.textView2);
        iv=(ImageView)findViewById(R.id.imageView);
    }

    public void fetch(){
        obj = new HandleXML(finalUrl);
        obj.fetchXML();
        while(obj.parsingComplete);
        tv1.setText(obj.getTitle());
        tv2.setText(obj.getDescription());
    }
}
