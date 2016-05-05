package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Pt_ex extends AppCompatActivity {

    TextView line1,line2,line3,line4,line5,drag1,drag2;

    public void finishPt(View v){
        startActivity(new Intent(this,Geometry.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt_ex);
        line1 = (TextView)findViewById(R.id.line1);
        line2 = (TextView)findViewById(R.id.line2);
        line3 = (TextView)findViewById(R.id.line3);
        line4 = (TextView)findViewById(R.id.line4);
        line5 = (TextView)findViewById(R.id.line5);
        drag1 = (TextView)findViewById(R.id.drag1);
        drag2 = (TextView)findViewById(R.id.drag2);

        line1.setText(Html.fromHtml("c<sup>2 = a<sup>2 + b<sup>2"));
        line2.setText(Html.fromHtml("x<sup>2" + " = ______ "));
        line3.setText(Html.fromHtml("x<sup>2" + " = ______ "));
        line4.setText(Html.fromHtml("x = ______"));
        line5.setText("x = 10");
        drag1.setText(Html.fromHtml("6<sup>2" + " + " + "8<sup>2"));
        drag2.setText("36 + 64");
    }
}
