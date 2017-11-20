package com.example.burger.personalteamlead;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import com.example.burger.personalteamlead.Classes.ClassFragment;
import com.example.burger.personalteamlead.Methods.MethodsFragment;
import com.example.burger.personalteamlead.Projects.ProjectFragment;
import com.example.burger.personalteamlead.utils.AddFragment;
import com.example.burger.personalteamlead.utils.FragmentsFalgs;

public class MainActivity extends AppCompatActivity {
    DialogFragment dialogFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dialogFragment = new AddFragment();
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
                dialogFragment.show(getFragmentManager(),"tag");
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
                        .replace(R.id.fragment, new ProjectFragment())
                        .commit();
                break;

        }


    }

}