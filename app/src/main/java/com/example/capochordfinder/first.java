package com.example.capochordfinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class first extends AppCompatActivity {
    String arrMaj[]={"A Major","A Minor","A# Major","A# Minor","B Major","B Minor","C Major","C Minor","C# Major","C# Minor","D Major","D Minor","D# Major","D# Minor","E Major","E Minor","F Major","F Minor","F# Major","F# Minor","G Major","G Minor","G# Major","G# Major"};


    String fret[]={"1","2","3","4","5","6","7","8","9","10","11","12"};
    Spinner spin1,spin3;
    Button btn;
    int i,j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        spin1=(Spinner)findViewById(R.id.spin1);
        spin3=(Spinner)findViewById(R.id.spin3);
        final ArrayAdapter arrayAdapter1=new ArrayAdapter(this,R.layout.text,arrMaj);
        ArrayAdapter arrayAdapter3 =new ArrayAdapter(this,R.layout.text,fret);
        spin1.setAdapter(arrayAdapter1);
        spin3.setAdapter(arrayAdapter3);
        btn=(Button)findViewById(R.id.btnsumbit);



        spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String chord=((TextView)view).getText().toString();
                i= position;
                Toast.makeText(first.this,""+arrMaj[i],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String fret=((TextView)view).getText().toString();
                j=position+1;
                Toast.makeText(first.this,""+j+" Fret",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(first.this,second.class);
                intent.putExtra("res1",i);
                intent.putExtra("res2",j);
                startActivity(intent);


            }
        });
    }
}
