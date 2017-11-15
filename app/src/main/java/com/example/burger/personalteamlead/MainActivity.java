package com.example.burger.personalteamlead;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.burger.personalteamlead.Classes.ClassActivity;
import com.example.burger.personalteamlead.Classes.ClassFragment;
import com.example.burger.personalteamlead.Methods.MethodsFragment;
import com.example.burger.personalteamlead.Projects.ProjectFragment;
import com.example.burger.personalteamlead.utils.AddFragment;
import com.example.burger.personalteamlead.utils.FragmentsFalgs;

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
                        .replace(R.id.fragment, new AddFragment(id, parentName))
                        .commit();
                break;
            case METHOD:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, new MethodsFragment(parentName))
                        .commit();
                break;
            case CLASS:
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment, new ClassFragment(parentName))
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