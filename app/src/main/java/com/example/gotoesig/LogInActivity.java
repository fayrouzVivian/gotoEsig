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
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class ConnectionActivity extends AppCompatActivity {

    static FirebaseFirestore db = FirebaseFirestore.getInstance() ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connection);

        EditText mailFieldTxt = findViewById(R.id.mailField) ;
        EditText passwdFieldTxt = findViewById(R.id.passwdField) ;
        Button logInBtn = findViewById(R.id.logInBtn) ;

        logInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mail = mailFieldTxt.getText().toString(), passwd = passwdFieldTxt.getText().toString();

                if (mail == null || mail.equals("") || passwd == null || passwd.equals("")) {
                    Toast.makeText(ConnectionActivity.this, "All credentials are needed", Toast.LENGTH_LONG).show();
                } else {
                    // Create a reference to the users collection
                    CollectionReference usersRef = db.collection("users") ;
                    //Get if exists, the unique user with this mail
                    Query query = usersRef.whereEqualTo("email", mail) ;
                    query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<QuerySnapshot> task) {
                            if( task.isSuccessful()) {
                                int comptor=0 ;
                                for (QueryDocumentSnapshot doc : task.getResult()) {
                                    comptor++ ;
                                    if(doc.getData().get("passwd").equals(passwd)) {
                                        //"Log in success");
                                        Intent nextIntent =new Intent(ConnectionActivity.this,MainActivity.class) ;
                                        startActivity(nextIntent);
                                    }
                                    else {
                                        //"Error ! Wrong password"
                                        Toast.makeText(ConnectionActivity.this, "Wrong password ! Try again", Toast.LENGTH_LONG).show();
                                    }
                                }
                                if(comptor==0) {
                                    //"There is no user with this email"
                                    Toast.makeText(ConnectionActivity.this, "No adress email found ! Try again or Sign up !", Toast.LENGTH_LONG).show();
                                }
                            }
                            else {
                                Toast.makeText(ConnectionActivity.this, "An error occured", Toast.LENGTH_LONG).show();
                                Log.d("Appi", "Erreur : " + task.getException() ) ;
                            }
                        }
                    });
                }
            }
        });

    }
}