package com.example.burger.personalteamlead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.burger.personalteamlead.Controller.MainActivityControllerImpl;
import com.example.burger.personalteamlead.Fragments.ClassFragment;
import com.example.burger.personalteamlead.Fragments.FragmentsFlags;
import com.example.burger.personalteamlead.Fragments.MethodsFragment;
import com.example.burger.personalteamlead.Modules.RealmModule.RealmPTLImpl;
import com.example.burger.personalteamlead.TMP.TmpData;


public class MainActivity extends AppCompatActivity {
    MainActivityControllerImpl mAC;



    public MainActivityControllerImpl getMAC() {
        return mAC;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAC = new MainActivityControllerImpl();
        mAC.init( this);

        getFragmentManager().beginTransaction()
                .replace(R.id.fragment, mAC.getProjectFragment())
                .commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    public void getFragment(FragmentsFlags flag, int id, String parentName) {
        mAC.getTmpData().setId(id);
        mAC.getTmpData().setFlag(flag);
        mAC.getTmpData().setParentName(parentName);
        switch (flag) {
            case ADD:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, mAC.getAddFragment())
                        .commit();
                break;
            case METHOD:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, new MethodsFragment())
                        .commit();
                break;
            case CLASS:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, new ClassFragment())
                        .commit();
                break;
            case PROJECT:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, mAC.getProjectFragment())
                        .commit();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}