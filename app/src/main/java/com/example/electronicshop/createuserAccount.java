package com.example.electronicshop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class createuserAccount extends AppCompatActivity {
EditText createUsername;
EditText createpassword;
EditText createEmail;
Button createbutton;
TextView Alreadyhaveaccount;
FirebaseUser currentUser;
FirebaseAuth firebaseAuth;
FirebaseFirestore db = FirebaseFirestore.getInstance();
CollectionReference collectionReference = db.collection("User");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createuser_account);
        createUsername = findViewById(R.id.createUsername);
        createEmail = findViewById(R.id.createemail);
        createpassword = findViewById(R.id.createpassword);
        createbutton = findViewById(R.id.createbutton);
        Alreadyhaveaccount = findViewById(R.id.createtextView);
        firebaseAuth = FirebaseAuth.getInstance();
        createbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(createUsername.getText().toString()) || TextUtils.isEmpty(createEmail.getText().toString())
                        || TextUtils.isEmpty(createpassword.getText().toString())) {
                    Toast.makeText(createuserAccount.this, "All details are not filled by user", Toast.LENGTH_SHORT).show();
                }else{
                    firebaseAuth.createUserWithEmailAndPassword(createEmail.getText().toString(), createpassword.getText().toString())
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if(task.isSuccessful())
                                    {

                                        Toast.makeText(createuserAccount.this, "Account Created", Toast.LENGTH_SHORT).show();
                                        currentUser = firebaseAuth.getCurrentUser();
                                        assert currentUser!=null;
                                        String currentUserId = currentUser.getUid();
                                        Username obj = new Username();
                                        obj.setUsername(createUsername.getText().toString());
                                        obj.setCurrentUserId(currentUserId);

                                        collectionReference.add(obj)
                                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                                    @Override
                                                    public void onSuccess(DocumentReference documentReference) {

                                                    }
                                                }).addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                Toast.makeText(createuserAccount.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });

                                        startActivity(new Intent(createuserAccount.this,LoginAccount.class));

                                    }
                                }
                            });
                }
            }
        });
        Alreadyhaveaccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(createuserAccount.this,LoginAccount.class));
            }
        });
    }
}