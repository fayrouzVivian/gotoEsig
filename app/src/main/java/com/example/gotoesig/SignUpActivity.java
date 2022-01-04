package com.example.gotoesig;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.Map;

public class SignUpActivity extends AppCompatActivity {

    static FirebaseFirestore db = FirebaseFirestore.getInstance() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        EditText mailFieldTxt = findViewById(R.id.mailField_SU) ;
        EditText passwdFieldTxt = findViewById(R.id.passwdField_SU) ;
        EditText c_passwdFieldTxt = findViewById(R.id.c_passwdField_SU) ;
        EditText firstNameFieldTxt = findViewById(R.id.firstnameField) ;
        EditText lastNameFieldTxt = findViewById(R.id.lastnameField) ;
        Button signUpBtn = findViewById(R.id.signUpBtn) ;

        signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = mailFieldTxt.getText().toString(), passwd = passwdFieldTxt.getText().toString(),
                        c_passwd = c_passwdFieldTxt.getText().toString(), firstName = firstNameFieldTxt.getText().toString(),
                        lastName = lastNameFieldTxt.getText().toString();
                if(mail == null || mail.equals("") || passwd == null || passwd.equals("") ||
                        c_passwd == null || c_passwd.equals("") || firstName == null || firstName.equals("") ||
                        lastName == null || lastName.equals("") ) {
                    Toast.makeText(SignUpActivity.this, "All informations are required", Toast.LENGTH_LONG).show();
                }
                else {
                    if (!passwd.equals(c_passwd)) {
                        Toast.makeText(SignUpActivity.this, "Different passwords ! Enter the same", Toast.LENGTH_LONG).show();
                    }
                    else {
                        // Create a reference to the users collection
                        CollectionReference usersRef = db.collection("users") ;
                        //Check if the mails is already taken by an unique user
                        Query query = usersRef.whereEqualTo("email", mail) ;
                        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                                if( task.isSuccessful()) {
                                    int comptor=0 ;
                                    for (QueryDocumentSnapshot doc : task.getResult()) {
                                        comptor++ ;
                                    }
                                    if(comptor==0) {
                                        Map<String, Object> newUser = new HashMap<>() ;
                                        newUser.put("email", mail) ;
                                        newUser.put("firstName", firstName) ;
                                        newUser.put("lastName", lastName) ;
                                        newUser.put("passwd", passwd) ;

                                        db.collection("users").document().set(newUser)
                                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                    @Override
                                                    public void onSuccess(Void unused) {
                                                        Toast.makeText(SignUpActivity.this, "Great ! New Sign up !", Toast.LENGTH_LONG).show();
                                                    }
                                                })
                                                .addOnFailureListener(new OnFailureListener() {
                                                    @Override
                                                    public void onFailure(@NonNull Exception e) {
                                                        Toast.makeText(SignUpActivity.this, "Sorry ! There was an error !", Toast.LENGTH_LONG).show();
                                                    }
                                                });
                                    }
                                    else {
                                        //"There is one user with this email"
                                        Toast.makeText(SignUpActivity.this, "Sorry but this email is already taken!  Try again", Toast.LENGTH_LONG).show();
                                    }
                                }
                                else {
                                    Toast.makeText(SignUpActivity.this, "An error occured", Toast.LENGTH_LONG).show();
                                    Log.d("Appi", "Erreur : " + task.getException() ) ;
                                }
                            }
                        });

                    }
                }
            }
        });

    }
}