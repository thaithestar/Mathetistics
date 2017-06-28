package com.example.thait.mathetistics;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Pt extends AppCompatActivity {

    TextView descrip,cSquare,aSquare,bSquare,partDrag;
    Button bn6;

    public void ptNext(View v){
        startActivity(new Intent(this,Pt_ex.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pt);
        descrip = (TextView)findViewById(R.id.des);
        cSquare = (TextView)findViewById(R.id.textView9);
        aSquare = (TextView)findViewById(R.id.a_square);
        bSquare = (TextView)findViewById(R.id.b_square);
        partDrag = (TextView)findViewById(R.id.textView10);
        bn6 = (Button)findViewById(R.id.button6);
        cSquare.setText(Html.fromHtml("c<sup>2"));
        aSquare.setText(Html.fromHtml("a<sup>2"));
        bSquare.setText(Html.fromHtml("b<sup>2"));
        partDrag.setText(Html.fromHtml("c<sup>2"));
        String ptDes = "Pythagorean theorem is a theorem that states that IF a triangle is a RIGHT " +
                        "triangle, then the length of the hypotenuse can be calculated by taking " +
                        "the square root of the sum of the two other sides squared. Note: formula " +
                        "can also be used to find one of the side too.";
        descrip.setText(ptDes);
    }
}
