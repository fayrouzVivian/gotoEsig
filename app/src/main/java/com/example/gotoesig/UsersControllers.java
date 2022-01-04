package com.example.gotoesig;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

public class UsersControllers {
    static FirebaseFirestore db = FirebaseFirestore.getInstance() ;
    static public void getUserById(String id) {
        //FirebaseFirestore db = FirebaseFirestore.getInstance() ;
        //Recupérer l'instance du doc ayant pour id id
        DocumentReference user = db.collection("users").document(id) ;
        //Recuperation des données
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()) {
                    Log.d("Appi", "Mon email : " + task.getResult().get("email") ) ;
                    Log.d("Appi", "My password : " + task.getResult().get("passwd") ) ;
                } else {
                    Log.d("Appi", "Erreur : " + task.getException() ) ;
                }
            }
        });
    }
    static  public void getAllUsers(String mail) {
        //FirebaseFirestore db = FirebaseFirestore.getInstance() ;
        CollectionReference usersRef = db.collection("users") ;

        //Log.d("Appi", usersRef.get().getResult().toString());

        Query query = usersRef.whereEqualTo("email", mail) ;
        query.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()) {
                    Log.d("Appi", "!!!C'est ok ! ");
                    for (QueryDocumentSnapshot doc : task.getResult()) {
                        Log.d("Appi", doc.getId() + " => " + doc.getData().get("passwd")) ;
                    }
                    Log.d("Appi", "There is no user with this email : \n" ) ;
                }
                else {

                    Log.d("Appi", "Erreur : " + task.getException() ) ;
                }
            }
        });
    }
    static public int checkCredentials(String mail, String passwd) {
        final int[] returnValue = {-1};
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
                            returnValue[0] = 0 ;
                            //Log.d("Appi", "Log in success");

                        }
                        else {
                            returnValue[0] = -1 ;
                            //Log.d("Appi", "Error ! Wrong password");
                        }
                    }
                    if(comptor==0) {
                        returnValue[0] = -2 ;
                        Log.d("Appi", "w"+returnValue[0]);
                        //Log.d("Appi", "There is no user with this email : \n" ) ;
                    }
                }
                else {
                    returnValue[0] = -3 ;
                    //Log.d("Appi", "Erreur : " + task.getException() ) ;
                }
            }
        });
        Log.d("Appi", "p"+returnValue[0]);

        return returnValue[0];
    }
}
