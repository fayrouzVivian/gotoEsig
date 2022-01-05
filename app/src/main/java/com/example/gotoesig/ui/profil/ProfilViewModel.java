package com.example.gotoesig.ui.profil;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.gotoesig.LogInActivity;
import com.example.gotoesig.MainActivity;

public class ProfilViewModel extends ViewModel {

    private MutableLiveData<String> mNom;
    private MutableLiveData<String> mPrenom;
    private MutableLiveData<String> mTel;
    private MutableLiveData<String> mVille;
    private MutableLiveData<String> mScore;
    public ProfilViewModel() {

        mNom=new MutableLiveData<>();
        mNom.setValue("LogInActivity.user_id");
        mPrenom=new MutableLiveData<>();
        mPrenom.setValue("LogInActivity.user_id");
        mTel=new MutableLiveData<>();
        mTel.setValue("Tel1");
        mVille=new MutableLiveData<>();
        mVille.setValue("Ville1");
        mScore=new MutableLiveData<>();
        mScore.setValue("Score1");

    }

    public LiveData<String> getNom() {
        return mNom;
    }
    public LiveData<String> getPrenom() {return mPrenom;}
    public LiveData<String> getTel() {
        return mTel;
    }
    public LiveData<String> getVille() {
        return mVille;
    }
    public LiveData<String> getScore() {
        return mScore;
    }

}