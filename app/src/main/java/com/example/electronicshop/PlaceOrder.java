package com.example.electronicshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

import static com.example.electronicshop.MyProductAdapter.value;

public class PlaceOrder extends AppCompatActivity implements PaymentResultListener {
    Button paybtn;
    TextView paytxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_place_order);
        Checkout.preload(getApplicationContext());
        paytxt = findViewById(R.id.paytxt);
        paybtn=(Button)findViewById(R.id.paybtn);

        paybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                makepayment();
            }
        });
    }

    private void makepayment() {
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_fxsJsMixpYIpTw");

        checkout.setImage(R.drawable.backgroundes);
        final Activity activity = this;

        try {
            Model obj = new Model();
            JSONObject options = new JSONObject();

            options.put("name", "Prakhar Rathore");
            options.put("description", "Reference No. #123456");
            options.put("image", "https://s3.amazonaws.com/rzp-mobile/images/rzp.png");
            // options.put("order_id", "order_DBJOWzybf0sJbb");//from response of step 3.
            options.put("theme.color", "#3399cc");
            options.put("currency", "INR");
       //
          //  int y = 740000;
            options.put("amount", value*100);//300 X 100
            options.put("prefill.email", "prakhar.r786@gmail.com");
            options.put("prefill.contact","7697056251");
            checkout.open(activity, options);
        } catch(Exception e) {
            Log.e("TAG", "Error in starting Razorpay Checkout", e);
        }
    }
    @Override
    public void onPaymentSuccess(String s) {
        paytxt.setText("successful payment ID:"+s);
    }

    @Override
    public void onPaymentError(int i, String s) {
       paytxt.setText("failed and cause is:"+s);
    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    Toast.makeText(this, "Order Placed Sucessfull", Toast.LENGTH_SHORT).show();
                    break;

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu2,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.signout:
            {
               startActivity(new Intent(PlaceOrder.this,MainActivity.class));
               break;
            }
            case R.id.contshop:
            {
                startActivity(new Intent(PlaceOrder.this,RecylerView.class));
               break;
            }
        }
        return super.onOptionsItemSelected(item);
    }


}