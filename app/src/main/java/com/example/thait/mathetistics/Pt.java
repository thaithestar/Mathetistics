package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Pt extends AppCompatActivity {

    TextView descrip,formula,partDrag;

    public void ptNext(View v){
        startActivity(new Intent(this,Pt_ex.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt);
        descrip = (TextView)findViewById(R.id.des);
        formula = (TextView)findViewById(R.id.textView9);
        partDrag = (TextView)findViewById(R.id.textView10);
        formula.setText(Html.fromHtml("c<sup>2") + " = " + Html.fromHtml("a<sup>2") +
                         " + " + Html.fromHtml("b<sup>2") + "\nOR" );
        partDrag.setText(Html.fromHtml("c<sup>2 = _______"));
        String ptDes = "Pythagorean theorem is a theorem that states that IF a triangle is a RIGHT " +
                        "triangle, then the length of the hypotenuse can be calculated by taking " +
                        "the square root of the sum of the two other sides squared. Note: formula " +
                        "can also be used to find one of the side too.";
        descrip.setText(ptDes);
    }
}
