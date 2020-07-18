package com.example.capochordfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


public class second extends AppCompatActivity {
    ImageButton imgback;
    String arrMaj[]={"A Major","A Minor","A# Major","A# Minor","B Major","B Minor","C Major","C Minor","C# Major","C# Minor","D Major","D Minor","D# Major","D# Minor","E Major","E Minor","F Major","F Minor","F# Major","F# Minor","G Major","G Minor","G# Major","G# Minor"};

    TextView t1,t2;
    int result;
    ImageView i1,i2;
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        MobileAds.initialize(this,"ca-app-pub-9328722228252384~4289973578");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);



        imgback=(ImageButton)findViewById(R.id.back);
        t1=(TextView)findViewById(R.id.ans);
        t2=(TextView)findViewById(R.id.res);
        i1=(ImageView)findViewById(R.id.shopicon);
        i2=(ImageView)findViewById(R.id.rateicon);

        Bundle bundle=getIntent().getExtras();
        assert bundle !=null;
        int i=bundle.getInt("res1");
        int j=bundle.getInt("res2");

        switch (j){
            case 1: result=i+2;
            ch();
                break;
            case 2: result=i+4;ch();
                break;
            case 3: result=i+6;ch();
                break;
            case 4: result=i+8;ch();
                break;
            case 5: result=i+10;ch();
                break;
            case 6: result=i+12;ch();
                break;
            case 7: result=i+14;ch();
                break;
            case 8: result=i+16;ch();
                break;
            case 9: result=i+18;ch();
                break;
            case 10: result=i+20;ch();
                break;
            case 11: result=i+22;ch();
                break;
            case 12: result=i+24;ch();
                break;

            default: t1.setText("wrong");

        }

        t1.setText(arrMaj[i]+" on fret "+ j+" will be :");
        t2.setText(arrMaj[result]);




        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(second.this,first.class);
                startActivity(intent);
                finish();
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Intent.ACTION_VIEW);
                in.setData(Uri.parse("https://amzn.to/32kz9GL"));
                startActivity(in);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(second.this,"This Feature will be Available Soon",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ch(){
        if(result>=24){
            result=result-24;
        }
    }


}
