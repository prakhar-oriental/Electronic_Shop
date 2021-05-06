package com.example.electronicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {
    ImageView pimg;
    TextView pheader;
    TextView pPrice;
    TextView pwarrenty;
    TextView preplacement;
     Button BuyNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);
      //  int newprice= Integer.parseInt(getIntent().getStringExtra("dprice"));
        pimg = findViewById(R.id.dimageView);
        pheader = findViewById(R.id.dname);
        pPrice = findViewById(R.id.dprice);
        pwarrenty = findViewById(R.id.warrenty);
        preplacement = findViewById(R.id.replacement);
        BuyNow = findViewById(R.id.buynowbutton);
        pimg.setImageResource(getIntent().getIntExtra("dimage",0));
        pheader.setText(getIntent().getStringExtra("dheader"));
        pPrice.setText(String.valueOf(getIntent().getIntExtra("dprice",0)));
        pwarrenty.setText(getIntent().getStringExtra("dwarrenty"));
        preplacement.setText(getIntent().getStringExtra("dreplacement"));
        BuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DescriptionActivity.this,fillYourDetails.class));
            }
        });
    }
}