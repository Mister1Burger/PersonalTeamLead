package com.example.burger.personalteamlead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.burger.personalteamlead.Fragments.ClassFragment;
import com.example.burger.personalteamlead.Fragments.MethodsFragment;
import com.example.burger.personalteamlead.Fragments.ProjectFragment;
import com.example.burger.personalteamlead.Fragments.AddFragment;
import com.example.burger.personalteamlead.Fragments.FragmentsFalgs;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .replace(R.id.fragment, new ProjectFragment())
                .commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
    }



    public void getFragment(FragmentsFalgs flag, int id, String parentName) {
        switch (flag) {
            case ADD:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, new AddFragment(id,parentName,flag))
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
                        .replace(R.id.fragment, new ProjectFragment(flag))
                        .commit();
                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


    }
}