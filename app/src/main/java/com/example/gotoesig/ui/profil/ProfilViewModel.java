package com.example.gotoesig.ui.profil;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gotoesig.LaunchActivity;
import com.example.gotoesig.LogInActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

public class ProfilViewModel extends ViewModel {

    private MutableLiveData<String> city;
    private MutableLiveData<String> email;
    private MutableLiveData<String> firstName;
    private MutableLiveData<String> lastName;
    private MutableLiveData<String> phone;
    private MutableLiveData<String> score;
    public ProfilViewModel() {
        city = new MutableLiveData<>();
        email = new MutableLiveData<>();
        firstName = new MutableLiveData<>();
        lastName = new MutableLiveData<>();
        phone = new MutableLiveData<>();
        score = new MutableLiveData<>();

        //Recupérer l'instance du doc ayant pour id id
        DocumentReference user = LaunchActivity.db.collection("users").document(LogInActivity.user_id) ;
        //Recuperation des données
        user.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if(task.isSuccessful()) {
                    city.setValue(task.getResult().get("city").toString());
                    email.setValue(task.getResult().get("email").toString());
                    firstName.setValue(task.getResult().get("firstName").toString());
                    lastName.setValue(task.getResult().get("lastName").toString());
                    phone.setValue(task.getResult().get("phone").toString());
                    score.setValue(task.getResult().get("score").toString());
                } else {
                    Log.d("Appi", "Erreur : " + task.getException() ) ;
                }
            }
        });
    }
    public LiveData<String> getCity() {return city;}
    public LiveData<String> getEmail() {return email;}
    public LiveData<String> getFirstName() {return firstName;}
    public LiveData<String> getLastName() {return lastName;}
    public LiveData<String> getPhone() {return phone;}
    public LiveData<String> getScore() {return score;}
}