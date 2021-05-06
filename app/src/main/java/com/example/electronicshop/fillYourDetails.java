package com.example.electronicshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class fillYourDetails extends AppCompatActivity {
EditText fillname;
EditText filladdress;
EditText fillphone;
Button fillButton;
FirebaseAuth firebaseAuth;
FirebaseFirestore db = FirebaseFirestore.getInstance();
CollectionReference collectionReference = db.collection("Orderdetail");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_your_details);
        fillname = findViewById(R.id.fillname);
        filladdress =findViewById(R.id.fillmultiline);
        fillphone = findViewById(R.id.fillphone);
        fillButton = findViewById(R.id.fillbutton);
        String phoneno = fillphone.getText().toString().trim();
        fillButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(fillname.getText().toString())) {
                    Toast.makeText(fillYourDetails.this, "Name is not filled by user", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(filladdress.getText().toString())) {
                    Toast.makeText(fillYourDetails.this, "Address is not filled by user", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(fillphone.getText().toString())) {
                    Toast.makeText(fillYourDetails.this, "Phone is not filled by user", Toast.LENGTH_SHORT).show();
                }/*else if (phoneno.length()!=10) {
                    Toast.makeText(fillYourDetails.this, "Invalid Phone No", Toast.LENGTH_SHORT).show();
                }*/
                else {
                    Filldetails filldetails = new Filldetails();
                    Model model = new Model();

                    filldetails.setFillname(fillname.getText().toString());
                    filldetails.setFilladdress(filladdress.getText().toString());
                    filldetails.setFillphone(fillphone.getText().toString());
                    collectionReference.add(filldetails)
                            .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentReference> task) {
                                    if (task.isSuccessful()) {
                                        startActivity(new Intent(new Intent(fillYourDetails.this, PlaceOrder.class)));
                                    }

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(fillYourDetails.this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        });

    }
}