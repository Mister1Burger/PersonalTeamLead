package com.example.burger.personalteamlead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;


import com.example.burger.personalteamlead.Controller.MainActivityControllerImpl;
import com.example.burger.personalteamlead.Fragments.ClassFragment;
import com.example.burger.personalteamlead.Fragments.FragmentsFlags;
import com.example.burger.personalteamlead.Fragments.MethodsFragment;
import com.example.burger.personalteamlead.Fragments.PreviousFragment;


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

        PreviousFragment previousFragment = mAC.getFragmentMap().previousFragment();
        if (previousFragment.getFlag()!= FragmentsFlags.PROJECT){
                getFragment(previousFragment.getFlag(),previousFragment.getId(),previousFragment.getParentName());
        Log.d("TAG",String.valueOf(previousFragment.getFlag()));
        Log.d("TAG", String.valueOf(mAC.getFragmentMap().getFragmentsQuantity()));}
        else  if (previousFragment.getFlag() == FragmentsFlags.PROJECT ){
            getFragment(FragmentsFlags.PROJECT,0,"");
              Log.d("TAG",String.valueOf(previousFragment.getFlag()));
              Log.d("TAG", String.valueOf(mAC.getFragmentMap().getFragmentsQuantity()));}
        else {
            Log.d("TAG", String.valueOf(mAC.getFragmentMap().getFragmentsQuantity()));
            Log.d("TAG",String.valueOf(previousFragment.getFlag()) );
            finish();
        }

    }
}