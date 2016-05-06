package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Pt_ex extends AppCompatActivity {

    TextView line1a,line1b,line1c,line2,line3,line4,line5,drag1_1,drag1_2,drag2;

    public void finishPt(View v){
        startActivity(new Intent(this,Geometry.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt_ex);
        line1a = (TextView)findViewById(R.id.line1a);
        line1b = (TextView)findViewById(R.id.line1b);
        line1c = (TextView)findViewById(R.id.line1c);
        line2 = (TextView)findViewById(R.id.line2);
        line3 = (TextView)findViewById(R.id.line3);
        line4 = (TextView)findViewById(R.id.line4);
        line5 = (TextView)findViewById(R.id.line5);
        drag1_1 = (TextView)findViewById(R.id.drag1_1);
        drag1_2 = (TextView)findViewById(R.id.drag1_2);
        drag2 = (TextView)findViewById(R.id.drag2);

        line1a.setText(Html.fromHtml("a<sup>2"));
        line1b.setText(Html.fromHtml("b<sup>2"));
        line1c.setText(Html.fromHtml("c<sup>2"));
        line2.setText(Html.fromHtml("x<sup>2" + " = ______ "));
        line3.setText(Html.fromHtml("x<sup>2" + " = ______ "));
        line4.setText(Html.fromHtml("x = ______"));
        drag1_1.setText(Html.fromHtml("6<sup>2"));
        drag1_2.setText(Html.fromHtml("8<sup>2"));
        drag2.setText("36 + 64");
    }
}
